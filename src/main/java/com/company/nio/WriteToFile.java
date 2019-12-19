package com.company.nio;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class WriteToFile<K,V> {
    private final static Logger LOGGER = Logger.getLogger(WriteToFile.class);
    private File file;


    public WriteToFile(File file) {
        this.file = file;
        if(this.file.exists()){
            this.file.delete();
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public   void writeStreamToFile(Map<K,V> maps) throws IOException {
        FileOutputStream fileOutputStream =  new FileOutputStream(file);
        try(OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(fileOutputStream)){
        maps.forEach((o1, o2) -> {
            try {
                outputStreamWriter.write(o1 + "  " + o2 + "\n");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        });}
        catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

}
