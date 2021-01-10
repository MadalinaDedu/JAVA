package model;

public class Student extends model.Persoana
{
    int grupa;
    public Student() {

    }

    public Student(String nume, String prenume, int grupa)  {
        super(nume,prenume);
        this.grupa = grupa;
    }
    public Student(int id, String nume, String prenume, int grupa)  {
        super(nume,prenume);
        this.grupa = grupa;
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Student: " + super.toString() + " " + grupa;
    }
    public String Write()
    {
        return this.id +"," + this.nume + "," + this.prenume + "," + this.grupa ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.grupa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;

        if (this.grupa != other.grupa) {
            return false;
        }
        return super.equals(obj);

    }
}
