package de.telekom.sea.writer_reader;

public interface MyList {

    boolean add(Object obj);
     int size();
     Object get(int i);
     boolean remove(Object obj);
     void clear();
      MyList search(String suchBuchst);

}
