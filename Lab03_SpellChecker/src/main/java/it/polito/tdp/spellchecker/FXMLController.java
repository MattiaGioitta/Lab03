/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	ObservableList list = FXCollections.observableArrayList();
	Dictionary dictionary = new Dictionary();
	List<RichWord> lista = new LinkedList<RichWord>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> language;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label lbNumWrongWords;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lbExecutionTime;

    @FXML
    void doClearText(ActionEvent event) {
    	txtInput.clear();
    	this.txtResult.clear();
    	this.lbExecutionTime.setText("");
    	this.lbNumWrongWords.setText("");
    	this.dictionary.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	double start =System.nanoTime();
    	String selection = language.getValue();
    	this.dictionary.loadDictionary(selection);
    	this.dictionary.inputTextToControl(this.txtInput);
    	this.lista = this.dictionary.spellCheckTextLinear(this.dictionary.inputTextToControl(txtInput));
    	//this.lista = this.dictionary.spellCheckTextDichotomic(this.dictionary.inputTextToControl(txtInput));
    	this.lbNumWrongWords.setText(""+this.dictionary.size(lista));
        this.txtResult.setText(this.dictionary.result(this.lista));
        double stop=System.nanoTime();
        this.lbExecutionTime.setText(""+(stop-start));
    	
    	

    }
    
    

    @FXML
    void initialize() {
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lbNumWrongWords != null : "fx:id=\"lbNumWrongWords\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lbExecutionTime != null : "fx:id=\"lbExecutionTime\" was not injected: check your FXML file 'Scene.fxml'.";

        list.addAll("English", "Italian");
        language.setItems(list);
        language.setValue("English");
        
        
    }
}
