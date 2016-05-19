import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void readFile(Integer[] x, String path) throws IOException {

        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            int i = 0;

            while((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                for(int j = 0 ; j < line.length() ; j++) {
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
                bufferedReader.close();
            }
        } catch (IOException err) {
            System.err.printf("An error occurred when trying to opening the file: " + err.getMessage());
        }

    }

}
