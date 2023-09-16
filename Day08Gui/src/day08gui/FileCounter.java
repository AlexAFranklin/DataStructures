package day08gui;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexandrafranklin
 */
public class FileCounter {
    
    File theFiles;
    File [] theDirectory;

    public FileCounter(File thePath) {
        this.theFiles = thePath;
        theDirectory = theFiles.listFiles();
    }
    
    public long nonRecursiveFileSizes() throws IOException{
        long fileSize = 0L;
        for (File file : theDirectory){
            fileSize += Files.size(file.toPath());
        }
        System.out.println(fileSize/1024);
       return fileSize/1024;
    }
    
      public long recursiveFileSize() throws IOException{
          long fileSize = 0L;
          System.out.println("The Main File Im In: " + theFiles.getName());
          for (File file : theDirectory){
              
              System.out.println("TheFileImIn: " +file.getName());
              if (!file.isDirectory()) {
                  fileSize += Files.size(file.toPath());
              } else {
                  fileSize += computeFileSize(file, fileSize);
              }
          }
          System.out.println(fileSize/1024);
        return fileSize/1024;
    }
      
      private long computeFileSize(File file, long fileSize) throws IOException{
          
          if (file == null){
              return 0;
          }
         if (file.isDirectory()) {
                      File [] files = file.listFiles();
         for (File newFile : files) {
             System.out.println("In recursion compute, this should be directory: " + file.getName());
             return computeFileSize(newFile, fileSize);
         }

         }
         
             System.out.println("Hello" + Files.size(file.toPath()));
             System.out.println("Name: " + file.getName());
               return Files.size(file.toPath()); 
      }
      
}

