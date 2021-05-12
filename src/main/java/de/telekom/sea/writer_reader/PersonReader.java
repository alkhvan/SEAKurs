package de.telekom.sea.writer_reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class PersonReader {

    FileReader fileReader;

    BufferedReader bufferedReader;

    public PersonReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Object read(String s) {
        if (s != null) {
            Person person = new Person ();
            String[] result = s.split(";");
            person.setSurname(result[1].trim());
            person.setName(result[2].trim());
            person.setId(Long.parseLong(result[0].trim()));
            return person;
        }
        else {
            return null;
        }
    }
//        if (!line.isEmpty()){
//            person = new Person(line);
//            String [] result  = line.split(";");
//            String id = result [0];
//            String surname = result [1];
//            String name = result [2];
//
//        }
//        return person;
//    }
}