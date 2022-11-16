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

    public void roletaViciada(Mutation m){
        this.order();

        ArrayList<Cromossomo> besties = new ArrayList<>(10);

        besties.add(0, this.populacao.get(0));
        besties.add(1, this.populacao.get(0));
        besties.add(2, this.populacao.get(0));
        besties.add(3, this.populacao.get(0));
        besties.add(4, this.populacao.get(1));
        besties.add(5, this.populacao.get(1));
        besties.add(6, this.populacao.get(1));
        besties.add(7, this.populacao.get(2));
        besties.add(8, this.populacao.get(2));
        besties.add(9, this.populacao.get(3));

        int index;

        Cromossomo pai;
        Cromossomo mae;

        Cromossomo resultMutation;

        int length = this.populacao.size();

        for (int i = 0; i < length ; i++){
            index = m.gerador.nextInt(this.populacao.size());
            pai = besties.get(index);

            index = m.gerador.nextInt(this.populacao.size());
            mae = besties.get(index);

            resultMutation = m.crossover(pai, mae);

            this.populacao.set(i, resultMutation);
        }
        this.order();
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

    public void novaGeracao(Mutation m){
        updateFitness();
        this.roletaViciada(m);
        for (int i = 0; i < this.populacao.size(); i++){
            if(m.devoMutar()){
                Cromossomo a = this.populacao.get(i);
                a.setGenoma(m.doMutation(a.getGenoma()));
                this.populacao.set(i, a);
            }
        }
        updateFitness();
    }

    public void updateFitness(){
        for (int i = 0; i < this.populacao.size(); i++){
            this.populacao.get(i).updateGenes();
        }
    }
}
