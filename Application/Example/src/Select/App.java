package Select;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import Intro.*;
public class App extends JFrame {
    private JButton klienciButton;
    private JButton clearButton;
    private JPanel mainPanel;
    private JTable table;
    private JButton CEOSButton;
    private JButton modeleButton;
    private JButton zamowieniaButton;
    private JButton goBackButton;

    public App() {

        Cars cars = new Cars();
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize(1376, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        klienciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = cars.klienci();

                    DefaultTableModel model = new DefaultTableModel();
                    table.setModel(model);
                    model.addColumn("id");
                    model.addColumn("nazwa");
                    model.addColumn("branza");
                    model.addColumn("miasto");
                    model.addColumn("ulica");
                    model.addColumn("ilosc");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("nazwa");
                        String branza = rs.getString("branza");
                        String miasto = rs.getString("miasto");
                        String ulica = rs.getString("ulica");
                        int ilosc = rs.getInt("ilosc");
                        model.addRow(new Object[]{id,name,branza,miasto,ulica,ilosc});
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        CEOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ResultSet rs = cars.ceo();
                    DefaultTableModel model = new DefaultTableModel();
                    table.setModel(model);
                    model.addColumn("I_D");
                    model.addColumn("Firma");
                    model.addColumn("Imie");
                    model.addColumn("Nazwisko");
                    model.addColumn("Telefon");
                    model.addColumn("Email");

                    while (rs.next()){
                        int I_D = rs.getInt("I_D");
                        String Firma = rs.getString("Firma");
                        String Imie = rs.getString("Imie");
                        String Nazwisko = rs.getString("Nazwisko");
                        String Telefon = rs.getString("Telefon");
                        String Email = rs.getString("Email");
                        model.addRow(new Object[]{I_D,Firma,Imie,Nazwisko,Telefon,Email});
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        modeleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = cars.modele();
                    DefaultTableModel model = new DefaultTableModel();
                    table.setModel(model);
                    model.addColumn("Identfykiator");
                    model.addColumn("Model");
                    model.addColumn("Rocznik");
                    model.addColumn("Typ");
                    model.addColumn("Paliwo");

                    while (rs.next()){
                        int Identyfikator = rs.getInt("Identyfikator");
                        String Model = rs.getString("Model");
                        int Rocznik = rs.getInt("Rocznik");
                        String Typ = rs.getString("Typ");
                        String Paliwo = rs.getString("Paliwo");
                        model.addRow(new Object[]{Identyfikator, Model, Rocznik, Typ, Paliwo});
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        zamowieniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ResultSet rs = cars.zamowienia();
                    DefaultTableModel model = new DefaultTableModel();
                    table.setModel(model);

                    model.addColumn("Identyfikator");
                    model.addColumn("Firma");
                    model.addColumn("Model");
                    model.addColumn("Stan");
                    model.addColumn("Paliwo");
                    model.addColumn("cena");

                    while (rs.next()) {
                        int Identyfikator = rs.getInt("Identyfikator");
                        String Firma = rs.getString("Firma");
                        String Model = rs.getString("Model");
                        String Stan = rs.getString("Stan");
                        String Paliwo = rs.getString("Paliwo");
                        int cena = rs.getInt("cena");

                        model.addRow(new Object[]{Identyfikator,Firma,Model,Stan,Paliwo,cena});
                    }
                }catch (Exception exam){
                    exam.printStackTrace();
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               DefaultTableModel model = (DefaultTableModel) table.getModel();
               model.setRowCount(0);
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App app = new App();
            }
        });

    }
}
