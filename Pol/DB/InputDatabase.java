import java.sql.*;
import java.util.ArrayList;

public class InputDatabase{
   private static final String URL = 
         "jdbc:mysql://localhost:3306/j_stat?characterEncoding=UTF-8&serverTimezone=UTC";
   private static final String ID = "lee";
   private static final String PW = "123123123";
   private static Connection connection = null;
   
   InputDatabase() throws SQLException{
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
   
   // DB�� �����͸� �����ϴ� �޼ҵ�
   public static void loadData(ArrayList<Location> Locations) {
      StringBuilder sql = new StringBuilder(); 
      PreparedStatement pstmt;
      sql.append("INSERT INTO j_stat (��¥, ����, �̻�ȭ����, ������, �̻�ȭź��, ��Ȳ�갡��, �̼�����, �ʹ̼�����)");   //Date, Location, nppm , oppm, cppm, appm, dust, mdust
      sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
      
      try {
         pstmt = getConnection().prepareStatement(sql.toString());
         
         // �����͸� �ϳ��� �̾� DB�� ����Ѵ�.
         for(Location p: Locations) {
            pstmt.setString(1, p.getDate().toString());
            pstmt.setString(2, p.getName());
            pstmt.setString(3, Double.toString(p.getStat().nppm ));
            pstmt.setString(4, Double.toString(p.getStat().oppm));
            pstmt.setString(5, Double.toString(p.getStat().cppm));
            pstmt.setString(6, Double.toString(p.getStat().appm));
            pstmt.setString(7, Integer.toString(p.getStat().dust));
            pstmt.setString(8, Integer.toString(p.getStat().mdust));
            pstmt.execute();
         }
         
         pstmt.close();
      } catch(SQLException e) {
         System.out.println("DB ������ ��� ����: " + e.getMessage());
      }
   }
   
   public static void alterData(ArrayList<Location> Locations) {
      StringBuilder sql = new StringBuilder();
      sql.append("truncate table j_stat");      //������ �����Ͽ��⶧���� ���� �����͸� ������. (�ʱ�ȭ �۾�)
      loadData(Locations);      //�׷� ���� �ٽ� �����͸� �����Ѵ�.
   }
}






/*
import java.sql.*;
import java.util.ArrayList;

public class InputDatabase{
   private static final String URL = 
         "jdbc:oracle:thin:@localhost:1521:xe";
   private static final String ID = "lee";
   private static final String PW = "practice";
   private static Connection connection = null;
   
   InputDatabase() throws SQLException{
      Connect_Database();
   }
   void Connect_Database() throws SQLException {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         System.out.println("Success Driver Load");
      } catch(ClassNotFoundException e) {
         System.out.println("Fail Driver Load: " + e.getMessage());
      }
      connection = DriverManager.getConnection(URL, ID, PW);
      
   }
   
   public static Connection getConnection() {
      return connection;
   }
   
   // DB�� �����͸� �����ϴ� �޼ҵ�
   public static void loadData(ArrayList<Location> Locations) {
      StringBuilder sql = new StringBuilder(); 
      PreparedStatement pstmt;
      sql.append("INSERT INTO STAT (��¥, ����, �̻�ȭ����, ������, �̻�ȭź��, ��Ȳ�갡��, �̼�����, �ʹ̼�����)");   //Date, Location, nppm , oppm, cppm, appm, dust, mdust
      sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
      
      try {
         pstmt = getConnection().prepareStatement(sql.toString());
         
         // �����͸� �ϳ��� �̾� DB�� ����Ѵ�.
         for(Location p: Locations) {
            pstmt.setString(1, p.getDate().toString());
            pstmt.setString(2, p.getName());
            pstmt.setString(3, Double.toString(p.getStat().nppm ));
            pstmt.setString(4, Double.toString(p.getStat().oppm));
            pstmt.setString(5, Double.toString(p.getStat().cppm));
            pstmt.setString(6, Double.toString(p.getStat().appm));
            pstmt.setString(7, Integer.toString(p.getStat().dust));
            pstmt.setString(8, Integer.toString(p.getStat().mdust));
            pstmt.execute();
         }
         
         pstmt.close();
      } catch(SQLException e) {
         System.out.println("DB ������ ��� ����: " + e.getMessage());
      }
   }
}
*/