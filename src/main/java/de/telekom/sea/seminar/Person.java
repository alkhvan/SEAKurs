package de.telekom.sea.seminar;

public class Person {
    private Object parent;
    private String name;

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

       public  Person(String name){
       this.name=name;
    }



   public String getName() {
      return name;
   }


}
