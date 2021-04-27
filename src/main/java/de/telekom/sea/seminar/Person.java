package de.telekom.sea.seminar;

public class Person extends Child{
     private String name;

    public String getSurname() {
        return surname;
    }

    private String surname;
       public  Person(String name,String surname){
       this.name=name;
       this.surname=surname;
    }
     public String getName() {
      return name;
   }


}
