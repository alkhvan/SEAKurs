package de.telekom.sea;

public interface MyList {
 void setMyList(MyList myList);
    boolean add(Object obj);
     int size();
     Object get(int i);
     boolean remove(Object obj);
     void clear();
      MyList search(String suchBuchst);

}
