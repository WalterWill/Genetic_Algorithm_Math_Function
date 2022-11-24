public class Main {

    public static void main(String[] args) {
        int taxa_mutacao = 20;
        int tam_populacao = 10;
        int n_geracoes = 1000;
        int n_valores = 4;
        int n_bits = 10;
        int valor_maximo = (int) Math.pow(2, n_bits);


        Mutation m = new Mutation(taxa_mutacao);
        Population p = new Population(tam_populacao);
        int[] valores = new int[n_valores];

        for (int i = 0; i < tam_populacao; i++){
            for (int index = 0; index < n_valores; index++){
                valores[index] = m.gerador.nextInt(valor_maximo);
            }

            Cromossomo a = new Cromossomo(valores, n_bits);
            p.setCromossomo(i, a);
        }
        System.out.println("CROMOSSOMOS GERADOS");
        p.printar();
        System.out.println("==========================\n");

        for (int i = 0; i < n_geracoes; i++){
            System.out.println("GERACAO "+i);
            p.order();
            p.printar();
            System.out.println("==========================\n");
            p.novaGeracao(m);
        }

    }
}
