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
}

