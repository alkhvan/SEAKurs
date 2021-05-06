package de.telekom.sea.Interfaces;

import java.io.Closeable;
import java.io.IOException;

public class ParticipantGroup extends BaseObject implements MyList, EventRegistration {
       //    Participant[] participants = new Participant[3];
  public final int LENGTH;

 private Object[] participants = new Object[3];

 private EventListener eventListener = null;

 private void receiveEvent (Event event){
     if (this.eventListener != null){
         this.eventListener.receive(event);
     }
 }

 public void test(){
     MyList myList =new ParticipantGroup(3);
  //   ParticipantGroup interface1 =new ParticipantGroup(3);

     Event eventTest  = new Event("Test description","test name");
     EventListener eventListener = new Menu(myList);

     //  eventListener.receive(event);
     try(Menu imenu = new Menu (myList)){
         imenu.setMyList(myList);
         subscribe(eventListener);
         imenu.keepAsking();
         imenu.receive(eventTest);
     }
     catch (IOException e){
         e.printStackTrace();
       //  close();
     }
     catch (Exception ex)
     {
         ex.printStackTrace();
     }



 }

    public ParticipantGroup(int LENGTH) {
        this.LENGTH = LENGTH;
    }

    public int getLENGTH() {
        return LENGTH;
    }

    private boolean isFull() {
        if (size() == LENGTH) {
            System.out.println("The list is full.");
            return true;
        }
        return false;
    }


    public void subscribe(EventListener eventListener){

        this.eventListener = eventListener;
        System.out.println(
                eventListener  + " is successfully added to Subscription" );


    }

    public boolean add(Object obj) {

        if (size() == participants.length) {
            System.out.println("Sorry! No more places");
            throw new RuntimeException("RuntimeException. Please check i");
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
            Event event = new Event ("Element is added to the list", "list is full");
            System.out.println(event.description);
      //      this.eventListener.receive(event);
      //      receiveEvent(characteristicIsNull);


            return true;
        }
  //      return false;
        else {
            throw new RuntimeException("RuntimeException. Please check i");
        }
    }

    public int size(){
        int i =0;
       while (i<participants.length && participants[i]!=null)   //oder <= hier?
           i++;
       return i;
    }

    public void clear (){
        this.participants = new Person [3];
        Event event = new Event("All elements are removed from the list","list is empty");
        this.eventListener.receive(null);
    }

    public Object get (int i) {
        if (i < participants.length) {
            System.out.println(participants[i]);
            return participants[i];
        } else {
            throw new RuntimeException("RuntimeException.");
        }
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
                Event event = new Event("Element is removed from the list","Element is removed");
                this.eventListener.receive(event);
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
