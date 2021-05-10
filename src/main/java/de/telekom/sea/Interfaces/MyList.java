package de.telekom.sea.Interfaces;

public interface MyList {

    boolean add(Object obj);
     int size();
     Object get(int i);
     boolean remove(Object obj);
     void clear();
      MyList search(String suchBuchst);

}
