package principal;

import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<Integer> nums=List.of(6,11,3,4,8,7,9,25);
		//mostrar los pares
		nums.parallelStream()
		.filter(n->n%2==0)
		.forEach(n->System.out.println(n));

	}

}
