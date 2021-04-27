package de.telekom.sea.seminar;

public class SeminarApp {
    public Object parent;

    public void run(String[] args) {
        Person p = new Person();
        p.parent= this;


        System.out.println("Hello Maven!");
    }
}
