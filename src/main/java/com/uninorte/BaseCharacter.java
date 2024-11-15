package com.uninorte;

public class BaseCharacter {
    
    private char letter;
    private BaseCharacter next;

    public BaseCharacter(char character){
        this.letter = character;
        this.next = null;
    }
    // un char puede ser una letra o un número
    // para verificar si es un número se puede usar la función
    // Character.isDigit

    public void setNext(BaseCharacter next){
        this.next = next;
    }

    // DO NOT DELETE THIS
    @Override
    public String toString() {
        return String.valueOf(letter);
    }

    public boolean isNumber(){
        if(Character.isDigit(getCharacter())){
            return true;
        }
        return false;
    }

    public char getCharacter() {
        return letter;
    }

    public BaseCharacter getNext(){
        return next;
    }

    
}
