package es.upm.oeg.lab.helpers;

import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by cbadenes on 03/11/15.
 */
public class StorageHelperTest {

    private static final Logger logger = LoggerFactory.getLogger(StorageHelperTest.class);

    @Test
    public void saveAndReadFromScratch(){
        String directory = "target/dbs";
        Path dbPath = FileHelper.path(directory, "harvest.docs");
        DB db;
        if (dbPath.toFile().exists()){
            logger.info("DB exists: " + dbPath.toString());
            db = DBMaker.newFileDB(dbPath.toFile()).make();
        }else{
            dbPath = FileHelper.create(directory, "harvest.docs");
            logger.info("DB does not exist: " + dbPath.toString());
            DBMaker dbFile = DBMaker.newFileDB(dbPath.toFile());
            dbFile.closeOnJvmShutdown();
            db = dbFile.make();
            logger.info("Creating list: " + dbPath.toString());
            List<String> terms = Arrays.asList(new String[]{"one","two","three"});
            HTreeMap<Object, Object> map = db.createHashMap("test").make();
            map.put("terms",terms);
            db.commit();
            logger.info("list created");
        }

        logger.info("reading list ..");
        HTreeMap<Object, Object> map = db.getHashMap("test");
        List<String> terms = (List<String>) map.get("terms");
        logger.info("list read: " + terms);
        db.close();
    }

    @Test
    public void saveAndReadUsingHelper(){

        String type = "test";
        String id = "sample";

        Optional<Object> value = StorageHelper.read(type,id);

        if (!value.isPresent()){
            logger.info("value does not exist");
            StorageHelper.save(type,id, Arrays.asList(new String[]{"text", "sample"}));
            logger.info("value created");
            value = StorageHelper.read(type,id);
            logger.info("value read again");
        }

        List<String> terms = (List<String>) value.get();
        logger.info("Value read: " + terms);

        String id2 = "sample2";
        Optional<Object> value2 =  StorageHelper.read(type,id2);
        if (!value2.isPresent()){
            logger.info("value2 does not exist");
            StorageHelper.save(type,id2, Arrays.asList(new String[]{"text2", "sample"}));
            logger.info("value2 created");
            value2 = StorageHelper.read(type,id2);
            logger.info("value2 read again");
        }

        List<String> terms2 = (List<String>) value2.get();
        logger.info("Value2 read: " + terms2);

    }

    @Test
    public void read(){

        Optional<Set<Object>> valuesOp = StorageHelper.list("items");

        if (!valuesOp.isPresent()){
            logger.error("Empty DB");
            return;
        }

        for (Object key: valuesOp.get()){
            logger.info("Key: " + String.valueOf(key));
        }

    }
}
