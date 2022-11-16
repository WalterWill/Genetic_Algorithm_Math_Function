import java.util.Arrays;

public class Cromossomo {
    int n_bits = 3;
    int[] x;
    int[] y;

    int[] input;

    int fitness;

    Cromossomo(int x, int y){
        this.input = new int[2];
        this.input[0] = x;
        this.input[1] = y;

        this.x = new int[n_bits];
        this.y = new int[n_bits];

        char[] x_char = new char[n_bits];
        char[] y_char = new char[n_bits];

        String aux_x;
        aux_x = Integer.toBinaryString(x);

        String aux_y;
        aux_y = Integer.toBinaryString(y);

        //Fator de correção do tamanho dos vetores
        int correction;

        //Insere o X
        if (aux_x.length() > n_bits){
            throw new IllegalArgumentException();
        } else {
            correction = this.n_bits - aux_x.length();
            aux_x.getChars(0,aux_x.length(),x_char, correction);

            for (int i = 0; i < n_bits; i++){
                if (x_char[i] == '1'){
                    this.x[i] = 1;
                } else {
                    this.x[i] = 0;
                }
            }

        }

        //Insere o Y
        if (aux_y.length() > n_bits){
            throw new IllegalArgumentException();
        } else {
            correction = this.n_bits - aux_y.length();
            aux_y.getChars(0,aux_y.length(),y_char, correction);

            for (int i = 0; i < n_bits; i++){
                if (y_char[i] == '1'){
                    this.y[i] = 1;
                } else {
                    this.y[i] = 0;
                }
            }
        }
        //Atualiza o Fitness
        updateFitness();
    }

    Cromossomo(int[] a){
        this.input = new int[2];

        this.x = new int[n_bits];
        this.y = new int[n_bits];

        char[] x_char = new char[n_bits];
        char[] y_char = new char[n_bits];

        setGenoma(a);
        updateGenes();
        updateFitness();
    }

    public int[] getX() {
        return x;
    }

    public int getX_decimal() {
        return input[0];
    }

    public int[] getY() {
        return y;
    }

    public int getY_decimal() {
        return input[1];
    }

    public void setX(int[] x) {
        this.x = x;
        updateGenes();
    }

    public void setY(int[] y) {
        this.y = y;
        updateGenes();
    }

    public void setGenoma(int[] a){
        this.x[0] = a[0];
        this.x[1] = a[1];
        this.x[2] = a[2];

        this.y[0] = a[3];
        this.y[1] = a[4];
        this.y[2] = a[5];

        updateGenes();
        updateFitness();
    }

    public int[] getGenoma(){
        int[] genoma = new int[6];

        genoma[0] = this.x[0];
        genoma[1] = this.x[1];
        genoma[2] = this.x[2];
        genoma[3] = this.y[0];
        genoma[4] = this.y[1];
        genoma[5] = this.y[2];

        return genoma;
    }

    public String toString(){
        return (Arrays.toString(this.x).replaceAll("\\[|]|,|\\s", "") + Arrays.toString(this.y).replaceAll("\\[|]|,|\\s", ""));
    }

    public void updateGenes(){
        int count = 0;
        int result = 0;
        for (int i = (this.n_bits -1); i >= 0; i--){
            result += (Math.pow(2,count) * this.x[i]);
            count++;
        }

        this.input[0] = result;

        count = 0;
        result = 0;
        for (int i = (this.n_bits -1); i >= 0; i--){
            result += (Math.pow(2,count) * this.y[i]);
            count++;
        }

        this.input[1] = result;

        updateFitness();
    }

    private void updateFitness(){
        double parcialX = this.input[0] -2;
        parcialX = Math.pow(parcialX, 2);

        double parcialY = this.input[1] - 3;
        parcialY = Math.pow(parcialY, 2);

        this.fitness = (int) (2 - parcialX - parcialY);
    }

    public int getFitness(){
        updateFitness();
        return this.fitness;
    }
}
