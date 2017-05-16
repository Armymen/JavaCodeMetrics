package pl.pecet.javacodemetrics.core.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MetricsCalculatorTest {

	private MetricsCalculator tested;

	@Before
	public void setUp() {
		tested = new MetricsCalculator(null);
	}

	@Test
	public void shouldFindMethodNames() {
		final List<String> methodNames = tested.findMethodNames();

		assertEquals(2, methodNames.size());
		assertTrue(methodNames.contains("main"));
		assertTrue(methodNames.contains("someMethod"));
		assertFalse(methodNames.contains("abc"));
	}

}
