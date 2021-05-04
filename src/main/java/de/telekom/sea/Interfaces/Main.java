package de.telekom.sea.Interfaces;


import de.telekom.sea.seminar.Menu;
import de.telekom.sea.seminar.Person;

public class Main {

    public static void main(String[] args){
        Person anton = new Person("Anton","Korol");
        ParticipantGroup interface1 =new ParticipantGroup();

      //  Event event =new Event();
        EventListener eventListener = new Menu();
      //  eventListener.receive(event);
        interface1.subscribe(eventListener);
        interface1.add(anton);

    }
}
