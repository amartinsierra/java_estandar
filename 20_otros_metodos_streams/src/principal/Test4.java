package principal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {

	public static void main(String[] args) {
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		//imprime los numeros pares en una única línea y separados por una ","
		/*nums
		.filter(n->n%2==0)
		.forEach(n->System.out.print(n+","));*/
		
		
		System.out.println(nums
		.filter(n->n%2==0) //Stream<Integer>
		.map(n->String.valueOf(n)) //Stream<String>
		.collect(Collectors.joining(","))); //genera una cadena con el contenido del stream, separando los elementos por ","

	}

}
