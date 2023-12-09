package Insert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KlienciInsert extends JFrame{
    private JPanel mainPanel;
    private JLabel ceo;
    private JTextField Nazwa;
    private JTextField Branza;
    private JTextField Miasto;
    private JTextField Ulica;
    private JTextField Ilosc;
    private JButton insertButton;
    private JButton goBackButton;
    private JButton clearButton;

    SQL sql = new SQL();
    public KlienciInsert(){
        setContentPane(mainPanel);
        setTitle("INSERT");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = sql.getConnection();
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO klienci (nazwa, branza, miasto, ulica, ilosc) VALUES (?, ?, ?, ?,?)");
                    statement.setString(1, Nazwa.getText());
                    statement.setString(2, Branza.getText());
                    statement.setString(3, Miasto.getText());
                    statement.setString(4, Ulica.getText());
                    statement.setString(5, Ilosc.getText());
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
                Nazwa.setText("");
                Branza.setText("");
                Miasto.setText("");
                Ulica.setText("");
                Ilosc.setText("");
            }
        });
    }

    public static void main(String[] args) {
        KlienciInsert klienciInsert = new KlienciInsert();

    }
}
