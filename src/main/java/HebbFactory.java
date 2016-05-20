public class HebbFactory {

    private static Hebb algorithm;

    public HebbFactory() {};

    public static Hebb getInstance() {
        if (algorithm == null) {
          algorithm = new Hebb();
        }
        return algorithm;
    }
}
