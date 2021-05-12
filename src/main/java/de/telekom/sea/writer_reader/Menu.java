package de.telekom.sea.writer_reader;



import java.io.*;

import java.util.Scanner;


import static de.telekom.sea.writer_reader.Salutation.*; //Import from static things

public class Menu implements MyMenu, EventListener, Closeable {
    private MyList myList;

    public void close () throws IOException {
        System.out.println("is closed");
    }

    public Menu(MyList myList) {
        this.myList = myList;
    }

 //   public Menu menu (){return this;}


    public void receive( Event event ){
        listAllPersons();
        System.out.println();

    };
    public void testListe(){
        MyList subliste = new ParticipantGroup(3);
        Person person1 =new Person("Anna","Frank", MRS);
        subliste.add(person1);
        Person person2 =new Person("Anka","Frank",  MRS);
        subliste.add(person2);
        Person person3 =new Person("Alfred","Rank",MR);
        subliste.add(person3);
    };
    public void setMyList(MyList myList) {
        this.myList = myList;
        System.out.println("Method setMyList was successfully performed: " + myList);

    }

    public void keepAsking() throws IOException, IllegalAccessException {
        String result;
        do {
            showMenu();
            result = checkMenu();
        }
        while (!result.equals("0"));

    }


    public void showMenu() {
        System.out.println("1 - input person");
        System.out.println("2 - show size");
        System.out.println("3 - list all persons");
        System.out.println("4 - remove all");
        System.out.println("5 - remove person");
        System.out.println("6 - search person by surname");
        System.out.println("7 - create a list of persons in the separate file");
        System.out.println("8 - read a list of persons from the separate file");
        System.out.println("0 - exit");
    }

    public void inputPerson() throws IllegalAccessException {
        System.out.println("Enter Name of person.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter Surname of person.");
        String surname = scanner.nextLine();
        Person person = new Person();
        System.out.println("Enter Salutation of person.");
        try{person.setSalutation(Salutation.fromString(scanner.nextLine()));}
        catch (Exception e){
            System.out.println("Select the gender correctly");
            inputPerson();
            return;
        }
        person.setName(name);
        person.setSurname(surname);

        myList.add(person);
        System.out.println("Your person" + name + " " + surname + " was added");
    }

    public void inputSearch() {
        System.out.println("Enter Surname of person.");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.nextLine();
        MyList sublist = myList.search(surname);
        this.listAllPersons();
//        Person person = new Person();
//        person.setSurname(surname);
//        MyList searchMeth = new ParticipantGroup(3);
//        searchMeth.search(surname);

    }


    public void listAllPersons() {

        System.out.println("############### Persons List ###############");
        for (int i = 0; i < myList.size();  i++){
            Object obj = myList.get(i);
            if (obj != null) {
                Person person = (Person) obj;
                System.out.println((i+1) + ". " + person.getSurname() + " " + person.getName()+ " "+person.getSalutation());
            }
        }
        System.out.println("Persons count: " + myList.size() + ".");

    }

    public void removeAll() {
        myList.clear();
    }

    public void removePerson() {
       System.out.println("Input person's index to delete: ");
       int i = Integer.parseInt(inputLine());
       myList.remove(i);
    }


    public String checkMenu() throws IOException, IllegalAccessException {
        String result;
        result = inputLine();
        switch (result) {
            case "1":
                System.out.println("It's 1. Input person.");
                inputPerson();
                break;
            case "2":
                System.out.println("It's 2. Show size.");
                showSize();
                break;
            case "3":
                System.out.println("It's 3. List all persons.");
                listAllPersons();
                break;
            case "4":
                System.out.println("It's 4. Remove all.");
                removeAll();
                break;
             case "5":
                 System.out.println("It's 5. Remove one person from the list.");
                 removePerson();
                 break;
            case "6":
                System.out.println("It's 6. Search person from the list.");
                inputSearch();
                break;
            case "7":
                System.out.println("It's 7. Create list of persons");
                saveList();
                break;
            case "8":
                System.out.println("It's 8. Read the imported list");
                readList();
                break;
            case "0":
                System.out.println("It's 0. Exit.");
                break;
            default:
                System.out.println("Please chose an valid number. To show all options input 1. 0 to exit.");
        }
        return result;
    }

    public String inputLine() {

        String result = "";
        Scanner scanner = new Scanner(System.in);
        result = scanner.nextLine();
        return result;
    }

    public void showSize() {
        System.out.println("There are " + myList.size() + " element(s) in the list.");
    }

    public void saveList ( ) throws IOException {
        System.out.println("Please input file name:");
        String outputFileName = "src/test/resources/" + inputLine() + ".csv";
//        FileWriter fileWriter = new FileWriter(outputFileName);
//        try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
//            for (int i = 0; i < myList.size(); i++) {
//                fileWriter.write((i + 1) + ". " + myList.get(i) + " " + myList.get(i) + "\n");
//            }
//        }
        try (FileWriter fileWriter = new FileWriter(outputFileName);){
            PersonsListWriter personsListWriter;
            personsListWriter = new PersonsListWriter(fileWriter);
            personsListWriter.write((ParticipantGroup) myList);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readList() throws IllegalAccessException {
        System.out.println("Please input file name:");
        String inputFileName = "src/test/resources/" + inputLine() + ".csv";

        try (FileReader fileReader= new FileReader(inputFileName)) {
            PersonsListReader personsListReader;
            personsListReader = new PersonsListReader(fileReader);
            setMyList(personsListReader.read());
            listAllPersons();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int inputInt() {
        int result;
        Scanner scanner = new Scanner(System.in);
        result = scanner.nextInt();
        return result;
    }
}