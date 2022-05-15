package ru.pobedonostsev.library.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.pobedonostsev.library.utils.Utils;

@SpringBootTest
@ActiveProfiles("test")
class LibraryApplicationTest {

    @Test
    void contextLoads1() {
       Assertions.assertEquals(Utils.multiply(3,4),12);
    }


    @Test
    void contextLoads2() {
        Assertions.assertEquals(Utils.multiply(2,4),8);
    }


    @Test
    void contextLoads3() {
        Assertions.assertEquals(Utils.multiply(1,4),4);
    }
}
