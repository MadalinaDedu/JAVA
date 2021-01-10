package model;

import java.util.*;

public abstract class Manager<T> {

    public ArrayList<T> lista;

    public Manager() {
    }

    public Manager(ArrayList<T> list) {
        lista = list;
    }

    public void AfiseazaTot() {
        for (T t : lista) {
            System.out.println(t);
        }
    }
}
