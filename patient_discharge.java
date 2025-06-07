package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame{
    patient_discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 590, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check_Out:");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);

        JLabel label2 = new JLabel("Customer_ID:");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            String q = "select * from patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }



        JLabel label3 = new JLabel("Room_Number:");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel Rno = new JLabel();
        Rno.setBounds(200, 130, 150, 20);
        Rno.setFont(new Font("Tahoma", Font.BOLD, 14));
        Rno.setForeground(Color.WHITE);
        panel.add(Rno);

        JLabel label4 = new JLabel("IN_Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE); panel.add(label4);

        JLabel InTime = new JLabel();
       InTime.setBounds(200, 180, 250, 20);
       InTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(InTime);

        JLabel label5 = new JLabel("Out_Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE); panel.add(label5);

        Date date=new Date();
        JLabel outTime = new JLabel(""+date);
        outTime.setBounds(200, 230, 250, 20);
        outTime.setFont(new Font("Tahoma", Font.BOLD, 14));
       outTime.setForeground(Color.WHITE);
        panel.add(outTime);

        JButton b1 = new JButton("Discharge");
        b1.setBounds(30, 300, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{
                    c.statement.executeUpdate("delete from patient_Info where number='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability='Available' where room_no='"+Rno.getText()+"'");
                    JOptionPane.showConfirmDialog(null,"Done");

                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();

                }


            }
        });

        JButton b2 = new JButton("Check");
        b2.setBounds(170, 300, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               conn c= new conn();
               try{
                   ResultSet resultSet=c.statement.executeQuery("select*from patient_Info where number='"+choice.getSelectedItem()+"'");
                   while (resultSet.next()){
                       Rno.setText(resultSet.getString("Room_Number"));
                   InTime.setText(resultSet.getString("Time"));

                   }

               }catch (Exception E){
                   E.printStackTrace();
               }
            }
        });


        JButton b3 = new JButton("Back");
        b3.setBounds(300, 300, 120, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setSize(800, 800);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new patient_discharge();
    }

}
