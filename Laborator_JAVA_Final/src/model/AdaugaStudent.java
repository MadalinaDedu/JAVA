package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdaugaStudent {
    Student [] mystudents = new Student[50];
    private int index = 10;
    public AdaugaStudent()
    {
        File std = new File("studenti.csv");
        //creating a new frame
        JFrame f = new JFrame("Adauga Student");

        //creating text fields
        JTextField t1, t2, t3,t4;

        //creating the labels
        JLabel l1,l2,l3,l4;

        //creating buttons
        JButton b1,b2;

        // Naming the labels
        l1 = new JLabel("ID :");
        l1.setBounds(50,50,120,30);

        l2 = new JLabel("Nume :");
        l2.setBounds(50,100,120,30);

        l3 = new JLabel("Prenume :");
        l3.setBounds(50,150,120,30);

        l4 = new JLabel("Grupa :");
        l4.setBounds(50,200,1200,30);

        // Creating the textfields
        t1 = new JTextField();
        t1.setBounds(150, 50, 230, 30);
        t2 = new JTextField();
        t2.setBounds(150, 100, 230, 30);
        t3 = new JTextField();
        t3.setBounds(150, 150, 230, 30);
        t4 = new JTextField();
        t4.setBounds(150, 200, 230, 30);

        b1 = new JButton("Salveaza");
        b1.setBounds(150, 300, 100, 30);
        b2 = new JButton("Inapoi");
        b2.setBounds(260, 300, 70, 30);


        // Adding action listener
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                // Getting the text from text fields
                // and JComboboxes
                // and copying it to a strings

                String s1 = t1.getText();
                String s2 = t2.getText();
                String s3 = t3.getText();
                String s4 = t4.getText();

                Student student1 = new Student();
                student1.nume=s2;
                student1.prenume=s3;
                student1.grupa=Integer.parseInt(s4);
                student1.id=Integer.parseInt(s1);

                if (e.getSource() == b1) {
                    try {

                        BufferedWriter bw = new BufferedWriter(new FileWriter(std,true));
                        PrintWriter pw = new PrintWriter(bw);
                        //PrintWriter pww = new PrintWriter(new File("studenti.csv"));
                        StringBuilder sb =new StringBuilder();

                        //scriu antetul
                      /* sb.append("ID");
                       sb.append(",");
                       sb.append("NUME");
                       sb.append(",");
                       sb.append("PRENUME");
                       sb.append(",");
                       sb.append("GRUPA");
                       sb.append("\r\n");*/

                        sb.append(s1);
                        sb.append(",");
                        sb.append(s2);
                        sb.append(",");
                        sb.append(s3);
                        sb.append(",");
                        sb.append(s4);
                        sb.append("\r\n");

                        pw.write(sb.toString());
                        pw.close();

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

                // Shows a Pop up Message when
                // save button is clicked
                JOptionPane
                        .showMessageDialog(
                                f,
                                "Successfully Saved"
                                        + " The Details");
            }
        });

        // Action listener to close the form
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
                new MeniuStudenti();
            }
        });

        // Default method for closing the frame
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        // Adding the created objects
        // to the frame
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(t4);
        f.add(b1);
        f.add(b2);
        f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);
    }
    // Driver code
    public static void main(String args[])
    {
        new AdaugaStudent();
    }
}
