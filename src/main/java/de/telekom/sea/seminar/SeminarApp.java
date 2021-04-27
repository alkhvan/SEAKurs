package de.telekom.sea.seminar;

public class SeminarApp {
    public Object parent;

    public void run(String[] args, String personName) {
        Person child = new Person(personName);
        child.setParent(this);
        System.out.println("Hello Person," +child.getName()+"!");
    }
}
