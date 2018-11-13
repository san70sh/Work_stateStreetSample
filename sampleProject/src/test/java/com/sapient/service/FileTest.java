package com.sapient.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileTest {
	
	private BufferedReader in = null;

    @Before
    public void setup()
        throws IOException
    {
        in = new BufferedReader(
            new InputStreamReader(getClass().getResourceAsStream("../sampleProject/src/test/resources/pricing.txt")));
    }

    @After
    public void teardown()
        throws IOException
    {
        if (in != null)
        {
            in.close();
        }

        in = null;
    }

    @Test
    public void testFoo()
        throws IOException
    {
        String line = in.readLine();

        assertThat(line, notNullValue());
    }

}
