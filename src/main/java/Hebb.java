public class Hebb {

    private Integer[] w;
    private Integer[] x;
    private Integer identifier;
    private boolean isTrained;
    private static Hebb algorithm;
    private static final int SIZE = 25;

    private static final String LETTER_IS_O = "The letter you tested looks like an 'O'... =D";
    private static final String LETTER_IS_X = "The letter you tested looks like an 'X'... =D";

    public Hebb() {
        x = new Integer[SIZE];
        w = new Integer[SIZE];
        isTrained = false;
        initW();
    }

    private void initW() {
        for (int i = 0; i < w.length; i++) {
            w[i] = 0;
        }
    }

    public void trainW() {
        for (int i = 0; i < 2; i++) {

            Reader.readFile(x, i == 0 ? Reader.PATH_O : Reader.PATH_X);
            identifier = (i == 0) ? -1 : 1;

            for (int j = 0; j < SIZE; j++) {
                w[j] += x[j] * identifier;
            }
        }
        isTrained = true;
    }

    public String test() {
        Reader.readFile(x, Reader.PATH_TEST);
        identifier = 0;

        for (int i = 0; i < SIZE; i++) {
            identifier += x[i] * w[i];
        }

        return (identifier > 0) ? LETTER_IS_X : LETTER_IS_O;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public static Hebb getInstance() {
        if (algorithm == null) {
            algorithm = new Hebb();
        }
        return algorithm;
    }

    public Integer[] getW() {
        return this.w;
    }

}
