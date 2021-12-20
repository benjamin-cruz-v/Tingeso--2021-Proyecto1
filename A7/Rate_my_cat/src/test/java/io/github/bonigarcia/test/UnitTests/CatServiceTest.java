package io.github.bonigarcia.test.UnitTests;

import io.github.bonigarcia.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatServiceTest {

    @DisplayName("Test de cantidad de objetos Cat en CatRepository")
    @Test
    void getCatCount() {
        CatRepository catRepositoryMock = Mockito.mock(CatRepository.class); //Objeto Mock
        CatService catService = new CatService(catRepositoryMock);
        Cat gatusso = new Cat("gatusso","picture.jpg");
        Cat gaturro = new Cat("gaturro","picture2.jpg");
        //se crea una lista y se añaden los objetos Cat a esta
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(gatusso);
        cats.add(gaturro);
        when(catRepositoryMock.findAll()).thenReturn(cats);
        //Verificación
        assertEquals(2,catService.getCatCount());
    }


    @DisplayName("Test de rating promedio de un gato (objeto Cat)")
    @Test
    void rateCat(){
        CatRepository catRepositoryMock = Mockito.mock(CatRepository.class); //Objeto Mock
        CatService catService = new CatService(catRepositoryMock);
        //se instancia un objeto Cat
        Cat gato = new Cat("gato","picture3.jpg");
        //dos rating para el gato
        catService.rateCat(2,gato);
        catService.rateCat(4,gato);
        //Verificación
        assertEquals(3,gato.getAverageRate());
    }

    @DisplayName("Test de verificación que gatos no se guardan a menos que haya un objeto Logger involucrado")
    @Test
    void saveCat() {
        CatRepository catRepositoryMock = Mockito.mock(CatRepository.class); //Objeto Mock
        CatService catService = new CatService(catRepositoryMock);

        Cat pelusa = new Cat("pelusa","picture0.jpg");
        Cat michi = new Cat("michi","picture1.jpg");

        catService.saveCat(pelusa);
        catService.saveCat(michi);

        assertEquals(catService.getCatCount(),0);
    }
}