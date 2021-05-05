package de.telekom.sea.Interfaces;



public class Main {

    public static void main(String[] args) throws Exception{

        MyList myList =new ParticipantGroup(3);

    //    Person anton = new Person("Anton","Korol");

        ParticipantGroup interface1 =new ParticipantGroup(3);
        Event eventTest  = new Event("Test description","test name");

      //  Event event =new Event();
        EventListener eventListener = new Menu(myList);

      //  eventListener.receive(event);
        interface1.subscribe(eventListener);

  //      interface1.add(anton);
  //      interface1.add(boris);
  //      interface1.add(anna);
        interface1.subscribe(eventListener);
        Menu imenu = new Menu (interface1);
        imenu.keepAsking();
        imenu.receive(eventTest);
     //   interface1.remove(anton);
    //    Person mike = new Person("Mike", "Mikelson");
      //  interface1.add(mike);


      //  interface1.clear();

    }
}
