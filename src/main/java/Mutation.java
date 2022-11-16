import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mutation {
    float rate;
    Random gerador;

    Mutation(int n){
        this.rate = (float) n / 100;
        this.gerador = new Random();
    }

    public boolean devoMutar(){
        return (this.gerador.nextFloat() <= this.rate);
    }

    public int[] doMutation(int[] a){

        int lenght = a.length;

        int index = this.gerador.nextInt(lenght);

        if (a[index] == 0){
            a[index] = 1;
        }else {
            a[index] = 0;
        }

        return a;
    }

    public List<Cromossomo> crossover(Cromossomo a, Cromossomo b){
        List<Cromossomo> result = new ArrayList<>();
        int length = a.getGenoma().length;
        int pivo = this.gerador.nextInt(length);

        int[] genoma_a = a.getGenoma();
        int[] genoma_b = b.getGenoma();
        int aux;

        for (int i = pivo; i < length; i++){
            aux = genoma_a[i];
            genoma_a[i] = genoma_b[i];
            genoma_b[i] = aux;
        }

        a.setGenoma(genoma_a);
        b.setGenoma(genoma_b);

        result.add(a);
        result.add(b);

        return result;
    }
}
