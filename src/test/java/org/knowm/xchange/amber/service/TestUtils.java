package org.knowm.xchange.amber.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtils {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		char DELIM = '_';
		String key = "usdt_usd";
		String lhs = key.substring(0,key.indexOf( DELIM ));
		String rhs = key.substring(key.indexOf( DELIM )+1);
		assertEquals("usdt",lhs);
		assertEquals("usd",rhs);
	}

}
