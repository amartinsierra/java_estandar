package principal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {

	public static void main(String[] args) {
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		//suma de los elementos del stream
		nums
		.reduce((a,b)->a+b)
		.ifPresent(r->System.out.println(r));

	}

}
