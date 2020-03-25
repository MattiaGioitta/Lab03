package it.polito.tdp.spellchecker.model;

public class RichWord {

	private String inputWord;
	private boolean correct;
	/**
	 * Costruttore 
	 * @param inputWord parola inserita
	 * @param correct se vero indica che la parola è corretta, falso viceversa
	 */
	public RichWord(String inputWord, boolean correct) {
		super();
		this.inputWord = inputWord;
		this.correct = correct;
	}
	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}
	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	/**
	 * @return the inputWord
	 */
	public String getInputWord() {
		return inputWord;
	}
	
	
	
	
}
