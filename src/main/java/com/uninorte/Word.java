package com.uninorte;

public class Word {
   
    private WordType wordType;
    private char[] charList;
    private BaseCharacter root;
    private Word next;

    public Word(WordType wordType, char[] charList) {
        this.wordType = wordType;
        this.charList = charList;
        if (charList.length > 0) {
            this.root = new BaseCharacter(charList[0]);
            BaseCharacter aux = root;
    
            for (int i = 1; i < charList.length; i++) {
                BaseCharacter next = new BaseCharacter(charList[i]);
                aux.setNext(next);
                aux = next; 
            }
        }
        this.next = null;
    }

    public Word(WordType wordType) {
        this.wordType = wordType;
        this.next = null;
        this.root = null;
    }

    public char[] getCharList() {
        return charList;
    }

    public int getCharCount(){
        return charList.length;
    }

    // check that the word has at least one letter
    // check that the word is not a mix of letters and numbers
    public boolean isValid() {
        if (root == null) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasNumber = false;
        
        BaseCharacter currentCharacter = root;
        while (currentCharacter != null) {
            if (currentCharacter.isNumber()) {
                hasNumber = true;
            } else {
                hasLetter = true;
            }
            currentCharacter = currentCharacter.getNext();
        }


        return !(hasLetter && hasNumber);
    }

 

    // DO NOT DELETE THIS
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        BaseCharacter currentCharacter = root;
        while (currentCharacter != null) {
            sb.append(currentCharacter.getCharacter());
            currentCharacter = currentCharacter.getNext();
        }
        return sb.toString();
    }

    public WordType getType() {
        return wordType;
    }

    public int getLetterCount(){
        return charList.length;
    }


    public Word getNext(){
        return next;
    }

    public void setNext(Word next){
        this.next = next;
    }

    public void add(char c) {
        if (charList == null) {
            charList = new char[0];
        }
        
        char[] newCharList = new char[charList.length + 1];

        for (int i = 0; i < charList.length; i++) {
            newCharList[i] = charList[i];
        }

        newCharList[charList.length] = c;
        charList = newCharList;

        BaseCharacter baseCharacter = new BaseCharacter(c);
        if (root == null) {
            root = baseCharacter; 
        } else {
            BaseCharacter aux = root;
            while (aux.getNext() != null) {
                aux = aux.getNext(); 
            }
            aux.setNext(baseCharacter); 
        }
    }

}
