package de.telekom.sea.seminar;
import de.telekom.sea.copiedParticipantGroup.ParticipantGroup;

public class SeminarApp extends Child {
    public void run() {
        Person child = new Person();
        child.setParent(this);

        ParticipantGroup interface1 =new ParticipantGroup();
        Person person1 =new Person();
        System.out.println("=====new Person was added to the list===== ");
        person1.setName( "Anna");
        person1.setSurname( "German");
        interface1.add(person1);
        System.out.println("=====new Person was added to the list===== ");
        Person person2 =new Person();
        person2.setName( "Danna");
        person2.setSurname( "Neman");
        interface1.add(person2);
        System.out.println("=====new Person was added to the list===== ");
        Person person3 =new Person();
        person3.setName( "Alla");
        person3.setSurname( "Freeman");
        interface1.add(person3);

        System.out.println("Teilnehmersanzahl: "+interface1.size());
        System.out.println("=====Person was removed from the list===== ");
        interface1.remove(person1);
        System.out.println("Teilnehmersanzahl after deletion: "+interface1.size());
        System.out.println("=====Method clear===== ");
        interface1.clear();

        System.out.println("=====new Person was added to the list===== ");
        person1.setName("Alex");
        interface1.add(person1);
        System.out.println("Teilnehmersanzahl: "+interface1.size());
    }
    public Object getRootApp(){
        return this;
    }
}
