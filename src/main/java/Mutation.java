import java.util.Random;

public class Mutation {
    float rate;
    Random gerador;

    Mutation(int n){
        this.rate = (float) n / 100;
        this.gerador = new Random();
    }

    public boolean doMutation(){
        return (this.gerador.nextFloat() <= this.rate);
    }
}
