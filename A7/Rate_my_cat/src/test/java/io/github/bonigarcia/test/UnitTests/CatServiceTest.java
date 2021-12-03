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
    
}