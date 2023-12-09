package Insert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZamowieniaInsert extends JFrame {

    private JPanel mainPanel;
    private JLabel ceo;
    private JTextField Cena;
    private JButton insertButton;
    private JButton goBackButton;
    private JButton clearButton;
    private JComboBox<String> Model;
    private JComboBox<String> Firma;
    private JComboBox<String> Paliwo;
    private JComboBox<String> Stan;

    public final void loadUserName() {
        try {
            String sql = "select Model from modele";
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs=pst.executeQuery(sql);

            while (rs.next()) {

                Model.addItem(rs.getString("Model"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql = "select nazwa from klienci";
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs=pst.executeQuery(sql);

            while (rs.next()) {

                Firma.addItem(rs.getString("nazwa"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql = "select distinct Paliwo from modele";
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs=pst.executeQuery(sql);

            while (rs.next()) {

                Paliwo.addItem(rs.getString("Paliwo"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void initComponents(){
        setContentPane(mainPanel);
        setTitle("INSERT");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ZamowieniaInsert() {
        initComponents();
        loadUserName();
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO zamowienia (Firma, Model, Stan, Paliwo, cena) VALUES (?, ?, ?, ?,?)");
                    statement.setString(1, (String) Firma.getSelectedItem());
                    statement.setObject(2, Model.getSelectedItem());
                    statement.setString(3, (String) Stan.getSelectedItem());
                    statement.setString(4, (String) Paliwo.getSelectedItem());
                    statement.setString(5, Cena.getText());
                    statement.executeUpdate();
                    connection.close();
                    JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insert insert = new Insert();
                insert.show();
                dispose();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cena.setText("");
            }
        });
    }

    public static void main(String[] args) {
        ZamowieniaInsert zamowieniaInsert = new ZamowieniaInsert();
    }


}
