package io.github.bonigarcia.test.UnitTests;

import io.github.bonigarcia.Cat;
import io.github.bonigarcia.CatRepository;
import io.github.bonigarcia.CatService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatServiceTest {

    @DisplayName("Verificación de cantidad de objetos de gatos en CatRepository")
    @Test
    void getCatCount() {
        CatRepository catRepositoryMock = Mockito.mock(CatRepository.class); //Objeto Mock
        CatService catService = new CatService(catRepositoryMock);

        Cat gatusso = new Cat("gatusso","picture.jpg");
        Cat gaturro = new Cat("gaturro","picture2.jpg");

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(gatusso);
        cats.add(gaturro);

        when(catRepositoryMock.findAll()).thenReturn(cats);

        assertEquals(2,catService.getCatCount());
    }
}