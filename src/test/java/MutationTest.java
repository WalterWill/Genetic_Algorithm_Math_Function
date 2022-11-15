import org.junit.Assert;
import org.junit.Test;

public class MutationTest {
    @Test
    public void VerificaTaxaQuandoDefinida(){
        int taxaEsperada_int = 10;
        int amostragem = (int) Math.pow(10,4);
        int qntd_mutation = 0;

        Mutation a = new Mutation(taxaEsperada_int);

        for (int i = 0; i < amostragem; i++){
            if (a.devoMutar()){
                qntd_mutation++;
            }
        }

        float taxaEsperada_float = (float) taxaEsperada_int / 100;
        float taxaVisualizada = (float) qntd_mutation / amostragem;



        System.out.printf("Taxa desejada: %.3f", taxaEsperada_float);
        System.out.printf("Taxa visualizada: %.3f", taxaVisualizada);

        Assert.assertEquals(taxaEsperada_float, taxaVisualizada, 0.01);
    }

    @Test
    public void VerificaVetorQuandoRealizadoMutacao(){
        int x = 7;
        int y = 7;

        Cromossomo c = new Cromossomo(x,y);
        Mutation m = new Mutation(100);

        int[] valorNaoEsperado = c.getGenoma();

        System.out.println("Valor Original: "+ c.toString());

        int[] valorRecebido = m.doMutation(c.getGenoma());
        c.setGenoma(valorRecebido);

        System.out.println("Valor Recebido: "+ c.toString());

        Assert.assertNotEquals(valorNaoEsperado, valorRecebido);
    }
}
