package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;

public class MeniuProfi implements ActionListener {
    private JFrame f ;
    private JPanel p ;

    public MeniuProfi()
    {

        File profesori;


        JButton b = new JButton("INAPOI");
        b.addActionListener(this);

        JButton viz = new JButton("VIZUALIZEAZA");
        viz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new VizualizeazaProfesori();
            }
        });
        JButton adaug = new JButton("ADAUGA");
        adaug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new model.AdaugaProfesor();
            }
        });
        JButton sterg = new JButton("STERGE");
        sterg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StergeProfesor();
            }
        });


        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        p.setLayout(new GridLayout(0,1));
        p.add(b);
        p.add(viz);
        p.add(adaug);
        p.add(sterg);

        f =  new JFrame("Meniu Profesori");
        f.add(p,BorderLayout.PAGE_END);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        new model.GUI();
    }
}
