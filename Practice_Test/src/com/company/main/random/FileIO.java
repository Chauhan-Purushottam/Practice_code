package com.company.main.random;

import java.io.*;

public class FileIO {
    String directory = "/Users/sigmoid/Desktop";
    String fileName = "sample.txt";
    String absolutePath = directory + File.separator + fileName;

    public FileIO() throws IOException {
        System.out.println("Directory " + directory);
        System.out.println("FileName " + fileName);
        System.out.println("Absolute path " + absolutePath);
    }

    public void IO(){
        // write the content from file
//        try{
//            FileWriter fileWriter = new FileWriter(absolutePath);
//            String fileContent = "This is a sample text.";
//            fileWriter.write(fileContent);
//            fileWriter.close();
//        }catch(IOException e){
//            System.out.println("Exception occured in file write");
//        }

        // Read the content from file
        try
        {
            FileReader fileReader = new FileReader(absolutePath);
            int ch = fileReader.read();
            while (ch != -1) {
                System.out.print((char) ch);
                ch = fileReader.read();
            }
            fileReader.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found exception occured");
        }catch(IOException e){
            System.out.println("Exception occure in file read");
        }
    }
}
