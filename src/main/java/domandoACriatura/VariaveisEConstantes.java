package domandoACriatura;

import java.util.Random;
import java.util.Scanner;

public class VariaveisEConstantes {

    /*
     Objetos do sistema
    */
    private static Scanner leitorComandos = new Scanner(System.in);
    private static Random valoresRandomicos = new Random();
    /*
     Variáveis do jogo
    */
    private static String[] inimigos = {"Esqueleto", "Zumbi", "Guerreiro", "Assassino"};
    private static int vidaMaximaInimigos = 75;
    private static int danoAtaqueInimigos = 25;
    private static boolean jogoRodando = true;

    /*
     Variáveis do Jogador
    */
    private static int vidaJogador = 100;
    private static int danoAtaqueJogador = 50;
    private static int numeroPocoesVida = 3;
    private static int fatorCuraPocaoVida = 30;
    private static int chanceCairPocaoVida = 50;

    public static void main(String[] args) {

        System.out.println("Você entrou na masmorra!");

        JOGO:
        while (jogoRodando) {
            System.out.println("------------------------------------------------");
            /*
            Variáveis inimigo
            */
            String inimigoRevelado = inimigos[valoresRandomicos.nextInt(inimigos.length)];
            int vidaInimigoRevelado = valoresRandomicos.nextInt(vidaMaximaInimigos);

            System.out.println("\t# Um " + inimigoRevelado + " apareceu! #\n");
            // Enquanto a vida do inimigo é maior que zero
            while (vidaInimigoRevelado > 0) {
                System.out.println("\tSeus pontos de vida: " + vidaJogador);
                System.out.println("\tPontos de vida do " + inimigoRevelado + ": " + vidaInimigoRevelado);
                System.out.println("\n\tO que você fará?");
                System.out.println("\t1. Atacar");
                System.out.println("\t2. Usar poção de vida");
                System.out.println("\t3. Correr para as colinas!");

                String comandoJogador = leitorComandos.nextLine();

                //Atacar
                if (comandoJogador.equals("1")) {

                    /*
                     mecanismo de ataque
                    */
                    int ataqueJogador = valoresRandomicos.nextInt(danoAtaqueJogador);
                    int retaliacaoInimigo = valoresRandomicos.nextInt(danoAtaqueInimigos);

                    //danos de vida no inimigo
                    vidaInimigoRevelado -= ataqueJogador;
                    //danos de vida no jogador
                    vidaJogador -= retaliacaoInimigo;

                    System.out.println("\t> Você golpeou o " + inimigoRevelado + " e ele sofreu " + ataqueJogador + " de dano.");
                    System.out.println("\t> Você foi ferido e sofreu " + retaliacaoInimigo + " de dano em retaliação!");

                    if (vidaJogador < 1) {
                        System.out.println("\t> Você levou muito dano e  está muito fraco para continuar!");
                        break;
                    }

                }
                //Usar poção de vida
                else if (comandoJogador.equals("2")) {
                    //Se tem poções no inventário
                    if (numeroPocoesVida > 0) {
                        //vida do jogador recebe o fator de cura
                        vidaJogador += fatorCuraPocaoVida;
                        //subtrai a poção utilizada
                        numeroPocoesVida--;
                        //exibição do uso da poção de vida
                        System.out.println("\t> Você bebeu a poção de vida, curando-se em " + fatorCuraPocaoVida + " pontos de vida. "
                                + "\n\t> Agora você tem " + vidaJogador + " pontos de vida."
                                + "\n\t> Você agora tem " + numeroPocoesVida + " poções de vida.\n");
                    } else {
                        System.out.println("\t> Você não tem mais poções de vida! Derrote inimigos para ter uma chance de ganhar mais poções!");
                    }

                }
                // Correr para as colinas!
                else if (comandoJogador.equals("3")) {
                    System.out.println("\t Você fugiu do " + inimigoRevelado + "!");
                    //volta para o inicio do loop do jogo
                    continue JOGO;

                } else {
                    System.out.println("\n------------------------------------------------");
                    System.out.println("\t> Comando Inválido.");
                    System.out.println("------------------------------------------------");
                }
            }
            //se o jogador ainda está vivo
            if (vidaJogador < 1) {
                System.out.println("Você sai mancando da masmorra, fragilizado pela batalha.");
                break;
            }

            //derrota o inimigo
            System.out.println("------------------------------------------------");
            System.out.println(" # " + inimigoRevelado + " foi derrotado! # ");
            System.out.println(" # Você agora tem " + vidaJogador + " pontos de vida. # ");

            //calcula a chance de cair poção de vida do inimigo
            if (valoresRandomicos.nextInt(100) < chanceCairPocaoVida) {
                //soma numero de poções de vida
                numeroPocoesVida++;
                System.out.println(" # O " + inimigoRevelado + " deixou cair uma poção de vida!");
                System.out.println(" # Agora você tem " + numeroPocoesVida + " poções de vida. # ");

            }
            System.out.println("------------------------------------------------");
            System.out.println("E agora? O que você fará?");
            System.out.println("1. Seguir batalhando! Ainda sinto a presença de inimigos!");
            System.out.println("2. Sair da masmorra. Meu trabalho aqui está feito!");

            String comandoJogador = leitorComandos.nextLine();
            while (!comandoJogador.equals("1") && !comandoJogador.equals("2")) {
                System.out.println("\n------------------------------------------------");
                System.out.println("\t> Comando inválido!");
                System.out.println("------------------------------------------------");

                String novoComandoJogador = leitorComandos.nextLine();
            }
            //Seguir batalhando
            if (comandoJogador.equals("1")) {
                System.out.println("Você continua a sua aventura!");
            }
            //Sair da masmorra
            else if (comandoJogador.equals("2")) {
                System.out.println("Você deixa a masmorra, vitorioso em sua aventura!");
                break;
            }
        }

        //Fim de jogo!
        System.out.println("#######################");
        System.out.println("#### FIM DE JOGO!  ####");
        System.out.println("#######################");
    }
}