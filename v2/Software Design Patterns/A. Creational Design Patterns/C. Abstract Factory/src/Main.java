public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        performAction(configureProduct("Mac"));
    }

    public static ProductFactory configureProduct(String product) {
        if (product.equals("Mac")) {
            return new Mac();
        }
        else if (product.equals("Windows")) {
            return new Windows();
        }
        else {
            return null;
        }
    }

    public static void performAction(ProductFactory productFactory) {
        Application application = new Application(productFactory);
        application.test();
    }
}