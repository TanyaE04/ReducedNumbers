package by.it.pages.number_pages;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReducedPageNumberTest {

	
	@Test
    public void reducedPageNumbers() {
        String str = "1,2,7,14,3,5,4,13,12,17";
        String actual=ReducedPageNumber.reducedPageNumbers(str);
        assertEquals("1-5,7,12-14,17", actual);
    }

    @Test
    public void repeatPageNumbers() {
        String str = "1,2,5,3,7,4,3,7,5,1,2";
        String actual=ReducedPageNumber.reducedPageNumbers(str);
        assertEquals("1-5,7", actual);
    }

    @Test
    public void pageNumbersWithWhiteSpace() {
        String str = "1, 2,5, 3,7,4, 3,7,5,1,2";
        String actual=ReducedPageNumber.reducedPageNumbers(str);
        assertEquals("1-5,7", actual);
    }

    @Test
    public void samePageNumbers() {
        String str = "4,4,4,4,4,4";
        String actual=ReducedPageNumber.reducedPageNumbers(str);
        assertEquals("4", actual);
    }

    @Test
    public void onePageNumbers() {
        String str = "25";
        String actual=ReducedPageNumber.reducedPageNumbers(str);
        assertEquals("25", actual);
    }

    @Test (expected = NumberFormatException.class)
    public void emptyPageNumbers() {
        String str = "";
        ReducedPageNumber.reducedPageNumbers(str);
    }

    @Test (expected = NumberFormatException.class)
    public void formatPageNumbers() {
        String str = "1,,,234,4,5,6";
        ReducedPageNumber.reducedPageNumbers(str);
    }

    @Test (expected = NumberFormatException.class)
    public void differentFormatPageNumbers() {
        String str = "1,two,234,4,five,6";
        ReducedPageNumber.reducedPageNumbers(str);
    }

    @Test (expected = NumberFormatException.class)
    public void negativePageNumbers() {
        String str = "1,,5,2,3,-4,-5";
        ReducedPageNumber.reducedPageNumbers(str);
    }

    @Test (expected = NumberFormatException.class)
    public void zeroPageNumbers() {
        String str = "3,9,1,4,2,0,15";
        ReducedPageNumber.reducedPageNumbers(str);
    }

    @Test (expected = NumberFormatException.class)
    public void doublePageNumbers() {
        String str = "3,9.0,1,4,2,7.3,15";
        ReducedPageNumber.reducedPageNumbers(str);
    }

}
