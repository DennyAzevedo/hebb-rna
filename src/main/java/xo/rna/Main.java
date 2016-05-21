package xo.rna;

import txt.generator.RandomTxtGenerator;

import javax.swing.*;

public class Main {

    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int EXIT_OPTION = 4;
    private static final String OPTIONS_MSG = "Choose an option: \n 1 - TrainW \n 2 - Test \n 3 - Generate new test.txt \n 4 - Exit";
    private static final String INVALID_OPTION_MSG = "Invalid option!";
    private static final String SUCCESS_TRAINED_MSG = "Network trained with success.";
    private static final String NEW_TEST_FILE_MSG = "A new test.txt file was generated.";
    private static final String MUST_TRAIN_BEFORE_MSG = "The network must be trained before testing.";

    public static void main(String[] args) {

        int option = 0;
        Hebb algorithm = HebbFactory.getInstance();

        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(OPTIONS_MSG));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, INVALID_OPTION_MSG);
            }

            switch (option) {
                case OPTION_1:
                    algorithm.trainW();
                    JOptionPane.showMessageDialog(null, SUCCESS_TRAINED_MSG);
                    break;
                case OPTION_2:
                    if(algorithm.isTrained()) {
                        JOptionPane.showMessageDialog(null, algorithm.test());
                    } else {
                        JOptionPane.showMessageDialog(null, MUST_TRAIN_BEFORE_MSG);
                    }
                    break;
                case OPTION_3:
                    RandomTxtGenerator textGenerator = new RandomTxtGenerator();
                    textGenerator.generateNewRandomTestFile();
                    JOptionPane.showMessageDialog(null, NEW_TEST_FILE_MSG);
                    break;
            }
        } while(option != EXIT_OPTION);
    }

}
