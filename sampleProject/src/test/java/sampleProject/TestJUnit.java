package sampleProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit {

	@Test
	public void testAdd() {
		String str = "JUnit okay";
		assertEquals("JUnit okay", str);
	}
}
