package domandoACriatura.dominios.jogo.inimigos;

import domandoACriatura.dominios.sistema.Sistema;

public class Inimigo {
    private String nome;
    private int vida;
    private int vidaMaxima;
    private int danoAtaque;
    private int danoAtaqueMaximo;
    private int chanceCairPocaoVida;

    public Inimigo(String nome, int vidaMaxima, int danoAtaqueMaximo, int chanceCairPocaoVida) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.danoAtaqueMaximo = danoAtaqueMaximo;
        this.vida = Sistema.proximoInteiroRandomico(vidaMaxima);
        this.danoAtaque = Sistema.proximoInteiroRandomico(danoAtaqueMaximo);
        this.chanceCairPocaoVida = chanceCairPocaoVida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDanoAtaque() {
        return Sistema.proximoInteiroRandomico(danoAtaqueMaximo);
    }

    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    public int getChanceCairPocaoVida() {
        return chanceCairPocaoVida;
    }


}
