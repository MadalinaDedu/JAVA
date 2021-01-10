/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.util.*;

public class ManagerCursCSV extends model.Manager<model.Curs> implements model.IOperatiiManagerCurs {

    File studenti, profesori, cursuri;

    public ManagerCursCSV() {
        try {
            studenti = new File("studenti.csv");
            profesori = new File("profesori.csv");
            cursuri = new File("cursuri.csv");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ManagerCursCSV(File studenti, File profesori, File cursuri) {
        this.studenti = studenti;
        this.profesori = profesori;
        this.cursuri = cursuri;
    }

    /*functia va aduce din fisiere, datele despre studenti, profesori, cursuri
    si va popula colectia din clasa Manager: lista*/
    public void CitesteDateDinFisiere() {
        try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Started reading...");
                        ArrayList<Student> studentlist = PopuleazaStudenti();
                        ArrayList<Profesor> proflist = PopuleazaProfesori();
                        lista = PopuleazaCursuri(proflist, studentlist);
                        System.out.println("Finished reading...");
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                }
            });
            t.start();
            t.join();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ScrieDatedInFisier() {
        try {
            ScrieStudenti();
            ScrieProfesori();
            ScrieCursuri();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void ScrieStudenti() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(studenti));
                    Set<Student> studentList = new HashSet<Student>();
                    System.out.println("Started writing...");
                    for (model.Curs c : lista) {
                        if (c.studenti == null) {
                            continue;
                        }
                        for (Student s : c.studenti) {
                            studentList.add(s);
                        }
                    }
                    bw.write("Id, Nume, Prenume, Grupa\r\n");
                    for (Student s : studentList) {
                        bw.write(s.Write() + "\r\n");
                    }
                    bw.flush();
                    bw.close();
                    System.out.println("Finished writing...");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        try {
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private void ScrieProfesori() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(profesori));
                    Set<Profesor> profList = new HashSet<Profesor>();
                    System.out.println("Started writing...");
                    for (model.Curs c : lista) {
                        if (c.profesor == null) {
                            continue;
                        }

                        profList.add(c.profesor);

                    }
                    bw.write("Id, Nume, Prenume, Grupa\r\n");
                    for (Profesor p : profList) {
                        bw.write(p.Write() + "\r\n");
                    }
                    bw.flush();
                    bw.close();
                    System.out.println("Finished writing...");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        try {
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private void ScrieCursuri() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(cursuri));
                    Set<model.Curs> cursList = new HashSet<model.Curs>();
                    System.out.println("Started writing...");
                    for (model.Curs c : lista) {
                        if (c == null) {
                            continue;
                        }

                        cursList.add(c);

                    }
                    bw.write("Id, Nume, Prenume, Grupa\r\n");
                    for (model.Curs curs : cursList) {
                        bw.write(curs.Write() + "\r\n");
                    }
                    bw.flush();
                    bw.close();
                    System.out.println("Finished writing...");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        try {
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public boolean Register(Student s, model.Curs c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UnRegister(Student s, model.Curs c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Add(model.Curs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(model.Curs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(model.Curs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Search(model.Curs t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ArrayList<Student> PopuleazaStudenti() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(studenti));
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            String line = br.readLine(); //skip prima linie: este header-ul csv-ului
            while ((line = br.readLine()) != null) {
                String[] splitline = line.split(",");
                Student s = new Student(Integer.parseInt(splitline[0].trim()),
                        splitline[1], splitline[2], Integer.parseInt(splitline[3].trim()));
                studentList.add(s);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return studentList;
    }

    private ArrayList<Profesor> PopuleazaProfesori() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(profesori));
        ArrayList<Profesor> profesorList = new ArrayList<Profesor>();
        try {
            String line = br.readLine(); //skip prima linie
            while ((line = br.readLine()) != null) {
                String[] splitline = line.split(",");
                Profesor p = new Profesor(Integer.parseInt(splitline[0].trim()),
                        splitline[1], splitline[2]);
                profesorList.add(p);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return profesorList;
    }

    private ArrayList<model.Curs> PopuleazaCursuri(ArrayList<Profesor> listdeprofi, ArrayList<Student> listdestudenti) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(cursuri));
        ArrayList<model.Curs> cursuriList = new ArrayList<model.Curs>();
        try {
            String line = br.readLine(); //skip prima linie
            while ((line = br.readLine()) != null) {
                String[] splitline = line.split(",");
                model.Curs c = new model.Curs(Integer.parseInt(splitline[0].trim()),
                        splitline[1], splitline[2], null, null,null);//cel putin nume si descriere vor fi in csv
                if (splitline.length > 3) //daca avem id-ul profesorului
                {
                    int profid = Integer.parseInt(splitline[3].trim());
                    //cautam profesorul dupa id
                    for (Profesor p : listdeprofi) {
                        if (p.id == profid) //este gasit, va fi atasat cursului
                        {
                            c.profesor = p;
                            break; //n-are rost sa mai cautam
                        }
                    }
                }
                if (splitline.length > 4) //daca avem id-uri ale studentilor
                {
                    int index = 4;
                    c.studenti = new ArrayList<>(); //nu uitam sa initializam lista de studenti :)
                    while (index < splitline.length) //iteram prin id-urile gasite in linie
                    {
                        int studentid = Integer.parseInt(splitline[index].trim());
                        //cautam studenti dupa id
                        for (Student s : listdestudenti) {
                            if (s.id == studentid) //daca este gasit,va fi atasat cursului
                            {
                                c.studenti.add(s);
                                break; //n-are rost sa mai cautam
                            }
                        }
                        index++;
                    }
                }
                cursuriList.add(c);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return cursuriList;
    }
}
