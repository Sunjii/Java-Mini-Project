import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OuputDatabase{
   private static final String URL = 
         "jdbc:mysql://localhost:3306/j_stat?characterEncoding=UTF-8&serverTimezone=UTC";
   private static final String ID = "lee";
   private static final String PW = "123123123";
   private static Connection connection = null;
   
   OuputDatabase() throws SQLException{
      Connect_Database();
   }
   
   void Connect_Database() throws SQLException {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         System.out.println("Success Driver Load");
      } catch(ClassNotFoundException e) {
         System.out.println("Fail Driver Load: " + e.getMessage());
      }
      
      connection = DriverManager.getConnection(URL, ID, PW);
   }
   
   public static Connection getConnection() {
      return connection;
   }
   
   // DB에서 프로그램으로 데이터를 불러오는 메소드
   public static ArrayList<Location> SaveData() {
      String sql;
      PreparedStatement pstmt;
      ResultSet rs;
      ArrayList<Location> from_DB = null;
      
      sql = "SELECT * FROM j_stat";
      
      try {
         pstmt = getConnection().prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         // 모든 항목을 가져온다
         while(rs.next()) {
            Location p;
            Stat stat;
            LocalDate date;
            
            stat = new Stat(Double.parseDouble(rs.getString("이산화질소")), Double.parseDouble(rs.getString("오존농도")), Double.parseDouble(rs.getString("이산화탄소"))
                  , Double.parseDouble(rs.getString("아황산가스")), Integer.parseInt(rs.getString("미세먼지")), Integer.parseInt(rs.getString("초미세먼지")));
            
            date = LocalDate.parse(rs.getString("날짜"), DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
            p = new Location(date, rs.getString("지역"),  stat);
            
            from_DB.add(p);
         }
         
         pstmt.close();
         rs.close();
      } catch(SQLException e) {
         System.out.println("DB 데이터 불러오기 실패: " + e.getMessage());
      }
      return from_DB;
   }
}

















/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OuputDatabase{
   private static final String URL = 
         "localhost:1521/xe";
   private static final String ID = "lee";
   private static final String PW = "practice";
   private Connection connection = null;
   
   OuputDatabase() throws SQLException{
      Connect_Database();
   }
   
   void Connect_Database() throws SQLException {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         System.out.println("Success Driver Load");
      } catch(ClassNotFoundException e) {
         System.out.println("Fail Driver Load: " + e.getMessage());
      }
      
      connection = DriverManager.getConnection(URL, ID, PW);
   }
   
   public Connection getConnection() {
      return connection;
   }
   
   // DB에서 프로그램으로 데이터를 불러오는 메소드
   public void saveData(ArrayList<Location> Locations) {
      String sql;
      PreparedStatement pstmt;
      ResultSet rs;
      
      sql = "SELECT * FROM Stat";
      
      try {
         pstmt = getConnection().prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         // 모든 항목을 가져온다
         while(rs.next()) {
            Location p;
            Stat stat;
            LocalDate date;
            
            stat = new Stat(Double.parseDouble(rs.getString("nppm")), Double.parseDouble(rs.getString("oppm")), Double.parseDouble(rs.getString("cppm"))
                  , Double.parseDouble(rs.getString("appm")), Integer.parseInt(rs.getString("dust")), Integer.parseInt(rs.getString("mdust")));
            
            date = LocalDate.parse(rs.getString("Date"), DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
            p = new Location(date, rs.getString("Location"),  stat);
            
            Locations.add(p);
         }
         
         pstmt.close();
         rs.close();
      } catch(SQLException e) {
         System.out.println("DB 데이터 불러오기 실패: " + e.getMessage());
      }
   }
}

*/