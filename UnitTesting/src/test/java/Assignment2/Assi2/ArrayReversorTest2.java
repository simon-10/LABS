package Assignment2.Assi2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayReversorTest2 {
	private ArrayReversor arrayReversor;
	private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);

	@Before
	public void setUp() throws Exception {
		this.arrayReversor = new ArrayReversor(arrayFlattenerService);
	}

	@After
	public void tearDown() throws Exception {
		this.arrayReversor = null;
	}

	@Test
	public void testReverseArrayForNull() {
		Integer[][] input = null;
		
		when(arrayFlattenerService.flattenArray(input)).thenReturn(null);
		Integer[] expected = null;
		Integer[] actual = arrayReversor.reverseArray(null);
		
		assertEquals(expected, actual);
		assertThat(actual, is(expected));
		verify(arrayFlattenerService).flattenArray(input);

	}

}
