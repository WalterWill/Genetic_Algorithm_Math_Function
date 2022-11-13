import java.util.Arrays;

public class Cromossomo {
    int n_bits = 3;
    int[] x;
    int[] y;

    Cromossomo(int x, int y){
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
    }

    public String toString(){
        return (Arrays.toString(this.x).replaceAll("\\[|]|,|\\s", "") + Arrays.toString(this.y).replaceAll("\\[|]|,|\\s", ""));
    }
}
