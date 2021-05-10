package de.telekom.sea.writer_reader;


//import java.io.BufferedReader;
//import java.io.IOException;
//
//public class PersonsListReader {
//    String inputFile;
//    public PersonsListReader(String inputFile) {
//        this.inputFile = inputFile;
//    }
//    String[] read() throws IOException {
//        String[] persons = new String[10];
//        try (BufferedReader reader = new BufferedReader(inputFile) {
//            for (int i = 0; i < 10; i++) {
//                persons[i] = reader.readLine();
//            }
//        }
//        catch (IOException e) {
//            a.printStackTrace();
//        }
//        return persons;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonsListReader {
    String inputFile;

    public PersonsListReader(String inputFile) {
        this.inputFile = inputFile;
    }


    String[] read() throws IOException {
        String[] persons = new String[10];
        try (BufferedReader reader = new BufferedReader(inputFile)) {
            for (int i = 0; i < 10; i++) {
                persons[i] = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
