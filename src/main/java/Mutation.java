import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mutation {
    float rate;     //Valor que indica qual a porcentagem das vezes que deve ser feito uma mutação
    Random gerador;     //Objeto gerador de numeros aleatorios

    //Construtor onde é indicado o nivel de mutação em numero inteiro
    //Ex.: 10   (Para indicar 10% dos casos)
    Mutation(int n){
        this.rate = (float) n / 100;
        this.gerador = new Random();
    }

    //Devolve um booleano indicando se deve ocorrer uma mutação com base na taxa de mutação salva em this.rate
    public boolean devoMutar(){
        return (this.gerador.nextFloat() <= this.rate);
    }

    //Efetua uma mutação no vetor de genes passados por parametro
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

    //Utiliza dos cromossomos para efetuar o cruzamento de seus genes e gerar um novo cromossomo resultante
    public Cromossomo crossover(Cromossomo a, Cromossomo b){

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

        Cromossomo result = new Cromossomo(genoma_a, a.n_bits);

        return result;
    }
}
