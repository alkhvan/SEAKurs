package de.telekom.sea.writer_reader;

import java.io.FileReader;

public class PersonReader {

    FileReader fileReader;
    Person person;

    public PersonReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Person read(String line) {
        if (!line.isEmpty()){
            person = new Person(line);
        }
        return person;
    }
}