package tarefa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner imput = new Scanner(System.in);

        Set<String> eleitores = new HashSet<>();
        List<String> candidatos = new ArrayList<>();
        Map<String, Integer> votos = new HashMap<>();
        Set<String> votosDesconsiderados = new HashSet<>();

        try{
            System.out.println("Informe o caminho do arquivo: ");
            String macarena = imput.nextLine();
            Scanner sc = new Scanner(new File(macarena));

            while(sc.hasNext()) {
                String linha = sc.nextLine();
                String[] campos = linha.split(";");
                String eleitor = campos[0].trim();
                String candidato = campos[1].trim();

                if(eleitores.contains(eleitor)){
                    votosDesconsiderados.add(eleitor);
                } else {
                    eleitores.add(eleitor);
                    if(votos.containsKey(candidato)){
                        eleitores.add(eleitor);
                        if(votos.containsKey(candidato)){
                            votos.put(candidato, votos.get(candidato) + 1);
                        } else {
                            votos.put(candidato, 1);
                        }
                    }
                }

            }
            sc.close();
            int totalVotosValidos = eleitores.size();

            System.out.println("Votos desconsiderados (eleitor repetido): " + votosDesconsiderados);
            System.out.println("Total votos válidos: " + totalVotosValidos);

            String vencedor = "";
            int maiorVotos = 0;
            for(String opcao: votos.keySet()){
                int qntd = votos.get(opcao);
                double percentual = (qntd*100)/totalVotosValidos;
                System.out.println("%s: %d votos (%.2f%%)%n" + opcao + qntd + percentual);
                if(qntd > maiorVotos){
                    maiorVotos = qntd;
                    vencedor = opcao;
                }
            }
            System.out.println("Vencedor: " + vencedor);

        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado" + e);
        }


        imput.close();
    }
}
