package assignment0;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class fileop{
void CreateFileDemo()
{
   	
      try {
	     File file = new File("D:\\Google Drive\\IITDH 5 sem\\Computer Architecture Lab\\Assignment 0\\datan.csv");
	     /*If file gets created then the createNewFile() 
	      * method would return true or if the file is 
	      * already present it would return false
	      */
             boolean fvar = file.createNewFile();
	     if (fvar){
	          System.out.println("File has been created successfully");
	     }
	     else{
	          System.out.println("File already present at the specified location");
	     }
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }
   
}
void AppendFileDemo(int t, double prob, int w, int wins)
{
   	
      try{
    
        //Specify the file name and path here
    	File file =new File("D:\\Google Drive\\IITDH 5 sem\\Computer Architecture Lab\\Assignment 0\\datan.csv");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
    	bw.write(t+","+prob+","+w+","+wins+"\n");
    	//Closing BufferedWriter Stream
//    	bw.close();

	System.out.println("Data successfully appended at the end of file");

      }catch(IOException ioe){
         System.out.println("Exception occurred:");
    	 ioe.printStackTrace();
       }
   
}
}