package de.telekom.sea.writer_reader;


public class Person extends BaseObject  {

    private String name;
    private String surname;
    private Salutation salutation;


    public Salutation getSalutation() {
        return salutation;
    }


    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }




    public void setName(String name) {
        this.name = name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }




    public String getSurname() {
        return surname;
    }

    public Person(){

    }

    public Person(String name, String surname){
       this.name=name;
       this.surname=surname;
    }
    public Person(String name,String surname, Salutation salutation){
        this.name=name;
        this.surname=surname;
        this.salutation=salutation;


    }

     public String getName() {
      return name;
   }


       public boolean equals(final Person pers) {
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
        if (!(pers instanceof Person)){
          return false;
        }
        else {
            return false;
        }
    }
}
