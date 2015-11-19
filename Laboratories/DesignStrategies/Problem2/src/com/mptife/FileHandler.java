package com.mptife;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by piotr on 15.10.15.
 */
public class FileHandler {
    private String filePath;

    private PrintWriter pw;

    private File file;

    private FileWriter fw;

    FileHandler(String filePath){
        this.filePath = filePath;
        this.file = new File(filePath);
        try {
            fw = new FileWriter(file, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw = new PrintWriter(fw);
    }

    public void println(String line){
        pw.println(line);
    }

    public void close(){
        if (pw != null) {
            pw.close();
        }
    }
}
