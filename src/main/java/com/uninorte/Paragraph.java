package com.uninorte;

import java.util.ArrayList;

public class Paragraph {
    
    private ArrayList<Sentence> sentences = new ArrayList<>();
    private Sentence root;
    private Paragraph next;
    // check that the paragraph has all valid sentences
    // and that has between 3 and 5 sentences
    public boolean isValid() {
        for (Sentence sentence : sentences) {
            if(sentence.isValid() == false){
                System.out.println("GGS");
                return false;
            }
        }
        System.out.println("HOLAAAAA");
        if(sentences.size() < 3 || sentences.size() > 5){
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Sentence currentSentence = root;
        while (currentSentence != null) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(currentSentence.toString());
            currentSentence = currentSentence.getNext();
        }
        sb.append(".");
        return sb.toString();
    }

    public void add(Sentence sentence){
        if (root == null) {
            root = sentence; 
        } else {
            Sentence aux = root;
            while (aux.getNext() != null) {
                aux = aux.getNext(); 
            }
            aux.setNext(sentence); 
        }
        sentences.add(sentence); 
    }

    public int getLetterCount(){
        int contador = 0;
        for (Sentence sentence : sentences) {
            for (Word word : sentence.getWords()) {
                contador = contador + word.getCharCount();
            }
        }
        return contador;
    }

    public int getWordCount(){
        int contador = 0;
        for (Sentence sentence : sentences) {
            contador = contador + sentence.getWordCount();
        }
        return contador;
    }

    public int getSentenceCount(){
        return sentences.size();
    }

    public Paragraph getNext() {
        return next;
    }

    public void setNext(Paragraph next) {
        this.next = next;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    
}
