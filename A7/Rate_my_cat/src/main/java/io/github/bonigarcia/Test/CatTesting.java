package io.github.bonigarcia.Test;
import io.github.bonigarcia.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;



public class CatTesting {

	@Mock
	String nameTestCat = "Gato";
	String pictureTestCat = "baby.jpg";
	Cat testCat = new Cat(nameTestCat,pictureTestCat);
	
	
	@Test
	//Test para verificar que un gato no tiene calificación cuando no se han escrito comentarios ni calificado. 
	public void testRatingWhitoutOpinion() {
		List<Opinion> emptyOpinionList = new ArrayList<Opinion>();
		testCat.setOpinions(emptyOpinionList);
		String rateResponse = testCat.getAverageRateAsString();
		String expectedResponse = "Not rated";
		assertEquals(expectedResponse,rateResponse);
	}
	
}
