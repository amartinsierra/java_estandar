package principal;

import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> nums=List.of(5,-2,-7,5,11,45,-23,9,5,6,-8,-14,21,7,10);
		//suma de los positivos -stream clásico-
		/*long t1=System.currentTimeMillis();
		System.out.println(nums.stream()
		.filter(n->n>0)
		.collect(Collectors.summingInt(n->n)));
		long t2=System.currentTimeMillis();
		System.out.println("Ha tardado: "+(t2-t1)+ " milisegundos");*/
		
		//suma de los positvos -stream paralelo-
		long t1=System.currentTimeMillis();
		System.out.println(nums.parallelStream()
		.filter(n->n>0)
		.collect(Collectors.summingInt(n->n)));
		long t2=System.currentTimeMillis();
		System.out.println("Ha tardado: "+(t2-t1)+ " milisegundos");
	}

}
