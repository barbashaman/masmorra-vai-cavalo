package domandoACriatura.dominios.sistema;

import java.util.Random;
import java.util.Scanner;

public class Sistema {
    public static Scanner leitorComandos = new Scanner(System.in);
    public static Random valoresRandomicos = new Random();

    public static String lerComandoTeclado() {
        return Sistema.leitorComandos.nextLine();
    }

    public static void imprimir(String... texto) {
        for (String linha : texto)
            System.out.println(linha);
    }

    public static int proximoInteiroRandomico(int maximo){
        return valoresRandomicos.nextInt(maximo);
    }

}
