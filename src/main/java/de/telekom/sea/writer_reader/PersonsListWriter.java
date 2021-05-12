package de.telekom.sea.writer_reader;
import java.io.FileWriter;
import java.io.IOException;

public class PersonsListWriter {


        PersonWriter personWriter;
        void write(ParticipantGroup personsList) throws IOException {
            for (int i = 0; i < personsList.size(); i++) {
                personWriter.write(personsList.get(i));
            }
        }
        PersonsListWriter( FileWriter fileWriter) throws IOException {
            this.personWriter = new PersonWriter(fileWriter);
        }
    }

