package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable(); // Corrected: Use JTable instead of JLabel
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 690, 360);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(290, 10, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16)); // Corrected Font constructor
        panel.add(label1);

        JButton b1 = new JButton("Back");
        b1.setBounds(280, 420, 130, 30);
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
        setSize(700, 500);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
