package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class GUI implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JPanel pn2;
    private JPanel pn3;
    private JPanel pn4;
    public Checkbox vizualizeaza;
    public Checkbox adauga ;
    public Checkbox sterge;

    JButton stud;
    JButton prof;
    JButton curs;

    int v=0;
    boolean s=false;
    boolean p=false;
    boolean c=false;



    File studenti, profesori, cursuri;

    public GUI ()
    {
        frame = new JFrame();

        stud = new JButton("STUDENTI");
        stud.addActionListener(this);
        prof = new JButton("PROFESORI");
        prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MeniuProfi();
            }
        });
        curs = new JButton("CURSURI");
        curs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MeniuCurs();
            }
        });


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,100,200));
        panel.setLayout(new GridLayout(0,1));
        panel.add(stud);
        panel.add(prof);
        panel.add(curs);

        // panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MANAGER");
        frame.pack();
        frame.setVisible(true);


    }

    public static  void main (String [] args)
    {
        new GUI() ;
    }


    public void actionPerformed(ActionEvent e) {

        frame.dispose();

        new MeniuStudenti();


    }
}

