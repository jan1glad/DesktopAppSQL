package Insert;

import Intro.Intro;
import Select.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert extends JFrame {
    private JPanel mainPanel;
    private JLabel Insert;
    private JButton klienciButton;
    private JButton CEOSButton;
    private JButton modeleButton;
    private JButton zamowieniaButton;
    private JButton goBackButton;

    public Insert() {
        setContentPane(mainPanel);
        setTitle("INSERT");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        klienciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KlienciInsert insert = new KlienciInsert();
                insert.show();
                dispose();
            }
        });
        CEOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CEOsInsert insert = new CEOsInsert();
                insert.show();
                dispose();
            }
        });
        modeleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeleInsert insert = new ModeleInsert();
                insert.show();
                dispose();
            }
        });
        zamowieniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZamowieniaInsert insert = new ZamowieniaInsert();
                insert.show();
                dispose();
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro intro = new Intro();
                intro.show();
                dispose();
            }
        });
    }
    public static void main(String[] args) {

    }
}
