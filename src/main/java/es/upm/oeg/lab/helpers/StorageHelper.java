package es.upm.oeg.lab.helpers;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cbadenes on 03/11/15.
 */
public class StorageHelper {

    private static final Logger logger  = LoggerFactory.getLogger(StorageHelper.class);

    public static String DIRECTORY      = "db";

    private static ConcurrentHashMap<String,DB> dbs = new ConcurrentHashMap<>();

    public synchronized  static Optional<Object> read(String type, String key){
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

    public synchronized  static Optional<Set<Object>> list(String type){
        String dbName = dbName(type);
        DB db = getDB(dbName);

        if (!db.exists(type)){
            return Optional.empty();
        }

        HTreeMap<Object, Object> map = db.getHashMap(type);
        return Optional.of(map.keySet());
    }

    public synchronized static void save(String type, String key, Object value){
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

    private synchronized static DB getDB(String dbId){
        if (!dbs.containsKey(dbId)){
            dbs.put(dbId,createDB(dbId));
        }
        return dbs.get(dbId);
    }

    public static boolean exists(String dbName){
        return FilesHelper.path(DIRECTORY, dbName).toFile().exists();
    }


    public synchronized static DB createDB(String dbId){
        Path dbPath = FilesHelper.path(DIRECTORY, dbId);
        DB db;
        if (dbPath.toFile().exists()){
            logger.debug("DB exists: " + dbPath.toString());
            db  = DBMaker.newFileDB(dbPath.toFile()).make();
        }else{
            dbPath = FilesHelper.create(DIRECTORY, dbId);
            logger.debug("DB does not exist: " + dbPath.toString());
            DBMaker dbFile = DBMaker.newFileDB(dbPath.toFile());
            dbFile.closeOnJvmShutdown();
            db = dbFile.make();
        }
        return db;
    }

}
