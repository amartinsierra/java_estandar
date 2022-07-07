package principal;

import java.util.Arrays;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<Integer[]> nums=List.of(new Integer[]{4,1,9,10},
								 new Integer[] {8,2},
								 new Integer[] {3,11,23,9,1});
		
		//muestra la suma de todos los elementos de la lista
		System.out.println(nums.stream() //Stream<Integer[]>
		.map(a->Arrays.stream(a).mapToInt(n->n).sum())  //Stream<Integer>  con la suma de cada array
		.mapToInt(n->n) //IntStream
		.sum());

		//con flatMap
		
		System.out.println(nums.stream()  //Stream<Integer[]>
		.flatMap(a->Arrays.stream(a)) //Stream<Integer> con todo el contenido
		.mapToInt(n->n)
		.sum());
		
	}

}
