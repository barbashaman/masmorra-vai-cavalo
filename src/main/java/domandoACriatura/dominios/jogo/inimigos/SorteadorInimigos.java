package domandoACriatura.dominios.jogo.inimigos;

import domandoACriatura.dominios.sistema.Sistema;

import java.util.ArrayList;

public class SorteadorInimigos {

    private static ArrayList<Inimigo> inimigos = new ArrayList<>();

    private static void adicionaInimigos(){
        inimigos.add(new Assassino());
        inimigos.add(new Guerreiro());
        inimigos.add(new Zumbi());
        inimigos.add(new Esqueleto());
    }

    public static Inimigo sorteiaInimigo(){
        adicionaInimigos();
        Inimigo inimigo = inimigos.get(Sistema.proximoInteiroRandomico(inimigos.size()));
        inimigos.clear();
        return inimigo;
    }
}
