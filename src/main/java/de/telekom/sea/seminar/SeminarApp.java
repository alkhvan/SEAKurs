package de.telekom.sea.seminar;

public class SeminarApp extends Child {
    public void run(String[] args, String personName, String personSurname) {
        Person child = new Person(personName,personSurname);
        child.setParent(this);
        System.out.println("Hello, Person:" +child.getName()+ " "+ child.getSurname()+"!");
    }
    public Object getRootApp(){
        return this;
    }
}
