package com.example.kotlinpractice;

import java.io.*;

public class JavaPrinter {


    public void filePrinter() throws IOException {
        File currentFile = new File(".");
        System.out.println(currentFile.getAbsoluteFile());
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
    }

    public void readFile(String path) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            System.out.println(bufferedReader.readLine());
        }
    }
}
