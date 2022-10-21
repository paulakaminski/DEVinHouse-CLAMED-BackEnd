package aula03heranca.entities;

import aula03heranca.enums.Cor;

public abstract class Forma {
    private Cor cor;

    public Forma (Cor cor){
        this.cor = cor;
    }

    public Cor getCor(){
        return cor;
    }

    public void setCor(Cor cor){
        this.cor = cor;
    }

    public abstract double area();
}
