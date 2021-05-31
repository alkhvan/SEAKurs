package de.telekom.sea.writer_reader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ParticipantGroup extends BaseObject implements MyList, EventRegistration {
       //    Participant[] participants = new Participant[3];
 private int LENGTH;
 private MyList myList;

 private Object[] participants;
    private ArrayList<EventListener> listenerList = new ArrayList();

    public ParticipantGroup(MyList myList) {
        this.myList = myList;
    }
    //private EventListener eventListener = null;

// private void receiveEvent (Event event){
//     if (this.eventListener != null){
//         this.eventListener.receive(event);
//     }
// }
public void subscribe(EventListener eventListener){
    listenerList.add(eventListener);
    //this.eventListener = eventListener;
}

    public void unsubscribeAll(){
        listenerList.clear();
    }


    private void sendEvent(String eventName, String eventDescription) {
        Event event = new Event(eventName, eventDescription);
        for (EventListener e : listenerList) {
            e.receive(event);
        }
    }

 public void test(){
     MyList myList =new ParticipantGroup(3);

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


 public MyList search(String searchSurname) {
     MyList sublist = new ParticipantGroup(LENGTH);
   //  Menu menu = new Menu(subliste);

     for (int i = 0; i < size(); i++) {
         Object obj = participants[i];
         Person person = (Person) obj;
         String surname = person.getSurname();


         if (surname.startsWith(searchSurname)) {
             sublist.add(person);
             System.out.println(surname);

         }
     }
     return sublist;
 }

    public ParticipantGroup(int length) {
        this.LENGTH = length;
        this.participants =new Person[LENGTH];
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
            participants[size()] = person;
            System.out.println(person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
            //Event newElement = new Event ("Element is added to the list", "New person in the list");
     //       receiveEvent(newElement);
            return true;
        }
       return false;
//        else {
//            throw new RuntimeException("RuntimeException. Please check i");
//        }
    }

    public int size(){
        int i =0;
       while (i<participants.length && participants[i]!=null)   //oder <= hier?
           i++;
       return i;
    }

    public void clear (){
        this.participants = new Person [LENGTH];

    }

    public Person get (int i) {
        if (i < participants.length&& i>=0) {

            return (Person) participants[i];
        } else {
            throw new RuntimeException("RuntimeException. Method get");
        }
    }

    public boolean isFull() {
        if (size() == LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public boolean remove (Object obj) {
     System.out.println("Remove person from the list");
        if (obj == null) {
            System.out.println("Person was not added, can not perform delete");
            return false;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        for (int i = 0; i < participants.length; i++) {
            if (person.equals(participants[i])) {
                System.out.println("Deleting element " + i + "...");
                for (int j = i; j < (participants.length - 1); j++) {

                    participants[j] = participants[j + 1];
                }
                participants[participants.length - 1] = null;
                System.out.println("Element " + i + " was deleted from the list of participants (" + person.getName() + " " + person.getSurname() + ").");
//                Event removeElement = new Event ("Element is removed from the list", "Person in removed");
//                receiveEvent(removeElement);
                return true;
            }
        }
        System.out.println("Can't be deleted. " + person.getName() + " " + person.getSurname() + "is not found in the list.");
        return false;
    }
    public void setMyList(MyList myList){
    this.myList= myList;

    };
    public class Objects {

        public  boolean equals(Object a, Object b)
        {
            return (a == b) || (a != null && a.equals(b));
        }
    }

}
