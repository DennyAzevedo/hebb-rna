public class Hebb {

    private Integer[] w;
    private Integer[] x;
    private Integer identifier;
    private boolean isTrained;
    private static final int QTD_FILES = 2;
    public static final int SIZE = 25;
    private static final int IDENTIFICADOR_O = -1;
    private static final int IDENTIFICADOR_X = 1;
    private static final String LETTER_IS_O = "The letter you tested looks like an 'O'... =D";
    private static final String LETTER_IS_X = "The letter you tested looks like an 'X'... =D";

    public Hebb() {
        x = new Integer[SIZE];
        w = new Integer[SIZE];
        isTrained = false;
        initW();
    }

    /**
     * Método ativador dos pesos.
     * Neste exemplo, o peso para todos os valores do vetor a ser treinado é 0.
     * Em outros casos, o corpo do método deve ser alterado.
     */
    private void initW() {
        for (int i = 0; i < w.length; i++) {
            w[i] = 0;
        }
    }

    /**
     * Treina o vetor W.
     * Para cada arquivo a ser treinado é definido um identificador, 1 ou -1.
     * O valor treinado de cada item do vetor W é a soma do peso, somado ao resultado do valor
     * retornado do método readFile() multiplicado pelo identificador.
     */
    public void trainW() {
        for (int i = 0; i < QTD_FILES; i++) {

            this.x = Reader.readFile(i == 0 ? Reader.PATH_O : Reader.PATH_X);
            identifier = (i == 0) ? IDENTIFICADOR_O : IDENTIFICADOR_X;

            for (int j = 0; j < SIZE; j++) {
                w[j] += x[j] * identifier;
            }
        }
        isTrained = true;
    }

    /**
     * Testa um arquivo para identificar se o mesmo possui mais semelhança com 'X' ou 'O'.
     * @return Mensagem padrão do arquivo identificado.
     */
    public String test() {
        this.x = Reader.readFile(Reader.PATH_TEST);
        identifier = 0;

        for (int i = 0; i < SIZE; i++) {
            identifier += x[i] * w[i];
        }

        return (identifier > 0) ? LETTER_IS_X : LETTER_IS_O;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public Integer[] getW() {
        return this.w;
    }

}
