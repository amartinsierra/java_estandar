package principal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {

	public static void main(String[] args) {
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		//media de los números
	    System.out.println(nums
		.mapToInt(n->n)
		.average()
		.getAsDouble());
	    //es lo mismo que lo anterior
	    System.out.println(nums
	    .collect(Collectors.averagingInt(n->n)));
	}

}
