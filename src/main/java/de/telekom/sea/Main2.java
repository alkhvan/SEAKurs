package de.telekom.sea;
import de.telekom.sea.seminar.*;


public class Main2 {
    public static void main(String[] args) {
        SeminarApp app = new SeminarApp();
        app.setParent(null);
        var app2=app.getRootApp();
        System.out.println(app2);
        app.run ();
    }
}
