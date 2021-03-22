package domandoACriatura.dominios.jogo;

import domandoACriatura.dominios.jogo.inimigos.Inimigo;
import domandoACriatura.dominios.jogo.inimigos.SorteadorInimigos;
import domandoACriatura.dominios.jogo.jogador.Jogador;
import domandoACriatura.dominios.sistema.Sistema;

import static domandoACriatura.dominios.sistema.Sistema.imprimir;

public class Jogo {
    private Jogador jogador;
    private Inimigo inimigo;
    private boolean jogoRodando;
    private boolean correr;
    private boolean jogadorFaleceu;
    private String comandoJogador;

    public Jogo() {
        jogoRodando = true;
        correr = false;
        jogadorFaleceu = false;
        comandoJogador = "";
    }

    private void sorteiaAtaqueJogador() {
        jogador.setDanoAtaque();
    }

    private void sorteiaAtaqueInimigo() {
        inimigo.getDanoAtaque();
    }

    private Inimigo sorteiaInimigo() {
        return SorteadorInimigos.sorteiaInimigo();
    }

    private void sorteiaDadosAtaque() {
        sorteiaAtaqueJogador();
        sorteiaAtaqueInimigo();
    }

    private void calculaResultadoAtaque() {
        inimigo.recebeDano(jogador.getDanoAtaque());
        jogador.recebeDano(inimigo.getDanoAtaque());
    }

    private void selecionarOpcaoAtacarInimigo() {
        sorteiaDadosAtaque();
        calculaResultadoAtaque();
        validaResultadoConfronto();
    }

    private boolean isJogadorDerrotado() {
        return jogador.getVida() < 1;
    }

    private boolean isInimigoDerrotado() {
        return inimigo.getVida() < 1;
    }

    private boolean inimigoVencidoDeixaPocaoVidaCair() {
        return Sistema.proximoInteiroRandomico(100) < inimigo.getChanceCairPocaoVida();
    }

    private void calculaChancePocaoVida() {
        if (inimigoVencidoDeixaPocaoVidaCair()) {
            //soma numero de poções de vida
            jogador.adicionaPocaoVida();
            imprimir(" # O " + inimigo.getNome() + " deixou cair uma poção de vida!",
                    " # Agora você tem " + jogador.getNumeroPocoesVida() + " poções de vida. # ");
            imprimirSeparador();
        }
    }

    private void validaInimigoDerrotado() {
        if (isInimigoDerrotado()) {
            imprimirSeparador();
            imprimir(" # " + inimigo.getNome() + " foi derrotado! # ",
                    " # Você agora tem " + jogador.getVida() + " pontos de vida. # ");
            imprimirSeparador();
            calculaChancePocaoVida();
        }
    }

    private void setJogadorMorto(){
        this.jogadorFaleceu = true;
    }

    private void setFimDeJogo(){
        this.jogoRodando = false;
    }

    private void finalizaJogoJogadorMorto(){
        setJogadorMorto();
        setFimDeJogo();
    }

    private void validaJogadorDerrotado() {
        if (isJogadorDerrotado()) {
            imprimir("\t> Você levou muito dano e está muito fraco para continuar!");
            finalizaJogoJogadorMorto();
        }
    }

    private void validaResultadoConfronto() {
        imprimir("\t> Você golpeou o " + inimigo.getNome() + " e ele sofreu " + jogador.getDanoAtaque() + " de dano.",
                "\t> Você foi ferido e sofreu " + inimigo.getDanoAtaque() + " de dano em retaliação!");
        validaInimigoDerrotado();
        validaJogadorDerrotado();
    }

    private boolean jogadorPossuiPocoes() {
        return jogador.getNumeroPocoesVida() > 0;
    }

    private void resultadoUsoPocao(int fatorCura) {
        imprimir("\t> Você bebeu a poção de vida, curando-se em " + fatorCura + " pontos de vida. ",
                "\n\t> Agora você tem " + jogador.getVida() + " pontos de vida.",
                "\n\t> Você agora tem " + jogador.getNumeroPocoesVida() + " poções de vida.\n");
    }

    private void usarPocao() {
        int fatorCura = jogador.usarPocao();
        resultadoUsoPocao(fatorCura);
    }

    private void selecionarOpcaoUsarPocaoVida() {
        if (jogadorPossuiPocoes()) {
            usarPocao();
        } else {
            imprimir("\t> Você não tem mais poções de vida! Derrote inimigos para ter uma chance de ganhar mais poções!");
        }
    }

    private boolean aventuraContinua() {
        return !isInimigoDerrotado() && !correr && !jogadorFaleceu;
    }

    private void correrColinas(){
        this.correr = true;
    }

    private void selecionarOpcaoCorrerColinas() {
        imprimir("\t Você fugiu do " + inimigo.getNome() + "!");
        correrColinas();
    }

    private void imprimirSeparador() {
        imprimir("\n------------------------------------------------");
    }

    private void digitarComandoInvalido() {
        imprimirSeparador();
        imprimir("\t> Comando Inválido.");
        imprimirSeparador();
    }

    private void escaparVivo() {
        if (!isJogadorDerrotado()) {
            imprimir("Você escapou vivo da masmorra! Sua vida nunca mais será a mesma!");
            imprimirSeparador();
        }
    }

    private void deixarMasmorra() {
        if (isInimigoDerrotado()) {
            imprimir("Você deixa a masmorra, vitorioso em sua aventura!");
            imprimirSeparador();
        } else {
            escaparVivo();
        }
        jogoRodando = false;
    }

    private void imprimirDadosVidaJogadorInimigo() {
        imprimir("\tSeus pontos de vida: " + jogador.getVida(),
                "\tPontos de vida do " + inimigo.getNome() + ": " + inimigo.getVida());
        imprimirSeparador();
    }

    private void imprimirOpcoesReacaoInimigo() {
        imprimir("\n\tO que você fará?",
                "\t1. Atacar",
                "\t2. Usar poção de vida",
                "\t3. Correr para as colinas!");
        imprimirSeparador();
    }

    private void processarReacaoInimigo() {
        comandoJogador = Sistema.lerComandoTeclado();
        if (comandoJogador.equals("1")) {
            selecionarOpcaoAtacarInimigo();
        } else if (comandoJogador.equals("2")) {
            selecionarOpcaoUsarPocaoVida();
        } else if (comandoJogador.equals("3")) {
            selecionarOpcaoCorrerColinas();
        } else {
            digitarComandoInvalido();
        }
    }

    private void reagirInimigo() {
        imprimirDadosVidaJogadorInimigo();
        imprimirOpcoesReacaoInimigo();
        processarReacaoInimigo();
    }

    private void encontrarInimigo() {
        inimigo = sorteiaInimigo();
        imprimir("\t# Um " + inimigo.getNome() + " apareceu! #\n");
        while (aventuraContinua()) {
            reagirInimigo();
        }
    }

    private void jogadorNaoSaiAventura(){
        this.correr = false;
    }

    private void continuarBatalhando() {
        imprimir("Você continua a sua aventura!");
        imprimirSeparador();
        jogadorNaoSaiAventura();
    }

    private void imprimirOpcoesContinuarJogo() {
        imprimir("E agora? O que você fará?",
                "1. Seguir batalhando! Ainda sinto a presença de inimigos!",
                "2. Sair da masmorra. Meu trabalho aqui está feito!");
        imprimirSeparador();
    }

    private void processarOpcaoContinuarJogo() {
        comandoJogador = Sistema.lerComandoTeclado();
        while (!comandoJogador.equals("1") && !comandoJogador.equals("2")) {
            digitarComandoInvalido();
            imprimirOpcoesContinuarJogo();
            comandoJogador = Sistema.lerComandoTeclado();
        }
        if (comandoJogador.equals("1")) {
            continuarBatalhando();
        } else if (comandoJogador.equals("2")) {
            deixarMasmorra();
        }
    }

    private void iniciarJogo() {
        imprimir("Você entrou na masmorra!");
        jogador = new Jogador(100, 50);
    }

    private void continuarJogo() {
        if (!jogadorFaleceu) {
            imprimirOpcoesContinuarJogo();
            processarOpcaoContinuarJogo();
        }
    }

    private void terminarOJogo() {
        imprimir("#######################",
                "#### FIM DE JOGO!  ####",
                "#######################");
    }

    private boolean isJogoRodando(){
        return this.jogoRodando;
    }

    public void executaJogo() {
        iniciarJogo();
        while (isJogoRodando()) {
            encontrarInimigo();
            continuarJogo();
        }
        terminarOJogo();
    }
}