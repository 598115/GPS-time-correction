import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileHandler {

   private String hfilePath;
    private String vfilePath;
    private BufferedReader vreader;
    private BufferedReader hreader;
    private FileWriter writer;

    public CSVFileHandler(String vreadPath, String hreadPath, String writePath) {
         this.vfilePath = vreadPath;
         this.hfilePath = hreadPath;
         try {
            this.vreader = new BufferedReader(new FileReader(vreadPath));
            this.hreader = new BufferedReader(new FileReader(hreadPath));
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         }
         try {
            this.writer = new FileWriter(writePath, false);
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

public double readNextVline() {

 String value = "";
  try {
   value = vreader.readLine();
    if(value == null) {
        this.vreader = new BufferedReader(new FileReader(vfilePath)); 
        value = vreader.readLine();
         if(value == null) {
            System.err.println("ERROR: File is empty or filepath is incorrect");
            throw new FileNotFoundException();
         }
    }
  }
  catch(Exception e) {
      e.printStackTrace();
  }
  return Double.parseDouble(value);
 }

 public double readNextHline() {

   String value = "";
    try {
     value = hreader.readLine();
      if(value == null) {
          this.hreader = new BufferedReader(new FileReader(vfilePath)); 
          value = hreader.readLine();
           if(value == null) {
              System.err.println("ERROR: File is empty or filepath is incorrect");
              throw new FileNotFoundException();
           }
      }
    }
    catch(Exception e) {
        e.printStackTrace();
    }
    return Double.parseDouble(value);
   }

public void writeNextLine(String data) {
   try {
      writer.append(data);
      writer.append("\n");
   } catch (IOException e) {
      e.printStackTrace();
   }
}

public void flushWriter() {
   try {
      writer.flush();
   } catch (IOException e) {
     e.printStackTrace();
   }
}
public void close() {
   try {
      hreader.close();
      vreader.close();
      writer.close();
   } catch (IOException e) {
     e.printStackTrace();
   }
}

} 
