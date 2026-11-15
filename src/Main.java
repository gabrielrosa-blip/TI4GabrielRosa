import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void consultarVendedor(Map<String, Double> faturamentoVendedor, String nome){
        if(faturamentoVendedor.containsKey(nome)){
            System.out.println("Consulta: " + nome + faturamentoVendedor.get(nome));
        } else{
            System.out.println("Consulta " + nome + ": Vendedor não encontrado");
        }
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Map<String, Double> totalVendedor = new HashMap<>();
        Map<String, Integer> quantidadeProduto = new HashMap<>();

        try {
            Scanner sc = new Scanner(new File("vendas.csv"));
            while(sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] campos = linha.split(";");
                String data = campos[0];
                String nomeVendedor = campos[1];
                String objeto = campos[2];
                int qntVendida = Integer.parseInt(campos[3]);
                Double precoUnitario = Double.parseDouble(campos[4]);

                Double totalVendas = qntVendida*precoUnitario;

                if(totalVendedor.containsKey(nomeVendedor)){
                    totalVendedor.put(nomeVendedor, totalVendedor.get(nomeVendedor) + totalVendas);
                } else{
                    totalVendedor.put(nomeVendedor, totalVendas);
                }

                if(quantidadeProduto.containsKey(objeto)){
                    quantidadeProduto.put(objeto, quantidadeProduto.get(objeto));
                }


            }

        } catch (FileNotFoundException e){
            System.out.println("Arquivo não existente" + e);
            return;
        }
        System.out.println("Faturamento por vendedor: ");
        for(Map.Entry<String, Double> e: totalVendedor.entrySet() ){
            System.out.println(e.getKey() + ": R$" + e.getValue());
        }
        consultarVendedor(totalVendedor, "Bruno");
        consultarVendedor(totalVendedor, "Diego");

        Double faturamentoTotal = 0.0;
        for(Double valor: totalVendedor.values()){
            faturamentoTotal += valor;
        }
        System.out.println("Faturamento total: " + faturamentoTotal);

        Double mediaVendedor = faturamentoTotal / totalVendedor.size();
        System.out.println("Média por vendedor: R$" + mediaVendedor);

        String melhorVendedor;
        Double maiorFaturamento;


    }

}