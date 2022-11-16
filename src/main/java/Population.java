import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Population {
    ArrayList<Cromossomo> populacao;
    Random gerador;

    Population(int n){
        this.populacao = new ArrayList<>(n);
        gerador = new Random();
    }

    public ArrayList getPopulacao(){
        return this.populacao;
    }

    public void setPopulacao(ArrayList a){
        this.populacao = a;
    }

    public void setCromossomo(int index, Cromossomo a){
        try {
            this.populacao.set(index, a);
        }catch (IndexOutOfBoundsException e){
            this.populacao.add(index, a);
        }

    }

    public Cromossomo getCromossomo(int index){
        return this.populacao.get(index);
    }

    public void order(){
        boolean outOfOrder = true;
        int length = this.populacao.size() - 1;

        int valor_atual;
        int valor_proximo;

        Cromossomo c_aux;
        Cromossomo c_atual;
        Cromossomo c_proximo;

        int count;

        while (outOfOrder){
            count = 0;
            for (int i = 0; i < length; i++){
                valor_atual = this.populacao.get(i).getFitness();
                valor_proximo = this.populacao.get((i + 1)).getFitness();
                if (valor_atual < valor_proximo){
                    c_atual = this.populacao.get(i);
                    c_proximo = this.populacao.get((i + 1));

                    c_aux = c_atual;
                    c_atual = c_proximo;
                    c_proximo = c_aux;

                    this.populacao.set(i, c_atual);
                    this.populacao.set((i + 1), c_proximo);

                    count++;
                }
            }

            if (count == 0){
                outOfOrder = false;
            }
        }
    }
    public void printar(){
        int x;
        int y;

        System.out.println(" X  |  Y  |  GENOMA  |  FITNESS");
        for (int i = 0; i < this.populacao.size(); i++){
            x = this.populacao.get(i).getX_decimal();
            y = this.populacao.get(i).getY_decimal();
            System.out.println(" "+x+"  |  "+y+"  |  "+this.populacao.get(i).toString()+"  |  "+this.populacao.get(i).getFitness());
        }
    }
}
