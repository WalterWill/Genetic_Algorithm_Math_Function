import java.util.Arrays;

public class Cromossomo {
    int n_bits = 3; //Valor padrão de quantidade de BITs utilizados para representar um numero,podendo ser alterado no metodo Construtor
    int[][] gene;   //Matrix onde cada linha representa um numero em binario e cada coluna representa um BIT, podendo ser 0 ou 1

    int[] valores;  //Valores de entrada em forma decimal
    double fitness; //Valor de pontuação do cromossomo

    //Contrutor passando os valores iniciais em Decimal e a quantidade de BITs por entrada
    Cromossomo(int[] valores, int n_bits){
        this.valores = valores;
        this.n_bits = n_bits;

        int n_input = valores.length;
        this.gene = new int[n_input][this.n_bits];

        //Converte as entradas em Binario
        for (int i = 0; i < n_input; i++){
            toBinario(this.valores[i], i);
        }

        //Atualiza o Fitness
        updateFitness();
    }

    //Contrutor passando todos os genes em binario
    Cromossomo(int[] genoma){
        int n_valores = genoma.length / this.n_bits;    //Calcula a quantidade de entradas dividindo o tamanho do Genoma pelo numero de BIT necessario para cada valor
                                                        //Por padrão, n_bits é 3
        this.valores = new int[n_valores];

        setGenoma(genoma);
        updateValores();
        updateFitness();
    }

    //Converte um valor de entrada de DECIMAL para BINARIO, já salvando na matriz
    private void toBinario(int num, int index){
        char[] val_char = new char[this.n_bits];

        String aux_val;
        aux_val = Integer.toBinaryString(num);

        //Fator de correção do tamanho dos vetores
        int correction;     //O numero e binario pode utilizar menos bits que o declarado em n_bits
                            //Para corrigir isso, o CORRECTION faz com que o primeiro bit vá para a ultima posição do gene
                            //aux_val = 10      (2 em binario)
                            //this.gene por padrão tem 3 bits de espaço
                            //Com o CORRECTION fica 1 para que não seja tentado copiar um terceiro bit de AUX_VAL
                            //this.gene = 010

        //Coverte o numero
        if (aux_val.length() > this.n_bits){
            throw new IllegalArgumentException();
        } else {
            correction = this.n_bits - aux_val.length();
            aux_val.getChars(0,aux_val.length(),val_char, correction);

            for (int i = 0; i < this.n_bits; i++){
                if (val_char[i] == '1'){
                    this.gene[index][i] = 1;
                } else {
                    this.gene[index][i] = 0;
                }
            }
        }
    }

    //Devolve um vetor com os genes do valor de entrada infonfando seu index
    public int[] getGene(int index) {
        int[] x = new int[this.n_bits];

        for (int i = 0; i < this.n_bits; i++){
            x[i] = this.gene[index][i];
        }

        return x;
    }

    //Devolve o valor de entrada informando seu index
    public int getValor(int index) {
        return this.valores[index];
    }

    //Define os genes do valor de entrada informado pelo index
    public void setGene(int index, int[] gene) {
        for (int j = 0; j < this.n_bits; j++){
            this.gene[index][j] = gene[j];
        }
        updateValores();
    }

    //Define todos os genes de todos os valores de entrada
    public void setGenoma(int[] a){ //Os genes são passados em linha unica de inteiros
        int index = 0;

        //Distribui os genes pelos valores de entrada com auxilio do n_bits para determinar quantos BITs cada valor possui
        for (int i = 0; i < this.valores.length; i++){
            for (int j = 0; j < this.n_bits; j++){
                this.gene[i][j] = a[index];
                index++;
            }
        }

        updateValores();
        updateFitness();
    }

    //Devolve todos os genes em uma linha unica de inteiros
    public int[] getGenoma(){
        int n = this.valores.length * this.n_bits;

        int[] genoma = new int[n];
        int count = 0;

        for (int i = 0; i < this.valores.length; i++){
            for (int j = 0; j < this.n_bits; j++){
                genoma[count] = this.gene[i][j];
                count++;
            }
        }

        return genoma;
    }

    //Devolve todos os genes em uma String
    public String toString(){
        String text = new String();
        String aux = new String();

        int n_valores = this.valores.length;

        for (int i = 0; i < n_valores; i++){
            for (int j = 0; j < this.n_bits; j++){
                aux = Integer.toString(this.gene[i][j]);
                text = text + aux;
            }
        }
        return text;
    }

    //Atualiza os valores decimais fazendo a leitura dos numeros em binario salvos em this.genes
    public void updateValores(){
        int count;
        int result;

        int n_valores = this.valores.length;

        for (int i = 0; i < n_valores; i++){
            count = 0;
            result = 0;
            for (int j = (this.n_bits - 1); j >= 0; j--){
                result += (Math.pow(2,count) * this.gene[i][j]);
                count++;
            }
            this.valores[i] = result;
        }

        updateFitness();
    }

    //Atualiza o valor de this.fitness passando os valores de entrada pela função objetivo
    private void updateFitness(){
        Double target = Double.valueOf(185);

        double parcialX = Double.valueOf(this.valores[0]);
        parcialX = parcialX * 5;

        double parcialY = Double.valueOf(this.valores[1]);
        parcialY = Math.pow(parcialY, 2);

        //double parcialW = this.valores[2];

        //double parcialZ = this.valores[3];
        //parcialZ = Math.pow(parcialY, 3);

        //double parcial_result = parcialX + parcialY + parcialW + parcialZ;
        double parcial_result = parcialX + parcialY;
        parcial_result = target - parcial_result;

        if (parcial_result < Double.valueOf(0)){
            parcial_result = parcial_result * (-1);
        }

        this.fitness = parcial_result;
    }

    //Devolve o valor armazenado em this.fitness
    public double getFitness(){
        updateFitness();
        return this.fitness;
    }
}
