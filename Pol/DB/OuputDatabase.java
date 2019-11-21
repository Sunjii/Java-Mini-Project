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
   
   // DB���� ���α׷����� �����͸� �ҷ����� �޼ҵ�
   public void saveData(ArrayList<Location> Locations) {
      String sql;
      PreparedStatement pstmt;
      ResultSet rs;
      
      sql = "SELECT * FROM Stat";
      
      try {
         pstmt = getConnection().prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         // ��� �׸��� �����´�
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
         System.out.println("DB ������ �ҷ����� ����: " + e.getMessage());
      }
   }
}