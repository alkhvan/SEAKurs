package de.telekom.sea.copiedParticipantGroup;
import de.telekom.sea.seminar.*;

import java.util.Scanner;

public class ParticipantGroup extends Child implements MyList{
//    Participant[] participants = new Participant[3];
 private Object [] participants = new Object[3];



    public boolean add(Object obj) {
        if (size() == participants.length) {
            System.out.println("Sorry! No more places");
            return false;
                    }
        if (obj == null) {
            System.out.println("Sorry! Null is not a valid person");
            return false;
        }
        if (!(obj instanceof Person)) {
            System.out.println("It`s not a person");
            return false;
        }
        Person person = (Person) obj;
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] != null && participants[i].equals(person)) {
                System.out.println("Person was already added");
                return false;
            }
        }
        if (size() < participants.length) {
            participants[size()] = obj;
            System.out.println(person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
            return true;
        }
        return false;
    }

    public int size(){
        int i =0;
       while (i<participants.length && participants[i]!=null)   //oder <= hier?
           i++;
       return i;
    }

    public void clear (){
        this.participants = new Person [3];
    }

    public Object get (int i){
        System.out.println(participants[i]);
        return participants[i];
    }

    public boolean remove (Object obj) {
        if (obj == null) {
            System.out.println("Person was not added, can not perform delete");
            return false;
        }

        Person person = (Person) obj;
        for (int i = 0; i < participants.length; i++) {
            if (person.equals(participants[i])) {
                System.out.println("Deleting element #" + i + "...");
                for (int j = i; j < (participants.length - 1); j++) {
                    participants[j] = participants[j + 1];
                }
                participants[participants.length - 1] = null;
                System.out.println("Element " + i + " was deleted from the list of participants (" + person.getName() + " " + person.getSurname() + ").");
                return true;
            }
        }
        System.out.println("Can't be deleted. " + person.getName() + " " + person.getSurname() + "is not found in the list.");
        return false;
    }

    public class Objects {

        public  boolean equals(Object a, Object b)
        {
            return (a == b) || (a != null && a.equals(b));
        }
    }

}
