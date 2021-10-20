package calculatorTest;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import calculator.StringCalculator;

public class StringCalculatorShould {
	
	@Test
	public void testEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void testMultipleNumbers() {
		assertEquals(10, StringCalculator.add("1,9"));
		assertEquals(10, StringCalculator.add("1,1,3,5"));
	}

	@Test
	public void testNewLine() {
		assertEquals(9, StringCalculator.add("1\n5,3"));
	
	}
	
	@Test
	public void testOverThousand() {
		assertEquals(8, StringCalculator.add("1006,8"));
	}
	
	@Test
	public void testNegativeNumver() {
		try {
			StringCalculator.add("-5,4");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negatives not allowed: -5");
		}
	}	
	
	@Test
	public void otherdelimiter() {
		assertEquals(6, StringCalculator.add("1,2,9999,3"));
	}
}
