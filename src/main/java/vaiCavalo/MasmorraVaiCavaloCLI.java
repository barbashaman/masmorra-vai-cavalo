package vaiCavalo;

import java.util.Random;
import java.util.Scanner;

public class MasmorraVaiCavaloCLI {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        String[] is = {"Esqueleto", "Zumbi", "Guerreiro", "Assassino"};
        int vmi = 75;
        int dai = 25;
        int vj = 100;
        int daj = 50;
        int npv = 3;
        int fcpv = 30;
        int ccpv = 50;
        boolean jr = true;
        System.out.println("Você entrou na masmorra!");
        J:
        while (jr) {
            System.out.println("------------------------------------------------");
            String i = is[r.nextInt(is.length)];
            int vi = r.nextInt(vmi);
            System.out.println("\t# Um " + i + " apareceu! #\n");
            while (vi > 0) {
                System.out.println("\tSeus pontos de vida: " + vj);
                System.out.println("\tPontos de vida do " + i + ": " + vi);
                System.out.println("\n\tO que você fará?");
                System.out.println("\t1. Atacar");
                System.out.println("\t2. Usar poção de vida");
                System.out.println("\t3. Correr para as colinas!");
                String rj = s.nextLine();
                if (rj.equals("1")) {
                    int aj = r.nextInt(daj);
                    int ri = r.nextInt(dai);
                    vi -= aj;
                    vj -= ri;
                    System.out.println("\t> Você golpeou o " + i + " e ele sofreu " + aj + " de dano.");
                    System.out.println("\t> Você foi ferido e sofreu " + ri + " de dano em retaliação!");
                    if (vj < 1) {
                        System.out.println("\t> Você levou muito dano e  está muito fraco para continuar!");
                        break;
                    }
                } else if (rj.equals("2")) {
                    if (npv > 0) {
                        vj += fcpv;
                        npv--;
                        System.out.println("\t> Você bebeu a poção de vida, curando-se em " + fcpv + " pontos de vida. "
                                + "\n\t> Agora você tem " + vj + " pontos de vida."
                                + "\n\t> Você agora tem " + npv + " poções de vida.\n");
                    } else {
                        System.out.println("\t> Você não tem mais poções de vida! Derrote inimigos para ter uma chance de ganhar mais poções!");
                    }
                } else if (rj.equals("3")) {
                    System.out.println("\t Você fugiu do " + i + "!");
                    continue J;
                } else {
                    System.out.println("\n------------------------------------------------");
                    System.out.println("\t> Comando Inválido.");
                    System.out.println("------------------------------------------------");
                }
            }
            if (vj < 1) {
                System.out.println("Você sai mancando da masmorra, fragilizado pela batalha.");
                break;
            }
            System.out.println("------------------------------------------------");
            System.out.println(" # " + i + " foi derrotado! # ");
            System.out.println(" # Você agora tem " + vj + " pontos de vida. # ");
            if (r.nextInt(100) < ccpv) {
                npv++;
                System.out.println(" # O " + i + " deixou cair uma poção de vida!");
                System.out.println(" # Agora você tem " + npv + " poções de vida. # ");
            }
            System.out.println("------------------------------------------------");
            System.out.println("E agora? O que você fará?");
            System.out.println("1. Seguir batalhando! Ainda sinto a presença de inimigos!");
            System.out.println("2. Sair da masmorra. Meu trabalho aqui está feito!");
            String rj = s.nextLine();
            while(!rj.equals("1") && !rj.equals("2")){
                System.out.println("\n------------------------------------------------");
                System.out.println("\t> Comando inválido!");
                System.out.println("------------------------------------------------");
                String rjci = s.nextLine();
            }
            if(rj.equals("1")){
                System.out.println("Você continua a sua aventura!");
            }
            else if(rj.equals("2")){
                System.out.println("Você deixa a masmorra, vitorioso em sua aventura!");
                break;
            }
        }
        System.out.println("#######################");
        System.out.println("#### FIM DE JOGO!  ####");
        System.out.println("#######################");
    }
}