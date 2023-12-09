package Insert;

import Intro.Intro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class ModeleInsert extends JFrame {


    private JPanel mainPanel;
    private JLabel ceo;
    private JTextField Model;
    private JComboBox<String> Paliwo;
    private JComboBox<String> Typ;
    private JButton insertButton;
    private JButton goBackButton;
    private JButton clearButton;
    private JComboBox<String> Rok;
    SQL sql = new SQL();
    public ModeleInsert(){
        for(int i=2023;i>=1999;i--){
            Rok.addItem(String.valueOf(i));
        }
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
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO modele (Model, Rocznik, Typ, Paliwo) VALUES (?, ?, ?, ?)");
                    statement.setString(1, Model.getText());
                    statement.setString(2, (String) Rok.getSelectedItem());
                    statement.setString(3, (String) Typ.getSelectedItem());
                    statement.setString(4, (String) Paliwo.getSelectedItem());
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
                Model.setText("");
            }
        });
    }
    public static void main(String[] args) {
    ModeleInsert modeleInsert = new ModeleInsert();
    }
}
