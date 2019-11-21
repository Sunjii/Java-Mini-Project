import java.io.*;
import java.util.*;

public class CSVWrite {
   public void Write() throws IOException{
      //PrintWriter pw = new PrintWriter("C://Users//dlgml//eclipse-workspace//POL//src//out.csv");
	   PrintWriter pw = new PrintWriter(".//CSV//output.CSV");
      for(Location stat : CSVLoad.locations) {
            String data = stat.getDate()+","+ stat.getName()+","+stat.getStat().nppm +","+ stat.getStat().oppm+","+stat.getStat().cppm
                  +","+stat.getStat().appm+","+stat.getStat().dust +","+stat.getStat().mdust;
            pw.println(data);
        }
   }
}