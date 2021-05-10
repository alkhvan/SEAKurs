package de.telekom.sea.seminar;
import de.telekom.sea.copiedParticipantGroup.MyList;
import de.telekom.sea.copiedParticipantGroup.ParticipantGroup;

public class SeminarApp extends BaseObject{
    //new branch
    private Object [] persons = new Object[3];
    private static SeminarApp theInstance;
    // constructor einer neuen Instanz
    public SeminarApp() {
        if (theInstance == null) {
            theInstance = this;
        }
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

        Person person4= person1;

        System.out.println("Person1 getId: " + person1.getId());
        System.out.println("Person2 getId: " + person2.getId());
        System.out.println("Person3 getId: " + person3.getId());
        System.out.println("Person4 getId: " + person4.getId());
        System.out.println("Person1 toString: " + person1.toString());
        System.out.println("Person2 toString: " + person2.toString());
        System.out.println("Person3 toString: " + person3.toString());
        System.out.println("Person4 toString: " + person4.toString());
        System.out.println("Person1 == null (ER: false): " + person1.equals(null));
        System.out.println("Person1 == person1 (ER: true): " + person1.equals(person1));
        System.out.println("Person1 == person4 (ER: true): " + person1.equals(person4)); //returns false if Person.equals in not commented, since name/surname are different
        System.out.println("Person1 == person3 (ER: false): " + person1.equals(person3));
        System.out.println("Person1 == person3 (ER: false): " + person1.equals(person2));

//        Menu menu =new Menu();
//        MyList list =new ParticipantGroup();
//        menu.setMyList(list);
//        menu.keepAsking();


    }
    public Object getRootApp(){
        return this;
    }
}
