package de.telekom.sea.writer_reader;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class PersonsListReader implements Closeable {
    String inputFile;
    FileReader fileReader;
  private PersonReader personReader;
    BufferedReader bufferedReader;

    public PersonsListReader(FileReader fileReader) {
        this.personReader = new PersonReader(fileReader);
        this.fileReader = fileReader;
    }

    Person[] read() throws IOException {
        Person[] persons = new Person[0];
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArrayList<Person> list = new ArrayList<>();
            String s = bufferedReader.readLine();
        while (s != null){
            System.out.println(".csv file contains the following information: "+s);
            list.add(personReader.read(s));
            s = bufferedReader.readLine();


        }
        persons =list.toArray(new Person[0]);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public void close() throws IOException {
        fileReader.close();
    }
}
