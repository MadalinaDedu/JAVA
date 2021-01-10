package model;

import java.util.ArrayList;
import java.util.Arrays;


public class Curs implements Comparable<Curs> {
    int id;
    String nume;
    String descriere;
    Profesor profesor;
    ArrayList<Student> studenti;
    int[] note;

    @Override
    public int compareTo(Curs o) {
        if (this.descriere.equals(o.descriere) && this.nume.equals(o.nume))
        {
            if (this.studenti.size() >  o.studenti.size())
                return 1;
            else if (this.studenti.size() <  o.studenti.size())
                return -1;
            else return 0;
        }

        return (this.nume.equals(o.nume))?this.descriere.compareTo(o.descriere):
                this.nume.compareTo(o.nume);
    }


    public Curs() {

    }

    public Curs(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;
        profesor = new Profesor();
        studenti = new ArrayList();

    }

    public Curs(String nume, String descriere, Profesor profesor,ArrayList studenti, int note[]) {
        this.nume = nume;
        this.descriere = descriere;
        this.profesor = profesor;
        this.studenti = studenti;
        this.note = new int[studenti.size()];
    }
    public Curs(int id, String nume, String descriere, Profesor profesor,ArrayList studenti, int note[]) {
        this.id = id;
        this.nume = nume;
        this.descriere = descriere;
        this.profesor = profesor;
        this.studenti = studenti;
        this.note = new int[studenti.size()];
    }

    @Override
    public String toString() {
        String str = "";
        str += "Nume curs = " + this.nume + System.lineSeparator();
        str += "Descriere curs = " + this.descriere + System.lineSeparator();
        str += "Profesor curs = " + this.profesor + System.lineSeparator();
        str += "Studenti: " + System.lineSeparator();
        if (studenti != null) {
            for (Student student : studenti) {
                str += "\t" + student + System.lineSeparator();
            }
        } else {
            str += " lipsa";
        }
        return str;
    }

    public String Write ()
    {
        return this.id +","+ this.nume +"," +this.descriere+","+ this.profesor +"," + this.studenti;
    }

    public void noteazaStudent(Student studentNotat, int nota) {
        for ( int i = 0; i < studenti.size(); i++) {
            Student student = studenti.get(i);
            if ( student.getNume().equals(studentNotat.getNume()) && student.getPrenume().equals(studentNotat.getPrenume())) {
                note[i] = nota;
            }
        }
    }

    public void raportNoteStudenti() {
        for ( int i = 0; i < studenti.size(); i++) {
            System.out.println(studenti.get(i) + " are nota " + note[i]);
        }
    }

    public void raportMediaStudentilor() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    double suma =0;
                    double media;
                    for(int i=0; i< studenti.size()/2;i++)
                    {
                        suma = suma + note[i];
                    }
                    media = suma/(studenti.size()/2);
                    System.out.println("Media studentilor din grupa 1 este :" + media);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    double suma =0;
                    double media;
                    for(int i = studenti.size()/2;i<studenti.size();i++)
                    {
                        suma = suma + note[i] ;
                    }

                    media = suma/(studenti.size()/2);
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
