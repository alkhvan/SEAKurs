package de.telekom.sea;
import de.telekom.sea.seminar.SeminarApp;
import de.telekom.sea.seminar.Person;

public class Main2 {
    public static void main(String[] args) {
        new Person();
        System.out.println("Hello World!");
        SeminarApp app = new SeminarApp();
        app.run(args);
    }
}
