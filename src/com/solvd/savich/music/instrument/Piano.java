package com.solvd.savich.music.instrument;

public class Piano extends Instrument{

    private boolean isDigital;

    public Piano(String nameOfInstrument, boolean isDigital){
        super(nameOfInstrument);
        this.isDigital = isDigital;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    @Override
    public void sound() {
        System.out.println("Sound of Piano " + getNameOfInstrument());
    }

    @Override
    public void reproduce() {
        System.out.println("Playing the piano");

    }
}
