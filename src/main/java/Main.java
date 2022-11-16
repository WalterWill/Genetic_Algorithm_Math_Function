public class Main {
    public static void main(String[] args) {

        Mutation m = new Mutation(100);
        Population p = new Population(10);

        for (int i = 0; i < 10; i++){
            Cromossomo a = new Cromossomo(m.gerador.nextInt(8), m.gerador.nextInt(8));
            p.setCromossomo(i, a);
        }
        System.out.println("CROMOSSOMOS GERADOS");
        p.printar();
        System.out.println("==========================\n");

        for (int i = 0; i < 10; i++){
            System.out.println("GERACAO "+i);
            p.order();
            p.printar();
            System.out.println("==========================\n");
            p.novaGeracao(m);
        }

    }
}
