import javax.swing.*;
import java.sql.*;
import java.util.Arrays;

public class Proba{
    String []addItem;
    Connection con;
    Statement st;
    ResultSet rs;
    public void Probad(String []addItem)
    {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/Cars","root","");
            st = con.createStatement();
            String s = "select * from modele";
            rs = st.executeQuery(s);
            addItem=new String[10];
            int i=0;
            while(rs.next() && i<addItem.length)
            {
                addItem[i]=rs.getString(2);
                i++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }finally{
            try{
                st.close();
                rs.close();
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
        }
        System.out.println(Arrays.toString(addItem));
    }


    public static void main(String[] args){
        Proba proba = new Proba();
        proba.Probad(proba.addItem);
        System.out.println();
    }
}