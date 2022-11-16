public class Main {

    public static void main(String[] args) {
        int taxa_mutacao = 1;
        int tam_populacao = 10;
        int n_geracoes = 10000;


        Mutation m = new Mutation(taxa_mutacao);
        Population p = new Population(tam_populacao);

        for (int i = 0; i < tam_populacao; i++){
            Cromossomo a = new Cromossomo(m.gerador.nextInt(8), m.gerador.nextInt(8));
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
