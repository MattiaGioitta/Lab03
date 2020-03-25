package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javafx.scene.control.TextArea;

public class Dictionary {
	
	List<String> dictionary;
	
	
	
	
	/**
	 * @param dictionary
	 */
	public Dictionary() {
		super();
		this.dictionary = new LinkedList<String>();
	}
	
    /**
     * Riempie il dizionario in base alla lingua scelta da input
     * @param language lingua scelta dall'utente
     */
	public void loadDictionary(String language) {
		try {
			String fileName="";
			if(language.compareTo("English")==0) {
				fileName="src\\main\\resources\\English.txt";
			}
			else if ( language.compareTo("Italian")==0) {
				fileName="src\\main\\resources\\Italian.txt";
			}
			FileReader fr= new FileReader(fileName);
			BufferedReader br= new BufferedReader(fr);
			String word;
			while((word=br.readLine()) != null) {
				this.dictionary.add(word);				
			}
			br.close();
		} catch(IOException e) {
			System.out.println("Errore nella lettura del file");
		}		
	}
	/**
	 * Ritorna una lista di RichWord non contenute nel dizionario
	 * @param inputTextList
	 * @return 
	 */
	public List<RichWord> spellCheckTextLinear(List<String> inputTextList){
		List<RichWord> wrongWords = new LinkedList<RichWord>();
		for(String s : inputTextList) {
			if(!this.dictionary.contains(s)) {
				wrongWords.add(new RichWord(s,false));
			}
			else {
				wrongWords.add(new RichWord(s,true));
			}
		}
		return wrongWords;
	}
	/**
	 * Pulisce il vocabolario ogni qualvolta l'utente decide di cancellare il testo
	 * e riprovare
	 */
	public void clear() {
		this.dictionary.clear();
	}
    /**
     * Ritorna una lista di parole senza caratteri
     * del testo in input passato dall'utente
     * @param txtInput
     * @return
     */
	public List<String> inputTextToControl(TextArea txtInput) {
		String giusto = txtInput.getText().replaceAll("\\p{P}", "").toLowerCase();
		List<String> lista = new LinkedList<String>();
		StringTokenizer st = new StringTokenizer(giusto," ");
		while(st.hasMoreTokens()) {
			lista.add(st.nextToken());
		}
		return lista;
	}
	/**
	 * Restituisce il testo da impostare come risultato
	 * @param l
	 * @return
	 */
	public String result(List<RichWord> l) {
		String s = "";
		for(RichWord ss : l) {
			if(ss.isCorrect()==false) {
			s+=ss.getInputWord()+"\n";
			}
		}
		return s;
		
	}
	
	public List<RichWord> spellCheckTextDichotomic(List<String> inputTextList){
		List<RichWord> wrongWords = new LinkedList<RichWord>();
		int x = 0;
		for(String s : inputTextList) {
			x = Collections.binarySearch(this.dictionary, s);
			if(x >=0) {
				wrongWords.add(new RichWord(s,true));
			}
			else {
				wrongWords.add(new RichWord(s,false));
			}
		}
		
		return wrongWords;
	}
	
	public int size(List<RichWord> l) {
		int x = 0;
		for(RichWord s : l) {
			if(s.isCorrect()==false) {
				x++;
			}
		}
		return x;
	}
	

}
