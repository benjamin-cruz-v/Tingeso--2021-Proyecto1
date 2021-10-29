package io.github.bonigarcia.test.UnitTests;

import io.github.bonigarcia.Cat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpinionSizeTesting {

    @Test
    @DisplayName("Verifica que el tamaño de la lista, inicialmente sea 0")
    //@RunWith(MockitoJUnitRunner.class)
    void OpinionSizeTest(){
        Cat mockCat = Mockito.mock(Cat.class);
        assertEquals(0,mockCat.getOpinionsSize());
    }
}
