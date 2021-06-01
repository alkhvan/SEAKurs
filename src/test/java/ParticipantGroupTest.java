import de.telekom.sea.writer_reader.MyList;
import de.telekom.sea.writer_reader.ParticipantGroup;
import de.telekom.sea.writer_reader.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipantGroupTest {

    private ParticipantGroup cut;

    @BeforeEach
    void setup() {
        cut = new ParticipantGroup(2);
    }

    @Test
    void add_test() {
        // check whether person could be added
        Person person = new Person("add_test name", "add_test surname");
        boolean result = cut.add(person);
        assertTrue(result);
        int size = cut.size();
        assertEquals(1, size);
    }

    @Test
    void add_null_test() {
        // check if person =null
        int size = cut.size();
        boolean result = cut.add(null);
        assertFalse(result);
        assertEquals(cut.size(), size);
    }

    @Test
    void clear_test() {
        // check clear methode, that it remove the persons
        Person person = new Person("clear_test name", "clear_test surname");
        cut.add(person);
        int size = cut.size();
        assertNotEquals(0, size);
        cut.clear();
        size = cut.size();
        assertEquals(0, size);
    }

    @Test
    void add_noPlaces_test() {
        //preconditions array[2] and place is already occupied:
        Person person = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person2 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person3 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person);
        cut.add(person2);
        System.out.println(cut.size());
        //test1:
        assertEquals(RuntimeException.class,noPlacesException(person).getClass());

    }

    @Test
    void add_noPlaces_test2() {
        //preconditions array[2] and place is already occupied:
        Person person = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person2 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person3 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person);
        cut.add(person2);

        //test2:
        boolean result;

        try {
            result = cut.add(person);
        }
        catch (RuntimeException re) {
            result = false;
        }
        assertFalse(result);

    }
    @Test
    void add_noPlaces_test3() {
        //preconditions array[2] and place is already occupied:
        Person person = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person2 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person3 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person);
        cut.add(person2);

        assertThrows(RuntimeException.class,()->{cut.add(person);});

    }

    RuntimeException noPlacesException (Person person){
        try{
            cut.add(person);
        }
        catch (RuntimeException rte){
            return rte;
        }
        return  null;
    }

    @Test
    void search_onePerson_test() {
        Person person = new Person("search_test name", "search_test surname");
        Person person1 = new Person("search_test name", "search_test surname2");
        cut.add(person);
        cut.add(person1);
        MyList result = cut.search("search_test surname2");
        assertEquals(1, result.size());
    }

    @Test
    void get_test() {
        Person person = new Person("get_test name", "get_test surname");
        cut.add(person);
        Person result = cut.get(0);
        assertNotNull(result);
        assertSame(result, person);
    }

    @Test
    void get_NOK_test() {
        Person result = cut.get(0);
        assertNull(result);
    }


    @Test
    void search_twoPersons_test() {
        Person person = new Person("search_twoPersons_test name", "search_twoPersons_test surname1");
        Person person1 = new Person("search_twoPersons_test name", "search_twoPersons_test surname2");
        cut.add(person);
        cut.add(person1);
        MyList result = cut.search("search_twoPersons_test");
        assertEquals(2, result.size());
    }

    @Test
    void remove_test() {
        // 2 persons should be added and 1 should be removed. check size
        // precondition
        Person person = new Person("search_twoPersons_test name", "search_twoPersons_test surname1");
        Person person1 = new Person("search_twoPersons_test name", "search_twoPersons_test surname2");
        cut.add(person);
        cut.add(person1);
        System.out.println(cut.size());
        //test
        assertTrue(cut.remove(person1));
        assertEquals(1, cut.size());

    }




    @AfterEach
    void teardown() {
        cut = null;
    }

}
