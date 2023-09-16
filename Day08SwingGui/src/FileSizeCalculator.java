
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexandrafranklin
 */
public class FileSizeCalculator {
    
    File theDirectory;

    public FileSizeCalculator(File theDirectory) {
        this.theDirectory = theDirectory;
    }
    
    public long nonRecursiveFileSizes() {
        long fileSize = 0L;
        File [] theFiles = theDirectory.listFiles();
        for (File file : theFiles){
            fileSize += file.length();
            System.out.println(file.length());
        }
        return fileSize/1024L;
    }
    
    
    
    public long recursiveFileSize()  throws IOException {
          long fileSize = 0L;
          File [] theFiles = theDirectory.listFiles();
          for (File file : theFiles){
              if (!file.isDirectory()) {
                  fileSize += file.length();
              } else {
                  fileSize += computeFileSize(file, fileSize);
              }
          }
        return fileSize/1024;
    }
      
      private long computeFileSize(File file, long fileSize) throws IOException{
          if (file == null){
              return 0;
          } if (!file.isDirectory()) {
              return file.length();
          }
           File [] theFiles = file.listFiles();
         for (File newFile : theFiles) {
             fileSize += computeFileSize(newFile, fileSize);
         }
         return 0;
      }

    String getName() {
        return theDirectory.getName();
    }
    
    
    
    
}
