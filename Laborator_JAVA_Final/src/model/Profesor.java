package model;

public class Profesor extends model.Persoana {
    public Profesor() {
    }

    public Profesor(String nume, String prenume) {
        super(nume, prenume);
    }
    public Profesor(int id, String nume, String prenume) {
        super(nume, prenume);
        this.id = id;
    }
    @Override
    public String toString() {
        return "Profesor: " + super.toString();
    }
    public String Write ()
    {
        return this.id + "," + this.nume + "," + this.prenume + ",";
    }
}
