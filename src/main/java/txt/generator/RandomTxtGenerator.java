package txt.generator;

import xo.rna.Hebb;
import xo.rna.Reader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class RandomTxtGenerator {

    public RandomTxtGenerator() {};

    public void generateNewRandomTestFile() {
        StringBuilder sb = new StringBuilder();
        generatesRandomText(sb);
        generatesTestTxtFile(sb);
    }

    private void generatesRandomText(StringBuilder sb) {
        for (int i = 0; i < Hebb.SIZE; i++) {
            if (i!=0 && i%5 == 0){
                sb.append("\n");
            }
            int randomValue = (int) Math.round(Math.random());
            sb.append(returnCharacter(randomValue));
        }
    }

    private char returnCharacter(int i) {
        if (i == 0) {
            return '#';
        }
        return '.';
    }

    private void generatesTestTxtFile(StringBuilder sb) {
        try{
            BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(Reader.PATH_TEST)));
            bwr.write(sb.toString());
            bwr.flush();
            bwr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
