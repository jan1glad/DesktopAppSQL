package Delete;

import Insert.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZamowieniaDelete extends JFrame {

    private JPanel mainPanel;
    private JLabel ceo;
    private JButton deleteButton;
    private JButton goBackButton;
    private JComboBox<String> Firma;
    private JComboBox<String> Model;
    private JComboBox<String> Stan;
    private JComboBox<String> Paliwo;

    public final void loadUserName() {
        try {
            String sql = "select distinct Firma from zamowienia";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Firma.addItem(rs.getString("Firma"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql = "select distinct Model from zamowienia";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Model.addItem(rs.getString("Model"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql = "select distinct Stan from zamowienia";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Stan.addItem(rs.getString("Stan"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql = "select distinct Paliwo from zamowienia";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Paliwo.addItem(rs.getString("Paliwo"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ZamowieniaDelete(){
        loadUserName();
        setContentPane(mainPanel);
        setTitle("INSERT");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        SQL sql = new SQL();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Connection connection = sql.getConnection();
                            PreparedStatement statement = connection.prepareStatement("DELETE FROM zamowienia WHERE Firma=? AND Model=? AND Stan=? AND Paliwo=?");
                            statement.setString(1, (String) Firma.getSelectedItem());
                            statement.setString(2, (String) Model.getSelectedItem());
                            statement.setString(3, (String) Stan.getSelectedItem());
                            statement.setString(4, (String) Paliwo.getSelectedItem());
                            statement.executeUpdate();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "Data deleted successfully!");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                });
            }

        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete delete = new Delete();
                delete.show();
                dispose();
            }
        });

    }
    public static void main(String[] args) {
    ZamowieniaDelete zamowieniaDelete = new ZamowieniaDelete();
    }
}
