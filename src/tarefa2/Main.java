package tarefa2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Quantos alunos em ED? ");
        int alunosED = sc.nextInt();
        List<Integer> matriculasED = new ArrayList<>();
        for (int i = 0; i < alunosED; i++) {
            int mat = sc.nextInt();
            if (matriculasED.contains(mat)) {
                System.out.println("Matrícula " + mat + " repetida, ignorada (assim como ela fez comigo)");
            } else {
                matriculasED.add(mat);
            }
        }

        System.out.println("Quantos alunos em BD? ");
        int alunosBD = sc.nextInt();
        List<Integer> matriculasBD = new ArrayList<>();
        for (int i = 0; i < alunosBD; i++) {
            int mat = sc.nextInt();
            if (matriculasBD.contains(mat)) {
                System.out.println("Matrícula " + mat + " repedida, ignorada (assim como ela fez comigo)");
            } else {
                matriculasBD.add(mat);
            }
        }

        Set<Integer> setED = new HashSet<>(matriculasED);
        Set<Integer> setBD = new HashSet<>(matriculasBD);

        Set<Integer> alunosDistintos = new HashSet<>(setBD);
        alunosDistintos.addAll(setBD);
        System.out.println("Alunos distintos: " + alunosDistintos.size());

        Set<Integer> ambos = new HashSet<>(setED);
        ambos.retainAll(setBD);
        System.out.println("Cursam ambas disciplinas: " + new ArrayList<>(ambos));


        Set<Integer> somenteED = new HashSet<>(setED);
        somenteED.removeAll(setBD);
        System.out.println("Cursam apenas ED: " + new ArrayList<>(somenteED));

        Set<Integer> somenteBD = new HashSet<>(setBD);
        somenteBD.removeAll(setED);
        System.out.println("Cursam apenas BD: " + new ArrayList<>(somenteBD));

        double percentual = ((double)ambos.size()/setED.size()) * 100;
        System.out.println("Alunos que cursam ED que também cursam BD: " + percentual + "%");
    }

}
