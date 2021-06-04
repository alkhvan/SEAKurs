package de.telekom.sea;

import de.telekom.sea.Person;

public class PersonComparatorImpl implements PersonComparator {
    public int compare(Person person1, Person person2) {
//        person1.setName("Birne");
//        person1.setSurname("Maria");
//        person2.setName("Orange");
//        person2.setSurname("Maria");
        String p1n=person1.getName();
        String p1sur = person1.getSurname();
        String p2n = person2.getName();
        String p2sur = person2.getSurname();
        int result=0;
        int k=0;
       if (p1n.length()>p2n.length()){
           k=p2n.length();
       }
       else {
           k = p1n.length();
       }
       for (int i= 0; i<k;i++){
           if (p1n.charAt(i)==p2n.charAt(i)){
               result = 0;
           }else{
               if(p1n.charAt(i)>p2n.charAt(i)){
                   result=1;
                   return result;
               } else {
                   result =-1;
                   return result;
               }
           }
       }
       System.out.println(result);
    return result;
    }
}