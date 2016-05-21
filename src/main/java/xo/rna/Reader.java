package xo.rna;

import java.io.*;

public class Reader {

    public static final String PATH_O = "/home/nbfontana/git-repos/xo-rna/src/main/resources/o.txt";
    public static final String PATH_X = "/home/nbfontana/git-repos/xo-rna/src/main/resources/x.txt";
    public static final String PATH_TEST = "/home/nbfontana/git-repos/xo-rna/src/main/resources/test.txt";

    /**
     * Lê arquivo com base no caminho recebido por parametro.
     * Para cada caractere do arquivo é atribuido um valor correspondente ao mesmo no vetor de retorno.
     * @param path
     * @return Integer[]
     */
    public static Integer[] readFile(String path) {

        Integer[] x = new Integer[Hebb.SIZE];

        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            int i = 0;

            while((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                for(int j = 0; j < line.length(); j++) {
                    switch (line.charAt(j)) {
                        case '#':
                            x[i] = 1;
                            break;
                        case '.':
                            x[i] = -1;
                            break;
                        default:
                            x[i] = 0;
                            break;
                    }
                    i++;
                }
            }

            bufferedReader.close();
        } catch (IOException err) {
            System.err.printf("An error occurred when trying to opening the file: " + err.getMessage());
        }

        return x;
    }

}
