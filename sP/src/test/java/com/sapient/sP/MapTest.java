package com.sapient.sP;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import org.hamcrest.collection.IsMapContaining;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {

	@Test
	public void testAssertMap() {
		
		Map<String, String> map = new HashMap<>();
		map.put("j", "java");
		map.put("c", "c++");
		map.put("p", "python");
		map.put("n", "node");
		
		
		Map<String, String> expected = new HashMap<>();
		expected.put("n", "node");
		expected.put("c", "c++");
		expected.put("j", "java");
		expected.put("p", "python");
		
		assertThat("Test 1",map, is(expected));
		
		assertThat("Test 2", map.size(), is(4));
		
		assertThat("Test 3", map, IsMapContaining.hasEntry("n", "node"));
		
		assertThat("Test 4", map, not(IsMapContaining.hasEntry("r", "ruby")));
		
		assertThat("Test 5", map, IsMapContaining.hasKey("j"));
		
		assertThat("Test 6", map, IsMapContaining.hasValue("node"));
		
	}

}
