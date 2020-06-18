package Assignment2.Assi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.Arrays;

public class ArrayReversor {

	private ArrayFlattenerService arrayFlattenerService;

	public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
		this.arrayFlattenerService = arrayFlattenerService;
	}

	public Integer[] reverseArray(Integer[][] ints) {

		Integer[] flat = arrayFlattenerService.flattenArray(ints);
		if (flat == null)
			return null;

		List<Integer> flattened = Arrays.asList(flat);
		Collections.reverse(flattened);
		Integer[] array = new Integer[flattened.size()];

		return flattened.toArray(array);

	}
}
