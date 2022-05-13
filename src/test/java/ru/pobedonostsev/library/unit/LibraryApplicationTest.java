package ru.pobedonostsev.library.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class LibraryApplicationTest {

    @Test
    void contextLoads1() {
       Assertions.assertEquals(1,1);
    }

    @Test
    void contextLoads2() {
        Assertions.assertEquals(1,1);
    }

    @Test
    void contextLoads3() {
        Assertions.assertEquals(1,1);
    }
}
