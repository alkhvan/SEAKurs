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

       public boolean equals(Person pers) {
        if (pers == null) // null check
        {
            return false;
        } else if (this == pers) // self check
        {
            return true;
        }
        if (getClass() != pers.getClass()) {
            return false;
        }
        //    if ((this.getVorname())!= (p.getVorname())) {
        //        return false;
        //    }
        //    if ((this.getName())!= (p.getName())) {
        //        return false;
        //    }
        else if (this.name.equals(pers.surname)&& this.surname.equals(pers.surname)) // type check
        {
            return false;
        }
        else {
            return false;
        }
    }
}
