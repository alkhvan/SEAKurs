package de.telekom.sea;


import java.io.FileWriter;
import java.io.IOException;

public  class  PersonWriter {
    FileWriter fileWriter;
    void write (Person person) throws IOException{
  //      fileWriter.write(person.getId() +person.getSurname()+ " "+ person.getName() + "\n");
        fileWriter.write(String.format("%s;%s;%s\n", person.getId().toString(),person.getSurname(),person.getName()));

    }
    public  PersonWriter (FileWriter fileWriter){
        this.fileWriter=fileWriter;
    }

}
