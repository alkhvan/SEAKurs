package de.telekom.sea.seminar;

import de.telekom.sea.copiedParticipantGroup.ParticipantGroup;

import java.util.Objects;

public class BaseObject extends Object {
     private Object parent;
     private static long idCounter =1;
     private long id;
     public  BaseObject(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    BaseObject (long id){
        this.id= idCounter++;
    }
    @Override
    public boolean equals (Object obj){
       if (obj == null){
           return  false;
           }
       if (this == obj){
       return true;
        }
       if (! (obj instanceof BaseObject)){
       return false;
        }
        BaseObject baseObject = (BaseObject) obj; // cast to BaseObject
         return (baseObject.id == this.id); // was imported from de.telekom.sea.copiedParticipantGroup.ParticipantGroup

    }

 public String toString(){
        return ((Long)id).toString();
 }




    public Object getParent() {
        return parent;
    }
    public void setParent(Object parent) {
        this.parent = parent;
    }

}
