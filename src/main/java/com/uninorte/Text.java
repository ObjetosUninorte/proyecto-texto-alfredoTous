package com.uninorte;

import java.util.ArrayList;

public class Text {
   
    private ArrayList<Paragraph> paragraphs = new ArrayList<>();
    private Paragraph root;

    // check that the text has all valid paragraphs
    public boolean isValid() {
        for (Paragraph paragraph : paragraphs) {
            if(paragraph.isValid() == false){
                return false;
            }
        }
        return true;
    }

    public void add(Paragraph paragraph){
        if (root == null) {
            root = paragraph; 
        } else {
            Paragraph aux = root;
            while (aux.getNext() != null) {
                aux = aux.getNext(); 
            }
            aux.setNext(paragraph); 
        }
        paragraphs.add(paragraph); 
    }

    // DO NOT DELETE THIS
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Paragraph currentParagraph = root;
        while (currentParagraph != null) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(currentParagraph.toString());
            currentParagraph = currentParagraph.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int getParagraphCount(){
        return paragraphs.size();
    }

    public int getSentenceCount(){
        int contador = 0;
        for (Paragraph paragraph : paragraphs) {
            contador = contador + paragraph.getSentenceCount();
        }
        return contador;
    }

    public int getWordCount(){
        int contador = 0;
        for (Paragraph paragraph : paragraphs) {
            for (Sentence sentence : paragraph.getSentences()) {
                contador = contador + sentence.getWordCount();
            }
        }
        return contador;
    }

}