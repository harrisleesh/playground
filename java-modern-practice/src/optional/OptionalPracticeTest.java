package optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalPracticeTest {

    @Test
    void optionalBasic(){
        String name = "harris";
        String name2 = null;
        Optional<String> optionalName = Optional.of(name);
        assertTrue(optionalName.isPresent());
        assertFalse(optionalName.isEmpty());
        assertThrows(NullPointerException.class, () -> Optional.of(name2));
        Optional<String> optionalName2 = Optional.ofNullable(name2);
        assertFalse(optionalName2.isPresent());
        assertTrue(optionalName2.isEmpty());
    }

    @Test
    void conditionalActionWithIfPresent(){
        Optional<String> harris = Optional.of("harris");
        harris.ifPresent(name -> System.out.println(name));
    }

    @Test
    void defaultValueWithOrElse(){
        String name = null;
        String defaultName = "harris";
        String harris = Optional.ofNullable(name).orElse(defaultName);
        assertEquals(harris, defaultName);
    }
}