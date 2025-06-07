package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_Info extends JFrame {
     Patient_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable(); // Corrected: Use JTable instead of JLabel
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBounds(10, 40, 900, 450);
        panel.add(table);

         try{
             conn c = new conn();
             String q = "select * from patient_Info";
             ResultSet resultSet = c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
         }catch (Exception e){
             e.printStackTrace();
         }




         JLabel labelID = new JLabel("ID:");
         labelID.setBounds(35, 11, 100, 14);
         labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(labelID);

         JLabel label1 = new JLabel("ID:");
         label1.setBounds(35, 76, 200, 14);
         label1.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label1);

         JLabel label2 = new JLabel("Number:");
         label2.setBounds(150, 11, 100, 14);
         label2.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label2);

         JLabel label3 = new JLabel("Name:");
         label3.setBounds(270, 11, 100, 14);
         label3.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label3);
         JLabel label33 = new JLabel("Gender:");
         label33.setBounds(360, 11, 100, 14);
         label33.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label33);

         JLabel label4 = new JLabel("Disease:");
         label4.setBounds(480, 11, 100, 14);
         label4.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label4);

         JLabel label5 = new JLabel("Room No:");
         label5.setBounds(600, 11, 100, 14);
         label5.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label5);

         JLabel label6 = new JLabel("Date&Time:");
         label6.setBounds(700, 11, 100, 14);
         label6.setFont(new Font("Tahoma", Font.BOLD, 14));
         panel.add(label6);
         JButton b1 = new JButton("Back");
         b1.setBounds(350, 500, 120, 30);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         panel.add(b1);

         b1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
             }
         });





         setUndecorated(true);





        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Patient_Info();
    }
}
