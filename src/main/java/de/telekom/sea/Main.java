package de.telekom.sea;


public class Main {

    public static void main(String[] args) throws Exception{
       // ParticipantGroup interface1 =new ParticipantGroup(3);
       // Person person = new Person("Anna","Banana");
       // interface1.add(person);
       // interface1.remove(person);
 //       interface1.test();
        PersonComparatorImpl pCI = new PersonComparatorImpl();
        Person person1 = new Person();
        Person person2 = new Person();
        pCI.compare(person1,person2);

    }
}
