import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class CSVLoad {
	private static ArrayList<Location> locations = new ArrayList();
	
	/*
	CSVLoad() throws IOException{
		locations = new ArrayList();
	}
	*/
	// csv���Ͽ��� �����͸� �о� ��� �����͸� ����Ѵ�.

	@SuppressWarnings("resource")
	public static void Read() throws IOException {
		      BufferedReader br;
		      String lineString;
		      
		      // csv���� �о����
		      //br = new BufferedReader(new FileReader("C://Users//dlgml//eclipse-workspace//POL//src//input.CSV"));
		      br = new BufferedReader(new FileReader("D://Education//Java-Mini-Project//Pol//input.CSV"));
		      
		      // �� ���� �׸� ���̹Ƿ� �ѱ��
		      br.readLine();
		      //locations = new ArrayList();
		      // ������ �� �پ� �о����
		      while((lineString = br.readLine()) != null) {
		         String[] splitedString;
		         LocalDate date;
		         Stat stat;
		         Location l;
		         
		         // ���� Line�� ','�� �ڸ���
		         // [0]: Date
		         // [1]: Location Name
		         // [2]: nppm 
		         // [3]: oppm 
		         // [4]: cppm 
		         // [5]: appm 
		         // [6]: dust 
		         // [7]: mdust 
		         splitedString = lineString.split(",", 8);

		         // �и��� ���ڿ����� �������� ��ġ�� ����ִ� ��� -1�� �ʱ�ȭ�Ѵ�.
		         for(int i = 2; i < splitedString.length; i++) {
		            if(splitedString[i].equals("")) {
		               splitedString[i] = "-1";
		            }
		         }
		         
		         
		         // �������� ������ ����
		         stat = new Stat(Double.parseDouble(splitedString[2]), Double.parseDouble(splitedString[3]), Double.parseDouble(splitedString[4]),
		               Double.parseDouble(splitedString[5]), Integer.parseInt(splitedString[6]), Integer.parseInt(splitedString[7]));
		         
		         // ���ڿ��� ǥ���� ��¥�� LocalDate�������� ��ȯ�ϰ�, ��� ������ ����
		         date = LocalDate.parse(splitedString[0], DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH));
		         l = new Location(date,splitedString[1], stat);
		         //System.out.println(l.getName() + l.getDate() + l.getStat());
		         
		         // ��ü �����Ϳ� ���� �����͸� �߰��Ѵ�.
		         locations.add(l);
		         System.out.println(locations.size());
		         System.out.println(l.getName() + l.getDate() + l.getStat());
		      }
		   }
	  	// ��ü �����Ϳ� ���� ���� ����� ��ȯ�Ѵ�.
	   public ArrayList<Location> getlocations() {
	      return locations;
	   }
	   
	   // �̸� �������� ����
	   public void sortName() {
	      locations.sort((x, y) -> x.getName().compareTo(y.getName()));
	   }
	   
	   // �Ű������� ���� ���������� �ִ�ġ�� ���� ������ ��ȯ�ϴ� �޼ҵ�
	   public Location maxstatLocation(String stat) {
	      Optional<Location> p = null;
	      
	      switch(stat) {
	      case "nppm":
	         p = locations.stream().reduce((p1, p2) -> p1.getStat().nppm > p2.getStat().nppm ? p1 : p2);
	         
	         break;
	      case "oppm":
	         p = locations.stream().reduce((p1, p2) -> p1.getStat().oppm > p2.getStat().oppm ? p1 : p2);
	         
	         break;
	      case "cppm":
	         p = locations.stream().reduce((p1, p2) -> p1.getStat().cppm > p2.getStat().cppm ? p1 : p2);
	         
	         break;
	      case "appm":
	         p = locations.stream().reduce((p1, p2) -> p1.getStat().appm > p2.getStat().appm ? p1 : p2);
	         
	         break;
	      case "dust":
	         p = locations.stream().reduce((p1, p2) -> p1.getStat().dust > p2.getStat().dust ? p1 : p2);
	         
	         break;
	      case "mdust":
	         p = locations.stream().reduce((p1, p2) -> p1.getStat().mdust > p2.getStat().mdust ? p1 : p2);
	         
	         break;
	      }
	      
	      return p.get();
	   }
	   
	   // �Ű������� ���� ���������� �ּ�ġ�� ���� ������ ��ȯ�ϴ� �޼ҵ�
	   public Location minstatLocation(String stat) {
	      Optional<Location> p = null;
	      
	      switch(stat) {
	      case "nppm":
	         p = locations.stream().filter(p1 -> p1.getStat().nppm != -1).reduce((p1, p2) -> p1.getStat().nppm < p2.getStat().nppm ? p1 : p2);
	         
	         break;
	      case "oppm":
	         p = locations.stream().filter(p1 -> p1.getStat().oppm != -1).reduce((p1, p2) -> p1.getStat().oppm < p2.getStat().oppm ? p1 : p2);
	         
	         break;
	      case "cppm":
	         p = locations.stream().filter(p1 -> p1.getStat().cppm != -1).reduce((p1, p2) -> p1.getStat().cppm < p2.getStat().cppm ? p1 : p2);
	         
	         break;
	      case "appm":
	         p = locations.stream().filter(p1 -> p1.getStat().appm != -1).reduce((p1, p2) -> p1.getStat().appm < p2.getStat().appm ? p1 : p2);
	         
	         break;
	      case "dust":
	         p = locations.stream().filter(p1 -> p1.getStat().dust != -1).reduce((p1, p2) -> p1.getStat().dust < p2.getStat().dust ? p1 : p2);
	         
	         break;
	      case "mdust":
	         p = locations.stream().filter(p1 -> p1.getStat().mdust != -1).reduce((p1, p2) -> p1.getStat().mdust < p2.getStat().mdust ? p1 : p2);
	         
	         break;
	      }
	      
	      return p.get();
	   }
}
