import org.junit.Assert;
import org.junit.Test;

public class CromossomoTest {
    @Test
    public void VerificaBinarioQuandoInserido1(){
        int x = 1;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "001000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido2(){
        int x = 2;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "010000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido3(){
        int x = 3;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "011000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido4(){
        int x = 4;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "100000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido5(){
        int x = 5;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "101000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido6(){
        int x = 6;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "110000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido7(){
        int x = 7;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, 3);

        String valorRecebido = a.toString();
        String valorEsperado = "111000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoAlteraGene(){
        int n_bits = 3;

        int x = 2;
        int y = 2;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, n_bits);

        a.setGene(0,(new int[]{1,1,1}));

        String valorRecebido = a.toString();
        String valorEsperado = "111010";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaAtulizacaoDeGenesQuandoAlteraBinarioX(){
        int n_bits = 3;

        int x = 2;
        int y = 2;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, n_bits);

        a.setGene(0, (new int[]{1,0,1}));

        int valorEsperado = 5;
        int valorRecebido = a.getValor(0);

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaAtulizacaoDeGenesQuandoAlteraBinarioY(){
        int n_bits = 3;

        int x = 2;
        int y = 2;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, n_bits);

        a.setGene(1, (new int[]{1,0,1}));

        int valorEsperado = 5;
        int valorRecebido = a.getValor(1);

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaFitnessQuandoInformadoGenes(){
        int n_bits = 3;

        int x = 0;
        int y = 0;

        int[] valores = new int[2];
        valores[0] = x;
        valores[1] = y;

        Cromossomo a = new Cromossomo(valores, n_bits);

        double valorEsperado = 185;
        double valorRecebido = a.getFitness();

        Assert.assertEquals(valorEsperado, valorRecebido,0.001);
    }
}

