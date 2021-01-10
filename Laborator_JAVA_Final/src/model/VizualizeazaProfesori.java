package model;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VizualizeazaProfesori implements ActionListener {
    private JFrame f;
    private JPanel p;
    JTextPane t = new JTextPane() ;

    File profesori = new File("profesori.csv");

    StringBuilder sb = new StringBuilder();

    Scanner input;

    {
        try {
            input = new Scanner(profesori);

            while(input.hasNext())
            {
                sb.append(input.nextLine());
                sb.append("\n");
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public VizualizeazaProfesori() {

        JButton b = new JButton("INAPOI");
        b.addActionListener(this);

        t.setText(sb.toString());


        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        p.setLayout(new GridLayout(0, 1));
        p.add(b);
        p.add(t);

        f = new JFrame("Vizualizeaza Profesori");
        f.add(p, BorderLayout.PAGE_END);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        new model.MeniuProfi();

    }
}
