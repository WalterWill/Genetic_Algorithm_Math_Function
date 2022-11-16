import org.junit.Test;

public class PopulationTest {
    @Test
    public void VerificaStringQuandoSolicitado(){
        Cromossomo c1 = new Cromossomo(0,7);
        Cromossomo c2 = new Cromossomo(1,6);
        Cromossomo c3 = new Cromossomo(2,5);
        Cromossomo c4 = new Cromossomo(3,4);
        Cromossomo c5 = new Cromossomo(4,3);
        Cromossomo c6 = new Cromossomo(5,2);
        Cromossomo c7 = new Cromossomo(6,1);
        Cromossomo c8 = new Cromossomo(7,0);
        Cromossomo c9 = new Cromossomo(0,0);
        Cromossomo c10 = new Cromossomo(2,3);

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
}
