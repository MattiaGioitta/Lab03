package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		List<RichWord> lista = new LinkedList<RichWord>();
		dictionary.loadDictionary("English");
		
		List<String> l = new LinkedList<String>();
		l.add("ciao");
		l.add("come");
		l.add("va");
		
		List<String> ll = new LinkedList<String>();
		ll.add("how");
		ll.add("careee");
		
		
		lista = dictionary.spellCheckTextDichotomic(ll);
    	
		
        System.out.println(dictionary.result(lista));

	}

}
