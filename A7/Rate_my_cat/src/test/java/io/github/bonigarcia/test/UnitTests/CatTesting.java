package io.github.bonigarcia.test.UnitTests;
import io.github.bonigarcia.*;

//import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CatTesting {

	String nameTestCat = "Gato";
	String pictureTestCat = "baby.jpg";
	Cat testCat1 = new Cat(nameTestCat,pictureTestCat);

	@Test
	public void testGetName() {
		String nameResponse = testCat1.getName();
		assertEquals(nameResponse,nameTestCat);
	}

	@Test
	public void testStringRatingWhitoutOpinions() {
		List<Opinion> emptyOpinionList = new ArrayList<Opinion>();
		testCat1.setOpinions(emptyOpinionList);
		String rateResponse = testCat1.getAverageRateAsString();
		String expectedResponse = "Not rated";
		assertEquals(expectedResponse,rateResponse);
	}

	Cat testCat2 = new Cat(nameTestCat,pictureTestCat);
	String emptyComment = "";
	double stars = 5.0;

	@Test
	public void testStringRatingWithOneOpinion() {
		testCat2.rate(stars, emptyComment);
		String rateResponse = testCat2.getAverageRateAsString();
		String expectedResponse = "5.00";
		assertEquals(expectedResponse,rateResponse);
	}

	@Test
	public void testOpinionListSize() {
		testCat2.rate(stars, emptyComment);
		int sizeResponse = testCat2.getOpinionsSize();
		int expectedResponse = 1;
		assertEquals(expectedResponse,sizeResponse);
	}


	@Mock
	Cat mockedCat2 = Mockito.mock(Cat.class);
	@Test
	public void testAverageRateWithMocks() {
		when(mockedCat2.getAverageRate()).thenReturn(2.5);
		double rateResponse = mockedCat2.getAverageRate();
		double expectedResponse = 2.5;
		assertEquals(expectedResponse,rateResponse);
	}


	@InjectMocks
	Cat mockedCat = new Cat("mockedCat","baby.jpg");
	@Mock
	List<Opinion> opinions = Mockito.mock(ArrayList.class);
	@Test
	public void testOpinionListSizeWithMocks() {
		when(opinions.size()).thenReturn(5);
		mockedCat.setOpinions(opinions);
		int sizeResponse = mockedCat.getOpinionsSize();
		int expectedResponse = 5;
		assertEquals(expectedResponse,sizeResponse);
	}


}