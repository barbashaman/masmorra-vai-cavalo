package vaiCavalo;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class MasmorraVaiCavaloCLIComComentarios {

    public static void main(String[] args) {
        //Objetos do sistema
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        //Variaveis do jogo
        //inimigos
        String[] is = {"Esqueleto", "Zumbi", "Guerreiro", "Assassino"};
        // vida máxima dos inimigos
        int vmi = 75;
        // dano do ataque dos inimigos
        int dai = 25;


        /***
         * Variaveis do Jogador
         */
        // vida do jogador
        int vj = 100;
        // dano do ataque do jogador
        int daj = 50;
        // numero de poções de vida
        int npv = 3;
        // fator de cura da poção de vida
        int fcpv = 30;
        // chance de cair uma poção de vida
        int ccpv = 50;

        // jogo está rodando?
        boolean jr = true;

        System.out.println("Você entrou na masmorra!");
        // Laço do Jogo
        J:
        while (jr) {
            System.out.println("------------------------------------------------");
            // sorteio do inimigo
            String i = is[r.nextInt(is.length)];
            // Vida do inimigo
            int vi = r.nextInt(vmi);

            System.out.println("\t# Um " + i + " apareceu! #\n");
            // Enquanto a vida do inimigo é maior que zero
            while (vi > 0) {
                System.out.println("\tSeus pontos de vida: " + vj);
                System.out.println("\tPontos de vida do " + i + ": " + vi);
                System.out.println("\n\tO que você fará?");
                System.out.println("\t1. Atacar");
                System.out.println("\t2. Usar poção de vida");
                System.out.println("\t3. Correr para as colinas!");

                //resposta do jogador
                String rj = s.nextLine();

                //Atacar
                if (rj.equals("1")) {

                    /**
                     * mecanismo de ataque
                     * */
                    // ataque do jogador
                    int aj = r.nextInt(daj);

                    // retaliação do inimigo
                    int ri = r.nextInt(dai);

                    //danos de vida no inimigo
                    vi -= aj;
                    //danos de vida no jogador
                    vj -= ri;

                    // exibição do resultado do ataque
                    System.out.println("\t> Você golpeou o " + i + " e ele sofreu " + aj + " de dano.");
                    System.out.println("\t> Você foi ferido e sofreu " + ri + " de dano em retaliação!");

                    // se acaba a vida do jogador
                    if (vj < 1) {
                        System.out.println("\t> Você levou muito dano e  está muito fraco para continuar!");
                        break;
                    }

                }
                //Usar poção de vida
                else if (rj.equals("2")) {
                    //Se tem poções no inventário
                    if (npv > 0) {
                        //vida do jogador recebe o fator de cura
                        vj += fcpv;
                        //subtrai a poção utilizada
                        npv--;
                        //exibição do uso da poção de vida
                        System.out.println("\t> Você bebeu a poção de vida, curando-se em " + fcpv + " pontos de vida. "
                                        + "\n\t> Agora você tem " + vj + " pontos de vida."
                                        + "\n\t> Você agora tem " + npv + " poções de vida.\n");
                    } else {
                        System.out.println("\t> Você não tem mais poções de vida! Derrote inimigos para ter uma chance de ganhar mais poções!");
                    }

                }
                // Correr para as colinas!
                else if (rj.equals("3")) {
                    System.out.println("\t Você fugiu do " + i + "!");
                    //volta para o inicio do loop do jogo
                    continue J;

                } else {
                    System.out.println("\n------------------------------------------------");
                    System.out.println("\t> Comando Inválido.");
                    System.out.println("------------------------------------------------");
                }
            }
            //se o jogador ainda está vivo
            if (vj < 1) {
                System.out.println("Você sai mancando da masmorra, fragilizado pela batalha.");
                break;
            }

            //derrota o inimigo
            System.out.println("------------------------------------------------");
            System.out.println(" # " + i + " foi derrotado! # ");
            System.out.println(" # Você agora tem " + vj + " pontos de vida. # ");

            //calcula a chance de cair poção de vida do inimigo
            if (r.nextInt(100) < ccpv) {
                //soma numero de poções de vida
                npv++;
                System.out.println(" # O " + i + " deixou cair uma poção de vida!");
                System.out.println(" # Agora você tem " + npv + " poções de vida. # ");

            }
            System.out.println("------------------------------------------------");
            System.out.println("E agora? O que você fará?");
            System.out.println("1. Seguir batalhando! Ainda sinto a presença de inimigos!");
            System.out.println("2. Sair da masmorra. Meu trabalho aqui está feito!");

            //resposta do jogador
            String rj = s.nextLine();

            while(!rj.equals("1") && !rj.equals("2")){
                System.out.println("\n------------------------------------------------");
                System.out.println("\t> Comando inválido!");
                System.out.println("------------------------------------------------");
                //resposta do jogador depois de comando inválido
                String rjci = s.nextLine();
            }
            //Seguir batalhando
            if(rj.equals("1")){
                System.out.println("Você continua a sua aventura!");
            }
            //Sair da masmorra
            else if(rj.equals("2")){
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