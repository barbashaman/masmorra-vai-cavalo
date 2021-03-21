package domandoACriatura.dominios.jogo.jogador.inventario;

public class PocaoVida{

    private int fatorCuraPocaoVida;
    private int chanceCairPocaoVida;

    public PocaoVida() {
        fatorCuraPocaoVida = 30;
        chanceCairPocaoVida = 50;
    }

    public int getFatorCuraPocaoVida() {
        return fatorCuraPocaoVida;
    }

    public void setFatorCuraPocaoVida(int fatorCuraPocaoVida) {
        this.fatorCuraPocaoVida = fatorCuraPocaoVida;
    }

    public int getChanceCairPocaoVida() {
        return chanceCairPocaoVida;
    }

    public void setChanceCairPocaoVida(int chanceCairPocaoVida) {
        this.chanceCairPocaoVida = chanceCairPocaoVida;
    }
}
