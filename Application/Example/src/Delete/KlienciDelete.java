package Delete;

import Insert.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class KlienciDelete extends JFrame {
    private JPanel mainPanel;
    private JLabel ceo;
    private JButton deleteButton;
    private JButton goBackButton;
    private JComboBox<String> Firma;
    private JComboBox<String> Miasto;

    public final void loadUserName() {
        try {
            String sql = "select nazwa from klienci";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Firma.addItem(rs.getString("nazwa"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql = "select distinct miasto from klienci";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Miasto.addItem(rs.getString("miasto"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
    }


    public KlienciDelete() {
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
                            PreparedStatement statement = connection.prepareStatement("DELETE FROM klienci WHERE nazwa=? AND miasto=?");
                            statement.setString(1, (String) Firma.getSelectedItem());
                            statement.setString(2, (String) Miasto.getSelectedItem());
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
    KlienciDelete klienciDelete = new KlienciDelete();
    }
}



