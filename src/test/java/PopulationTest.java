import org.junit.Test;

public class PopulationTest {
    @Test
    public void VerificaStringQuandoSolicitado(){
        int n_bits = 3;
        int[] valores = new int[2];

        valores[0] = 0;
        valores[1] = 7;
        Cromossomo c1 = new Cromossomo(valores, n_bits);

        valores[0] = 1;
        valores[1] = 6;
        Cromossomo c2 = new Cromossomo(valores, n_bits);

        valores[0] = 2;
        valores[1] = 5;
        Cromossomo c3 = new Cromossomo(valores, n_bits);

        valores[0] = 3;
        valores[1] = 4;
        Cromossomo c4 = new Cromossomo(valores, n_bits);

        valores[0] = 4;
        valores[1] = 3;
        Cromossomo c5 = new Cromossomo(valores, n_bits);

        valores[0] = 5;
        valores[1] = 2;
        Cromossomo c6 = new Cromossomo(valores, n_bits);

        valores[0] = 6;
        valores[1] = 1;
        Cromossomo c7 = new Cromossomo(valores, n_bits);

        valores[0] = 7;
        valores[1] = 0;
        Cromossomo c8 = new Cromossomo(valores, n_bits);

        valores[0] = 0;
        valores[1] = 0;
        Cromossomo c9 = new Cromossomo(valores, n_bits);

        valores[0] = 2;
        valores[1] = 3;
        Cromossomo c10 = new Cromossomo(valores, n_bits);

        Population p = new Population(10);

        p.setCromossomo(0, c1);
        p.setCromossomo(1, c2);
        p.setCromossomo(2, c3);
        p.setCromossomo(3, c4);
        p.setCromossomo(4, c5);
        p.setCromossomo(5, c6);
        p.setCromossomo(6, c7);
        p.setCromossomo(7, c8);
        p.setCromossomo(8, c9);
        p.setCromossomo(9, c10);

        p.printar();

        p.order();

        p.printar();
    }

    @Test
    public void VerificaCromossomosQuandoGeradoNovaGeracao(){
        int n_bits = 3;
        int[] valores = new int[2];

        valores[0] = 0;
        valores[1] = 7;
        Cromossomo c1 = new Cromossomo(valores, n_bits);

        valores[0] = 1;
        valores[1] = 6;
        Cromossomo c2 = new Cromossomo(valores, n_bits);

        valores[0] = 2;
        valores[1] = 5;
        Cromossomo c3 = new Cromossomo(valores, n_bits);

        valores[0] = 3;
        valores[1] = 4;
        Cromossomo c4 = new Cromossomo(valores, n_bits);

        valores[0] = 4;
        valores[1] = 3;
        Cromossomo c5 = new Cromossomo(valores, n_bits);

        valores[0] = 5;
        valores[1] = 2;
        Cromossomo c6 = new Cromossomo(valores, n_bits);

        valores[0] = 6;
        valores[1] = 1;
        Cromossomo c7 = new Cromossomo(valores, n_bits);

        valores[0] = 7;
        valores[1] = 0;
        Cromossomo c8 = new Cromossomo(valores, n_bits);

        valores[0] = 0;
        valores[1] = 0;
        Cromossomo c9 = new Cromossomo(valores, n_bits);

        valores[0] = 2;
        valores[1] = 3;
        Cromossomo c10 = new Cromossomo(valores, n_bits);

        Population p = new Population(10);

        p.setCromossomo(0, c1);
        p.setCromossomo(1, c2);
        p.setCromossomo(2, c3);
        p.setCromossomo(3, c4);
        p.setCromossomo(4, c5);
        p.setCromossomo(5, c6);
        p.setCromossomo(6, c7);
        p.setCromossomo(7, c8);
        p.setCromossomo(8, c9);
        p.setCromossomo(9, c10);

        System.out.println("PRIMEIRA GERACAO");
        p.printar();

        System.out.println("ROLETA VICIADA");
        p.roletaViciada(new Mutation(50));
        p.printar();
    }
}
