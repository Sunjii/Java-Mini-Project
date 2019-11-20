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
	// csv파일에서 데이터를 읽어 모든 데이터를 등록한다.

	@SuppressWarnings("resource")
	public static void Read() throws IOException {
		      BufferedReader br;
		      String lineString;
		      
		      // csv파일 읽어오기
		      //br = new BufferedReader(new FileReader("C://Users//dlgml//eclipse-workspace//POL//src//input.CSV"));
		      br = new BufferedReader(new FileReader("D://Education//Java-Mini-Project//Pol//input.CSV"));
		      
		      // 한 줄은 항목 명이므로 넘기기
		      br.readLine();
		      //locations = new ArrayList();
		      // 끝까지 한 줄씩 읽어오기
		      while((lineString = br.readLine()) != null) {
		         String[] splitedString;
		         LocalDate date;
		         Stat stat;
		         Location l;
		         
		         // 읽은 Line을 ','로 자르기
		         // [0]: Date
		         // [1]: Location Name
		         // [2]: nppm 
		         // [3]: oppm 
		         // [4]: cppm 
		         // [5]: appm 
		         // [6]: dust 
		         // [7]: mdust 
		         splitedString = lineString.split(",", 8);

		         // 분리한 문자열에서 오염물질 수치가 비어있는 경우 -1로 초기화한다.
		         for(int i = 2; i < splitedString.length; i++) {
		            if(splitedString[i].equals("")) {
		               splitedString[i] = "-1";
		            }
		         }
		         
		         
		         // 오염물질 데이터 생성
		         stat = new Stat(Double.parseDouble(splitedString[2]), Double.parseDouble(splitedString[3]), Double.parseDouble(splitedString[4]),
		               Double.parseDouble(splitedString[5]), Integer.parseInt(splitedString[6]), Integer.parseInt(splitedString[7]));
		         
		         // 문자열로 표현된 날짜를 LocalDate형식으로 변환하고, 장소 데이터 생성
		         date = LocalDate.parse(splitedString[0], DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH));
		         l = new Location(date,splitedString[1], stat);
		         //System.out.println(l.getName() + l.getDate() + l.getStat());
		         
		         // 전체 데이터에 현재 데이터를 추가한다.
		         locations.add(l);
		         System.out.println(locations.size());
		         System.out.println(l.getName() + l.getDate() + l.getStat());
		      }
		   }
	  	// 전체 데이터에 대한 지역 목록을 반환한다.
	   public ArrayList<Location> getlocations() {
	      return locations;
	   }
	   
	   // 이름 오름차순 정렬
	   public void sortName() {
	      locations.sort((x, y) -> x.getName().compareTo(y.getName()));
	   }
	   
	   // 매개변수로 받은 오염물질의 최대치를 가진 지역을 반환하는 메소드
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
	   
	   // 매개변수로 받은 오염물질의 최소치를 가진 지역을 반환하는 메소드
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
