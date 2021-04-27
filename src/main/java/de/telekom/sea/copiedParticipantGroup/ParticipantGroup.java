package de.telekom.sea.copiedParticipantGroup;
import de.telekom.sea.seminar.*;
public class ParticipantGroup  extends Child{
//    Participant[] participants = new Participant[3];
 private Object [] participants = new Object[3];


    public boolean add(Object obj) {
        if (!(obj instanceof Person)){
            System.out.println("It`s not a person");
            return false;
        }
        if (size()>participants.length ){
            return false;
        }
        participants [size()] = obj;
        return true;
    }

    public int size(){
        int i =0;
       while (i<participants.length && participants[i]!=null) {  //oder <= hier?
           i++;
       }
      return i;
    }

    public void clear (){
        this.participants = new Person [3];
    }

    public Object get (int i){
        System.out.println(participants[i]);
        return participants[i];
    }




//    public boolean remove (Object participant){
//        int k =2;
//        while (participants[k]!=null && k<participants.length-1) {
//            k++;
//            participants[k] = null;
//        }
//        return true;
//    }
    public boolean remove (Object participant){
        if (participant==null){
            System.out.println("Person was not added, can not perform delete");
            return false;
        }
        int i=0;
        while (!(participants[i].equals(participant)|| i<=participants.length))
            i++;

        if (participant.equals(participants[i])){
            System.out.println("Deleting element №"+i);
            participants[i]=null;
            int k;
            for (k=i; k<(participants.length-1); k++ ){
                participants[k] =participants [k+1];

            }
            participants[participants.length-1]=null;
           return true;
        }
    System.out.println("Not found");
        return false;
    }


public class Objects {

    public  boolean equals(Object a, Object b)
    {
        return (a == b) || (a != null && a.equals(b));
    }
}

}
