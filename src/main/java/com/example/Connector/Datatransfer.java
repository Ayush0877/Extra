package com.example.Connector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Datatransfer {
    public static void main(String[] args) {
        String content = "Hello, this is the content to be written to the file!";
        String filePath = "path/to/your/file.txt";

        try {
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println("String written to the file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

