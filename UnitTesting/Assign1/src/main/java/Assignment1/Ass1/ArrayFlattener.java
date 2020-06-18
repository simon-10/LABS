package Assignment1.Ass1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattener {

	public  Integer[] flattenArray(Integer[][] arrays) {
		 
		if(arrays.length==0) {
			return null;
		}

         List<Integer> list = new ArrayList<>();
         for (Integer[] array : arrays) {
	      Arrays.stream(array).forEach(list::add);
         }

         Integer[] array=new Integer[list.size()];
         array=list.toArray(array);
                 		 
         return array;
}
}
