package de.telekom.sea.seminar;

import de.telekom.sea.copiedParticipantGroup.MyList;

public interface MyMenu {

     void setMyList(MyList myList);
     void showMenu();
     void readMenu();
     void inputPerson();
     String inputLine();
//     private String checkMenu( );
     void keepAsking();
     void readPerson();
     void listAllPersons();
     void removeAll();

}
