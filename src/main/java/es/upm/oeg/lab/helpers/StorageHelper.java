package es.upm.oeg.lab.helpers;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.*;

/**
 * Created by cbadenes on 03/11/15.
 */
public class StorageHelper {

    private static final Logger logger = LoggerFactory.getLogger(StorageHelper.class);

    private static Map<String,DB> dbs = new HashMap<>();

    public static Optional<Object> read(String type, String key){
        String dbName = dbName(type);
        DB db = getDB(dbName);

        logger.debug("reading from " + dbName + ": '" + key + "'");
        Optional value = Optional.empty();
        try{
            if (db.exists(type)){
                return Optional.ofNullable(db.getHashMap(type).get(key));
            }
        }catch (Exception e){
            logger.error("Error reading from "+dbName+" the key: " + key,e);
        }
        return value;
    }

    public static Optional<Set<Object>> list(String type){
        String dbName = dbName(type);
        DB db = getDB(dbName);

        if (!db.exists(type)){
            return Optional.empty();
        }

        HTreeMap<Object, Object> map = db.getHashMap(type);
        return Optional.of(map.keySet());
    }

    public static void save(String type, String key, Object value){
        String dbName = dbName(type);
        DB db = getDB(dbName);

        logger.debug("saving to " + dbName + ": '" + key + "'");
        HTreeMap<Object, Object> map = (exists(dbName))? db.getHashMap(type): db.createHashMap(type).make();
        map.put(key, value);
        db.commit();
    }

    public static String dbName(String type){
        return type+".db";
    }

    private static DB getDB(String dbId){
        if (!dbs.containsKey(dbId)){
            dbs.put(dbId,createDB(dbId));
        }
        return dbs.get(dbId);
    }

    public static boolean exists(String dbName){
        return FileHelper.path(ResultHelper.DIRECTORY, dbName).toFile().exists();
    }


    public static DB createDB(String dbId){
        Path dbPath = FileHelper.path(ResultHelper.DIRECTORY, dbId);
        DB db;
        if (dbPath.toFile().exists()){
            logger.info("DB exists: " + dbPath.toString());
            db  = DBMaker.newFileDB(dbPath.toFile()).make();
        }else{
            dbPath = FileHelper.create(ResultHelper.DIRECTORY, dbId);
            logger.info("DB does not exist: " + dbPath.toString());
            DBMaker dbFile = DBMaker.newFileDB(dbPath.toFile());
            dbFile.closeOnJvmShutdown();
            db = dbFile.make();
        }
        return db;
    }

}
