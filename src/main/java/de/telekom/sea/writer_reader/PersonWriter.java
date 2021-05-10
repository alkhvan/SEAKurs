package de.telekom.sea.writer_reader;


import java.io.FileWriter;
import java.io.IOException;

public  class  PersonWriter {
    FileWriter fileWriter;
    void write (Person person) throws IOException{
        fileWriter.write(person.getSurname()+ " "+ person.getName() + "\n");

    }
    public  PersonWriter (FileWriter fileWriter){
        this.fileWriter=fileWriter;
    }

}
