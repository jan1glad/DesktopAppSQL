package Delete;

import Insert.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModeleDelete extends JFrame {
    private JPanel mainPanel;
    private JLabel ceo;
    private JComboBox<String> Model;
    private JButton deleteButton;
    private JButton goBackButton;

    public final void loadUserName() {
        try {
            String sql = "select Model from modele";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                Model.addItem(rs.getString("Model"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
    }
    public ModeleDelete(){
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
                            PreparedStatement statement = connection.prepareStatement("DELETE FROM modele WHERE Model=?");
                            statement.setString(1, (String) Model.getSelectedItem());
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
    ModeleDelete modeleDelete = new ModeleDelete();
    }
}
