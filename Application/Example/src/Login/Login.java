package Login;

import Intro.Intro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {
    private JTextField Login;
    private JPanel mainPanel;
    private JPasswordField Pass;
    private JButton loginButton;
    private JButton clearButton;
    private JButton fastButton;

    public Login(){

        setContentPane(mainPanel);
        setTitle("WELCOME");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
                    String sql = "select * from haslo where imie='"+ Login.getText()+"' and pass='"+Pass.getText()+"'";
                    PreparedStatement pst = conn.prepareStatement(sql);

                    ResultSet rs=pst.executeQuery(sql);

                    if (rs.next()) {


                        JOptionPane.showMessageDialog(null,"Succesful login");
                        Intro intro = new Intro();
                        intro.display.setText(rs.getString(2));
                        intro.show();
                        dispose();

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Wrong login or password, try again");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.setText("");
                Pass.setText("");
            }
        });
        fastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro intro = new Intro();
                intro.show();
                dispose();
            }
        });
    }



    public static void main(String[] args) {
        Login login = new Login();
    }
}
