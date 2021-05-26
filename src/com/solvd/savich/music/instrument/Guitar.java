package com.solvd.savich.music.instrument;

public class Guitar extends Instrument{

    private int numbersOfString;

    public Guitar (String nameOfInstrument, int numbersOfString){
        super(nameOfInstrument);
        this.numbersOfString = numbersOfString;
    }

    public int getNumbersOfString(){
        return numbersOfString;
    }

    @Override
    public void sound() {

    }

    @Override
    public void reproduce() {

    }
}
