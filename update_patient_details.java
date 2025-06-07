package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class update_patient_details extends JFrame {
    update_patient_details() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel(" Update patient Details:");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(label1);

        JLabel label2 = new JLabel(" Name");
        label2.setBounds(25, 88, 100, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            String q = "select * from patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel(" Room Number");
        label3.setBounds(25, 129, 150, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField tx = new JTextField();
        tx.setBounds(248, 129, 140, 20);
        panel.add(tx);

        JLabel label4 = new JLabel(" In_Time");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField tx1 = new JTextField();
        tx1.setBounds(248, 174, 140, 20);
        panel.add(tx1);

        JLabel label5 = new JLabel("Amount paid(Rs)");
        label5.setBounds(25, 216, 150, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField tx2 = new JTextField();
        tx2.setBounds(248, 216, 140, 20);
        panel.add(tx2);

        JLabel label6 = new JLabel("Pending Amount (Rs)");
        label6.setBounds(25, 261, 180, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField tx3 = new JTextField();
        tx3.setBounds(248, 261, 140, 20);
        panel.add(tx3);

        JButton b1 = new JButton("CHECK");
        b1.setBounds(70, 378, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        JButton updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(200, 378, 100, 30);
        updateBtn.setBackground(Color.BLUE);
        updateBtn.setForeground(Color.WHITE);
        panel.add(updateBtn);

        JButton backBtn = new JButton("BACK");
        backBtn.setBounds(330, 378, 100, 30);
        backBtn.setBackground(Color.RED);
        backBtn.setForeground(Color.WHITE);
        panel.add(backBtn);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_Info where Name='" + id + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        tx.setText(resultSet.getString("Room_Number"));
                        tx1.setText(resultSet.getString("Time"));
                        tx2.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no='" + tx.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int pendingAmount = Integer.parseInt(price) - Integer.parseInt(tx2.getText());
                        tx3.setText("" + pendingAmount);
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = choice.getSelectedItem();
                String room = tx.getText();
                String time = tx1.getText();
                String deposite = tx2.getText();

                try {
                    conn c = new conn();
                    String q = "update patient_Info set Room_Number='" + room + "', Time='" + time + "', Deposite='" + deposite + "' where Name='" + name + "'";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Patient Details Updated Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // close current window
            }
        });

        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}
