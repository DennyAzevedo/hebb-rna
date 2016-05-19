import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;

public class ReaderTest extends TestCase {

    private Hebb algorithm;
    private static final Integer[] EXPECTED_VECTOR_X = {1,-1,-1,-1,1,-1,1,-1,1,-1,-1,-1,1,-1,-1,-1,1,-1,1,-1,1,-1,-1,-1,1};
    private static final Integer[] EXPECTED_VECTOR_O = {-1,1,1,1,-1,1,-1,-1,-1,1,1,-1,-1,-1,1,1,-1,-1,-1,1,-1,1,1,1,-1};

    @BeforeClass
    public void initialSetUp() {
        algorithm = Hebb.getInstance();
    }

    public void testReadXFile() {
        Integer[] resultingVector = new Integer[25];
        Reader.readFile(resultingVector, Reader.PATH_X);
        Assert.assertArrayEquals(EXPECTED_VECTOR_X, resultingVector);
    }

    public void testReadOFile() {
        Integer[] resultingVector = new Integer[25];
        Reader.readFile(resultingVector, Reader.PATH_O);
        Assert.assertArrayEquals(EXPECTED_VECTOR_O, resultingVector);
    }

}
