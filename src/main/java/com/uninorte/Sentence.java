package com.uninorte;

import java.util.ArrayList;

public class Sentence {
   
    private ArrayList<Word> words = new ArrayList<>();
    private Word root;
    private Sentence next;

    // check that the sentence has at least one subject and one verb
    // check that all words are valid
    public boolean isValid(){
        int contadorVerbos = 0;
        int contadorSubjects = 0;
        for (Word word : words) {
            if(word.isValid() == false){
                return false;
            }
            if(word.getType() == WordType.VERB){
                contadorVerbos++;
            }
            if(word.getType() == WordType.SUBJECT){
                contadorSubjects++;
            }
        }
        if((contadorSubjects > 0) && (contadorVerbos > 0)){
            return true;
        }
        return false;
    }
    
    public int getWordCount(){
        return words.size();
    }

    public int getLetterCount(){
        int contador = 0;
        for (Word word : words) {
            contador = contador + word.getCharCount();
        }
        return contador;
    }

    public ArrayList<Word> getWords() {
        return words;
    }
   

    // DO NOT DELETE THIS
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Word currentWord = root;
        while (currentWord != null) {
            if (sb.length() > 0){
                sb.append(" ");
            }
            sb.append(currentWord.toString());
            currentWord = currentWord.getNext();
        }
        return sb.toString();
    }



    public void add(Word word) {
        if (root == null) {
            root = word; 
        } else {
            Word aux = root;
            while (aux.getNext() != null) {
                aux = aux.getNext(); 
            }
            aux.setNext(word); 
        }
        words.add(word); 
    }

    public Sentence getNext() {
        return next;
    }

    public void setNext(Sentence next) {
        this.next = next;
    }



}
