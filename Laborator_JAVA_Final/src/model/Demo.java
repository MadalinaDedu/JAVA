package model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import model.*;

class Demo {

    public static void main(String args[]) {
        try {
            ManagerCursCSV m = new ManagerCursCSV();
            m.CitesteDateDinFisiere();
            int note [] = new int []{7,8,9,10};
            ArrayList<Student> noistudenti = new ArrayList<Student>();
            noistudenti.add(new Student(7,"A", "B", 4491));
            noistudenti.add(new Student(9,"A", "B", 4491));
            noistudenti.add(new Student(8,"C", "D", 4451));
            m.lista.add(new model.Curs(6,"curs 6" , "desc 6",
                    new Profesor(4,"dsad","dasda"),noistudenti,note));
            m.AfiseazaTot();
            m.ScrieDatedInFisier();

            Student [] s1 = new Student[]{new Student("Ana" , "Maria",45),new Student("Mircea","Andrei",67),new Student ("NumeS1","PreumeS1",45)};
            Profesor p = new Profesor("NumeP","Prenumep");



        } catch (Exception ex) {
            StackTraceElement[] st = ex.getStackTrace();
            System.out.println(ex);
        }

        Student[] array = new Student[] { new Student("S1", "S2", 1), new Student("S3", "S3", 1),
                new Student("S4", "S5", 1), new Student("S6", "S7", 1), new Student("S8", "S9", 1)};
        // volatile int i = 0;


        final ThreadS er=new ThreadS();
        Thread t1=new Thread(new Runnable() {

            @Override
            public void run() {
                er.afisa();

            }
        }, "T1");
        Thread t21=new Thread(new Runnable() {

            @Override
            public void run() {
                er.afisa();

            }
        }, "T2");
        t1.start();
        t21.start();

        new GUI(); }

}






