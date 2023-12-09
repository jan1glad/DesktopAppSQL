package Intro;

import javax.swing.*;
import javax.swing.ImageIcon;
import Delete.*;
import Insert.*;
import Login.Login;
import Select.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro extends JFrame{
    ImageIcon logo = new ImageIcon("logo.png");
    private JButton selectButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JPanel mainPanel;
    private JLabel labelPic;
    public JLabel display;
    private JButton logoutButton;

    public Intro(){
            //this.setLocationRelativeTo(null);
            //labelPic.setIcon(logo);
            //Dimension size = labelPic.getPreferredSize();
            //labelPic.setBounds(50,30, size.width, size.height);
            setContentPane(mainPanel);
            setTitle("WELCOME");
            setSize(1376, 720);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App app = new App();
                app.show();
                dispose();
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insert insert = new Insert();
                insert.show();
                dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete delete = new Delete();
                delete.show();
                dispose();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.show();
                dispose();
            }
        });
    }



        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Intro intro = new Intro();
                }
            });

    }
}
