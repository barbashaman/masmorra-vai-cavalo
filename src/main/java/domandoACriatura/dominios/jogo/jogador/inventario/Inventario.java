package domandoACriatura.dominios.jogo.jogador.inventario;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    List<PocaoVida> pocoesVida = new ArrayList<>();

    public void setPocoesVida(int quantidade){
        while(quantidade>0){
            pocoesVida.add(new PocaoVida());
            quantidade--;
        }
    }

    public void adicionaPocaoVida(){
        this.pocoesVida.add(new PocaoVida());
    }

    public PocaoVida getPocaoVida(){
        PocaoVida pocaoVida = pocoesVida.get(0);
        pocoesVida.remove(pocaoVida);
        return pocaoVida;
    }

    public int getQuantidadePocoes(){
        return this.pocoesVida.size();
    }
}
