package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class StergeCurs {


    public StergeCurs()
    {


        //creating a new frame
        JFrame f = new JFrame("Sterge Curs");

        //creating text fields
        JTextField t;

        //creating the label
        JLabel l;

        //creating buttons
        JButton b1, b2;

        //Naming the label
        l = new JLabel("ID :");
        l.setBounds(50,50,100,30);

        //creating the textfield
        t= new JTextField();
        t.setBounds(150,50,150,30);

        //creating the buttons
        b1 = new JButton("Salveaza");
        b1.setBounds(150, 300, 100, 30);
        b2 = new JButton("Inapoi");
        b2.setBounds(260, 300, 70, 30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = t.getText();




                if(e.getSource()==b1)
                {

                    try{

                        File file = new File ("cursuri.csv");
                        int position = 0 ;
                        String tempFile ="temp.csv";
                        File oldFile = new File("cursuri.csv");
                        File newFile = new File(tempFile);

                        String currentLine ;
                        String data[];
                        FileWriter fw = new FileWriter(tempFile,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        while ((currentLine = br.readLine())!=null)
                        {
                            data = currentLine.split(",");
                            if(!(data[position].equalsIgnoreCase(s)))
                            {
                                pw.println(currentLine);
                            }

                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                        oldFile.delete();
                        File nou = new File ("cursuri.csv");
                        newFile.renameTo(nou);


                    }catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }

                }
                JOptionPane.showMessageDialog(f,"Successfully Deleted" );

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new model.MeniuCurs();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        f.add(l);
        f.add(t);
        f.add(b1);
        f.add(b2);
        f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
    }

}
