import java.sql.*;
//pon sout
public class Main {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/esfotventas";
//        String user = "root";
//        String password = "123456";
//
//        try(Connection connection = DriverManager.getConnection(url,user,password)){
//            if(connection != null){
//                System.out.println("Conexion exitosa a la base de datos");
//            }
//            else{
//                System.out.println("Datos incorrecto");
//            }
//        }
//        catch (SQLException ex){
//            ex.printStackTrace();
//        }
//    }
    public static void main(String[] args){
        login lo = new login();
        lo.setVisible(true);
    }

}