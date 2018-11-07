package sampleProject;

import junit.framework.TestCase;

public class FixturesJUnit extends TestCase{

	protected int v1, v2;
	
	protected void setUp() {
		v1 = 3;
		v2 = 3;
	}
	
	public void testAdd() {
		double result = v1 + v2;
		assertTrue(result==6);
	}
}
