package Assignment1.Ass1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class flattenArrayTest {
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
		 Integer[][] A = {{1,2,3},{0},{4,5,9}};
		 Integer[] expected= {1,2,3,0,4,5,9};
	     Integer[] actual = this.arrayFlattener.flattenArray(A);
	     Assert.assertEquals(expected, actual);	}

 	}

