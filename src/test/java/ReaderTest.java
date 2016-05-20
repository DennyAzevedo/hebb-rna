import junit.framework.TestCase;
import org.junit.Assert;

public class ReaderTest extends TestCase {

    private static final Integer[] EXPECTED_VECTOR_X = {1,-1,-1,-1,1,-1,1,-1,1,-1,-1,-1,1,-1,-1,-1,1,-1,1,-1,1,-1,-1,-1,1};
    private static final Integer[] EXPECTED_VECTOR_O = {-1,1,1,1,-1,1,-1,-1,-1,1,1,-1,-1,-1,1,1,-1,-1,-1,1,-1,1,1,1,-1};

    public void testReadXFile() {
        Integer[] resultingVector = Reader.readFile(Reader.PATH_X);
        Assert.assertArrayEquals(EXPECTED_VECTOR_X, resultingVector);
    }

    public void testReadOFile() {
        Integer[] resultingVector = Reader.readFile(Reader.PATH_O);
        Assert.assertArrayEquals(EXPECTED_VECTOR_O, resultingVector);
    }

}
