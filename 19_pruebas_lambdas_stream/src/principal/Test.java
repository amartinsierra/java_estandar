package principal;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Stream<Integer> datos=Stream.of(7,1,5,2);
		/*datos.filter(d->{
			System.out.println(d);
			return d>3;
		})  //Stream<Integer>
		.count();*/ //Se imprimen todos los elementos del stream, dado que todos se comprueban
		
		datos.anyMatch(d->{
			System.out.println(d);
			return d>3;
		});
		

	}

}
