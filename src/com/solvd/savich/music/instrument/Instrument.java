package com.solvd.savich.music.instrument;

public abstract class Instrument {

    private String nameOfInstrument;


    public Instrument(String nameOfInstrument){
        this.nameOfInstrument = nameOfInstrument;

    }
    public abstract void sound();

    public String getNameOfInstrument() {
        return nameOfInstrument;
    }
    public void setNameOfInstrument(String nameOfInstrument){
        this.nameOfInstrument = nameOfInstrument;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "nameOfInstrument='" + nameOfInstrument + '\'' +
                '}';
    }
}

