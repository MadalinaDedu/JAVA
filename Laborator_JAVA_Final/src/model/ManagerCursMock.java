package model;

import java.util.ArrayList;

public class ManagerCursMock extends model.Manager<model.Curs> implements model.IOperatiiManagerCurs {

    public boolean Register(Student s, model.Curs c) {
        return true;
    }


    public boolean UnRegister(Student s, model.Curs c) {
        return true;
    }

    public ArrayList<model.Curs> getLista() {
        return lista;
    }

    public void setLista(ArrayList<model.Curs> lista) {
        this.lista = lista;
    }



    public ManagerCursMock() {
        //instantierea sirului va avea loc aici
        this.lista = new ArrayList<model.Curs>();
        Add(new model.Curs());
        Add(new model.Curs("poo", "java", new Profesor("A", "B"), null,null));
        Add(new model.Curs("dec", "disp circ elec", new Profesor("S", "F"),
                new ArrayList<Student>(),null));
        Add(new model.Curs("uuu", "algad", new Profesor("D", "F"), null,null));
    }

    public ManagerCursMock(int length) {
        //super(Curs.class,length);
        super(new ArrayList<model.Curs>(length));
    }

    @Override
    public void Add(model.Curs c) {
        this.lista.add(c);
    }

    @Override
    public void Delete(model.Curs c) {
        this.lista.remove(c);
    }

    @Override
    public void Update(model.Curs c) {
        int i=0;
        for(;i< this.lista.size();i++)
        {
            if (this.lista.get(i).nume == c.nume)
                break;

        }
        if (i < this.lista.size())
            this.lista.set(i, c);
    }

    @Override
    public void Search(model.Curs c) {
        int i=0;
        for(;i< this.lista.size();i++)
        {
            if (this.lista.get(i).nume == c.nume)
                break;
        }
        if (i < this.lista.size())
            System.out.println("Curs " + c + "found at " + i);
        else
            System.out.println("Curs " + c + " not found.");
    }

}
