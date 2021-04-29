package de.telekom.sea.seminar;
import de.telekom.sea.copiedParticipantGroup.MyList;
import de.telekom.sea.copiedParticipantGroup.ParticipantGroup;

public class SeminarApp extends Child{
    private Object [] persons = new Object[3];
    private static SeminarApp thisInstance;
    // constructor einer neuen Instanz
    public SeminarApp() {
        thisInstance = this;
    }
    public void run() {
        Person child = new Person();
        child.setParent(this);
        test();
    }
    public void test() {
        ParticipantGroup interface1 =new ParticipantGroup();
//        System.out.println("=====new Person was added to the list===== ");
        Person person1 =new Person("Anna","Frank");
        interface1.add(person1);
//        System.out.println("=====new Person was added to the list===== ");
        Person person2 =new Person("Maria", "Block");
        interface1.add(person2);
//        System.out.println("=====new Person was added to the list===== ");
        Person person3 =new Person("Valeria", "Hundertwasser");
        interface1.add(person3);

        Menu menu =new Menu();
        MyList list =new ParticipantGroup();
        menu.setMyList(list);
        menu.keepAsking();

    }
    public Object getRootApp(){
        return this;
    }
}
