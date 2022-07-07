package presentacion;

import java.util.List;
import java.util.Set;

import model.Item;
import service.BuscadorService;

public class PruebaBuscador {

	public static void main(String[] args) {
		//inventamos una lista de Items
		/*Vector<Item> items=new Vector<Item>();
		items.add(new Item("www.google.com","varios","es un buscador"));
		items.add(new Item("www.fnac.com","libros","libros y más"));
		items.add(new Item("www.mybook.com","libros","todos los libros"));
		items.add(new Item("www.fm.com","musica","24 horas de múscia"));*/
		List<Item> items=List.of(new Item("www.google.com",new String[]{"electrónica","viajes"},"es un buscador"),
				new Item("www.fnac.com",new String[]{"libros","discos"},"libros y más"),
				new Item("www.mybook.com",new String[]{"libros"},"todos los libros"),
				new Item("www.fm.com",new String[]{"musica","conciertos","charlas","viajes"},"24 horas de múscia"));
		//creamos un objeto de la clase BuscadorService
		BuscadorService service=new BuscadorService();
		//recogemos el resultado en una variable de tipo Set
		Set<Item> resultado=service.buscador(items, "libros");
		//recorremos el conjunto de resultados y lo mostramos
		for(Item item:resultado) {
			System.out.println(item.getDireccion());
		}
	}

}
