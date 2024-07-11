import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class login extends JFrame{

    private JButton ingresarButton;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel nombre;
    private JLabel edad;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel nota2;
    private JLabel nota1;

    public login(){
        setTitle("BDD");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/esfotventas";
                String user = "root";
                String password = "123456";
                try(Connection connection = DriverManager.getConnection(url,user,password)){
                    if(connection != null){
                        JOptionPane.showMessageDialog(null, "Conexion exitosa a la base de datos");
                        String nombree = textField1.getText();
                        String edadd = textField2.getText();
                        String notauno = textField3.getText();
                        String notados = textField4.getText();

                        String sql = "INSERT INTO estudiantes (nombre, edad,nota1,nota2) values (?,?,?,?)";

                        //Ingregar
                        PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1,nombree);
                        pstmt.setInt(2,Integer.parseInt(edadd));
                        pstmt.setDouble(3, Double.parseDouble(notauno));
                        pstmt.setDouble(4, Double.parseDouble(notados));

                        //Actualizar
                        int rowsAffected=pstmt.executeUpdate();
                        if (rowsAffected > 0){
                            JOptionPane.showMessageDialog(null, "Datos actualizados");
                        }
                        pstmt.close();
                        connection.close();



                    }else{
                        System.out.println("Datos incorrecto");
                    }
                }
                catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public void insertar()throws SQLException{

    }
}
