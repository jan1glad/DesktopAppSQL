package Insert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class CEOsInsert extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> Firma;
    private JTextField Imie;
    private JTextField Nazwisko;
    private JTextField Telefon;
    private JTextField Email;
    private JButton insertButton;
    private JButton goBackButton;
    private JLabel ceo;
    private JButton clearButton;

    public final void load(){
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
}

    public CEOsInsert(){
        SQL sql = new SQL();
        load();
        setContentPane(mainPanel);
        setTitle("INSERT");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Connection connection = sql.getConnection();
                            PreparedStatement statement = connection.prepareStatement("INSERT INTO ceo (Firma, Imie, Nazwisko, Telefon, Email) VALUES (?, ?, ?, ?,?)");
                            statement.setString(1, (String) Firma.getSelectedItem());
                            statement.setString(2, Imie.getText());
                            statement.setString(3, Nazwisko.getText());
                            statement.setString(4, Telefon.getText());
                            statement.setString(5, Email.getText());
                            statement.executeUpdate();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
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
                Insert insert = new Insert();
                insert.show();
                dispose();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Imie.setText("");
                Email.setText("");
                Telefon.setText("");
                Nazwisko.setText("");
            }
        });
    }
    public static void main(String[] args) {
        CEOsInsert ceOsInsert = new CEOsInsert();

    }
}
