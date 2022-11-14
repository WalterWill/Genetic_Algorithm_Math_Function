import org.junit.Assert;
import org.junit.Test;

public class CromossomoTest {
    @Test
    public void VerificaBinarioQuandoInserido1(){
        int x = 1;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "001000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido2(){
        int x = 2;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "010000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido3(){
        int x = 3;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "011000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido4(){
        int x = 4;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "100000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido5(){
        int x = 5;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "101000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido6(){
        int x = 6;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "110000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoInserido7(){
        int x = 7;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        String valorRecebido = a.toString();
        String valorEsperado = "111000";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaBinarioQuandoAlteraGene(){
        int x = 2;
        int y = 2;

        Cromossomo a = new Cromossomo(x,y);

        a.setX((new int[]{1,1,1}));

        String valorRecebido = a.toString();
        String valorEsperado = "111010";

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaAtulizacaoDeGenesQuandoAlteraBinarioX(){
        int x = 2;
        int y = 2;

        Cromossomo a = new Cromossomo(x,y);

        a.setX((new int[]{1,0,1}));

        int valorEsperado = 5;
        int valorRecebido = a.getX_decimal();

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaAtulizacaoDeGenesQuandoAlteraBinarioY(){
        int x = 2;
        int y = 2;

        Cromossomo a = new Cromossomo(x,y);

        a.setY((new int[]{1,0,1}));

        int valorEsperado = 5;
        int valorRecebido = a.getY_decimal();

        Assert.assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void VerificaFitnessQuandoInformadoGenes(){
        int x = 0;
        int y = 0;

        Cromossomo a = new Cromossomo(x,y);

        int valorEsperado = -11;
        int valorRecebido = a.getFitness();

        Assert.assertEquals(valorEsperado, valorRecebido);
    }
}

