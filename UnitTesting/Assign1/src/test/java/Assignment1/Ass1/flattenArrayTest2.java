package Assignment1.Ass1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class flattenArrayTest2 {
	private ArrayFlattener arrayFlattener;

	@Before
	public void setUp() throws Exception {
		this.arrayFlattener= new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayFlattener= null;

	}

	@Test
	public void testFlattenArray() {
		 Integer[][] A = {{},{},{}};
		 Integer[] expected= {};
	     Integer[] actual = this.arrayFlattener.flattenArray(A);
	     Assert.assertEquals(expected, actual);	}

 	}

