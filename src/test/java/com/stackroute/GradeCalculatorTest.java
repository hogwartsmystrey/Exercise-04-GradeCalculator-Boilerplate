package com.stackroute;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class GradeCalculatorTest {

	private static final String MSG_01 = "The returned map should have roll no in ascending order";
	private static final String MSG_02 = "Check whether the grades are calculated as per the rules and they are in the sorted order of roll number";
	private static final String MSG_03 = "The returned map should be either a TreeMap or a LinkedHashedMap so that the order is maintained";
	private static final String MSG_04 = "Method should return null if the input map is null or empty";
	HashMap<Integer, Integer> scores = new HashMap<Integer, Integer>();
	Map<Integer, String> result = null;

	public void teardown() {
		scores.clear();
		result = null;
	}

	@Test
	public void test_01_testCalculateGrade() {
		scores.put(1222, 90);
		scores.put(1111, 75);
		result = GradeCalculator.calculateGrade(scores);
		assertThat(result.size(), is(2));
		assertEquals(MSG_01, "[1111, 1222]", result.keySet().toString());
		assertEquals(MSG_02, "[B, A]", result.values().toString());
	}

	@Test
	public void test_02_testCalculateGradeSingleEntry() {
		scores.put(1222, 90);
		result = GradeCalculator.calculateGrade(scores);
		assertThat(MSG_03, result, anyOf(instanceOf(TreeMap.class), instanceOf(LinkedHashMap.class)));
		assertThat(result.size(), is(1));
	}

	@Test
	public void test_02_testCalculateGradeNullInput() {
		scores = null;
		result = GradeCalculator.calculateGrade(scores);
		assertThat(MSG_04, result, is(nullValue()));
	}
}