package service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.Item;

public class BuscadorService {
	public Set<Item> buscador(List<Item> items, String tematica) {
		return items.stream() //Stream<Item>
		.filter(it->Arrays.stream(it.getTematica()).anyMatch(s->s.equals(tematica)))  //Stream<Item>
		.collect(Collectors.toSet());
	}
	
	//cuantos Item incluyen la temática de búsqueda
	
	public long contarItems(List<Item> items, String tematica) {
		return items.stream()
				.flatMap(it->Arrays.stream(it.getTematica())) //Stream<String>
				.filter(c->c.equals(tematica))
				.count();
	}
}
