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
}
