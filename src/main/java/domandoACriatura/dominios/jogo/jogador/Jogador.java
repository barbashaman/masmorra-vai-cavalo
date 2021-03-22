package domandoACriatura.dominios.jogo.jogador;

import domandoACriatura.dominios.jogo.jogador.inventario.Inventario;
import domandoACriatura.dominios.sistema.Sistema;

public class Jogador {
    private int vida;

    private int danoAtaque;
    private int danoAtaqueMaximo;
    private Inventario inventario;

    public Jogador(int vida, int danoAtaque) {
        this.vida = vida;
        this.danoAtaque = danoAtaque;
        this.danoAtaqueMaximo = danoAtaque;
        inventario = new Inventario();
        inventario.setPocoesVida(3);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void recebeDano(int dano){
        this.setVida(this.getVida() - dano);
    }

    public int getDanoAtaque() {
        return danoAtaque;
    }

    public void setDanoAtaque() {
        this.danoAtaque = Sistema.proximoInteiroRandomico(danoAtaqueMaximo);
    }

    public int getNumeroPocoesVida() {
        return inventario.getQuantidadePocoes();
    }

    public void adicionaPocaoVida(){
        this.inventario.adicionaPocaoVida();
    }

    public int usarPocao() {
        int fatorCura = inventario.getPocaoVida().getFatorCuraPocaoVida();
        this.setVida(this.getVida() + fatorCura);
        return fatorCura;
    }
}
