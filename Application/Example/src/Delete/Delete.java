package Delete;

import Insert.*;
import Intro.Intro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame {

    private JPanel mainPanel;
    private JButton klienciButton;
    private JButton CEOSButton;
    private JButton goBackButton;
    private JButton modeleButton;
    private JButton zamowieniaButton;

    public Delete(){
        setContentPane(mainPanel);
        setTitle("INSERT");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro intro = new Intro();
                intro.show();
                dispose();
            }
        });
        klienciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KlienciDelete delete = new KlienciDelete();
                delete.show();
                dispose();
            }
        });
        CEOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CEOsDelete delete = new CEOsDelete();
                delete.show();
                dispose();
            }
        });
        modeleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeleDelete delete = new ModeleDelete();
                delete.show();
                dispose();
            }
        });
        zamowieniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZamowieniaDelete delete = new ZamowieniaDelete();
                delete.show();
                dispose();
            }
        });
    }
    public static void main(String[] args) {
    Delete delete = new Delete();
    }
}
