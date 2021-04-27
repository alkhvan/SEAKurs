package de.telekom.sea.seminar;

public class SeminarApp {
//    public Object parent;

    public void run(String[] args, String personName) {
        Person p = new Person(personName);
//        p.parent= this;

        System.out.println("Hello Person," +p.getName()+"!");
    }
}
