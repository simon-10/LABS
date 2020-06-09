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
import org.mockito.Mock;

public class ArrayReversorTest1 {
	// @Mock
	private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
	private ArrayReversor arrayReversor;

	@Before
	public void setUp() throws Exception {
		this.arrayReversor = new ArrayReversor(arrayFlattenerService);

	}

	@After
	public void tearDown() throws Exception {
		this.arrayReversor = null;
	}

	@Test
	public void testReverseArray() {
		Integer[][] input = { { 1, 3 }, { 0 }, { 4, 5, 9 } };
		
		when(arrayFlattenerService.flattenArray(input)).thenReturn(new Integer[] { 1, 3, 0, 4, 5, 9 });
		Integer[] expected = new Integer[] { 9, 5, 4, 0, 3, 1 };
		Integer[] actual = arrayReversor.reverseArray(input);
		
		assertEquals(expected, actual);
		assertThat(actual, is(expected));
		verify(arrayFlattenerService).flattenArray(input);
	}

}
