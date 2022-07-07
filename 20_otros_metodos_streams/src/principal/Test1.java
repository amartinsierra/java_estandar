package principal;

import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		//imprime los pares y su suma

		/*System.out.println(nums.filter(n->n%2==0) //Stream<Integer>
		.mapToInt(n->n) //IntStream
		.sum());
		
		nums.filter(n->n%2==0) //Stream<Integer>
			.forEach(n->System.out.println(n));*/
		
		System.out.println(nums.filter(n->n%2==0)
		.peek(n->System.out.println(n))
		.mapToInt(n->n) //IntStream
		.sum());
		
		
		
		
		
		
	}

}
