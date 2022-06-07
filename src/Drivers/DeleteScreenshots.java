package Drivers;

import java.io.File;

public class DeleteScreenshots {
  
	public static void main (String[] args) {
        String folder = ".\\Screenshots\\";
        //delete folder recursively
       delete(new File(folder));
    }
    
    public static void delete(File file) {
        //to end the recursive loop
        if (!file.exists())
            return;
        
        //if directory, go inside and call recursively
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                //call recursively
                delete(f);
            }
        }
        //call delete to delete files and empty directory
        file.delete();
        System.out.println("Deleted file/folder: "+file.getAbsolutePath());
    }
}
