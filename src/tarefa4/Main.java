package tarefa4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("playlist.txt"));
            while(sc.hasNext()){
                String linha = sc.nextLine();
                String[] campos = linha.split(";");

                Musica Musica = new Musica(campos[0], campos[1], campos[2]);

            }

            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado: " + e);
        }
    }
}
