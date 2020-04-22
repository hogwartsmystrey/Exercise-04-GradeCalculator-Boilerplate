package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GradeCalculator_E2E_Test {

	private static final String MSG_01 = "The output should have roll no in ascending order with correct grades. Entries with invalid marks should be ignored";

	private PrintStream out;
	private ByteArrayOutputStream myOutStream;
	private InputStream in;
	private ByteArrayInputStream myInputStream;

	private String input;
	private String expected;
	private String message;

	public GradeCalculator_E2E_Test(String input, String expected, String message) {
		this.input = input;
		this.expected = expected;
		this.message = message;
	}

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;
		myOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOutStream));
	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Parameters(name = "{index}: Main Method Input ({0}) - Should display ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "2\n1010 80\n100 40", "100 D 1010 A", MSG_01 });
		params.add(new Object[] { "2\n786 95\n105 60", "105 B 786 A", MSG_01 });
		params.add(new Object[] { "3\n1010 80\n231 90\n101 101", "231 A 1010 A", MSG_01 });
		return params;
	}

	@Test
	public void test_01_gradeCalculator_e2e() {
		String sepr = System.lineSeparator();
		myInputStream = new ByteArrayInputStream(input.replace("\n", sepr).getBytes());
		System.setIn(myInputStream);

		GradeCalculator.main(null);
		String actual = myOutStream.toString();
		System.out.println("actual->"+actual);
		System.out.println("expected->"+expected);
		assertThat(message, actual.replaceAll("\\s+", " ").trim(), is(expected));

	}

}
