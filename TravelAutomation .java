import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

public class TravelAutomation 
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("opening connection");
		//URL url = new URL("https://tsgs.unt.edu/sites/default/files/webform/College%20of%20Engineering-%20Travel.pdf");
		 FileReader urlname =new FileReader("C:/Users/silvi/Desktop/MS Folder/IRS/Project1_Silvia/urlnames.txt");
         BufferedReader urlreader = new BufferedReader(urlname);
         FileReader lastname =new FileReader("C:/Users/silvi/Desktop/MS Folder/IRS/Project1_Silvia/lastnames.txt");
         BufferedReader lastnamereader = new BufferedReader(lastname);
         String t =null;
         int count = 1;
         while((t = urlreader.readLine())!=null)
         {
         //	String queryword = topicscanner.next();
        	  try
        	 {
        	 URL url = new URL(t);
     		
         		
        	 InputStream in = url.openStream();
		     String last = lastnamereader.readLine();
        	 FileOutputStream fos = new FileOutputStream(new File(last+"_faculty_evaluation.pdf"));
        	 count++;
        	 System.out.println("reading from resource and writing to file...");
        	 int length = -1;
        	 byte[] buffer = new byte[1024];// buffer for portion of data from connection
        	 while ((length = in.read(buffer)) > -1) 
        	 {
        		 fos.write(buffer, 0, length);
        	 }
        	 fos.close();
	     		in.close();
	     		System.out.println(count);
         }catch(Exception e){e.printStackTrace();}
         }
     	urlreader.close();
     	urlname.close();
     	lastname.close();
     	lastnamereader.close();
	System.out.println("File downloaded");

	}
}
