package de.telekom.sea;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComparatorTest {

    private PersonComparatorImpl cut;

    @BeforeEach
    void setup() {
        cut = new PersonComparatorImpl();
    }


    @Test
    void compare_test() {
        Person person1 = new Person("Birne","Anna");
        Person person2 = new Person("Birne","Maria");
        int result = cut.compare(person1,person2);
        System.out.println(result);
        assertEquals(0,result);


    }

    @Test
    void compare_not_equal_test() {
        Person person1 = new Person("Birne","Anna");
        Person person2 = new Person("Orange","Maria");
        int result = cut.compare(person1,person2);
        System.out.println(result);
        assertEquals(-1,result);


    }



    @AfterEach
    void teardown() {
        cut = null;
    }
}
