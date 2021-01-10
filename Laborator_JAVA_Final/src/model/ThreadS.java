package model;

import model.Student;

public class ThreadS {
    Student[] array = new Student[] { new Student("S1", "S2", 1), new Student("S3", "S3", 1),
            new Student("S4", "S5", 1), new Student("S6", "S7", 1), new Student("S8", "S9", 1),};
    volatile int i = 0;

    public void afisa() {
        synchronized (this) {
            for (; i < array.length;) {
                System.out.println("thread name " + Thread.currentThread().getName() + "  : " + array[i]);
                i++;
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
