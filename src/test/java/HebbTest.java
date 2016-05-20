import junit.framework.TestCase;
import org.junit.Assert;

public class HebbTest extends TestCase {

    private Hebb algorithm;
    private static final Integer[] EXPECTED_XO_TRAINED_VECTOR = {2, -2, -2, -2, 2, -2, 2, 0, 2, -2, -2, 0, 2, 0, -2, -2, 2, 0, 2, -2, 2, -2, -2, -2, 2};

    public void testTrainW() {
        algorithm = HebbFactory.getInstance();
        Integer[] resultingVector;
        algorithm.trainW();
        resultingVector = algorithm.getW();
        Assert.assertArrayEquals(EXPECTED_XO_TRAINED_VECTOR, resultingVector);
    }

}
