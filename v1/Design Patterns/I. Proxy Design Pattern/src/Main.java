interface Image {
    void display();
}

class RealImage implements Image {
    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImage();
    }

    public void loadImage() {
        System.out.println("Loading " + this.fileName);
    }

    public void display() {
        System.out.println("Displaying " + this.fileName);
    }
}

class ProxyImage implements Image {
    String filename;
    RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage==null) {
            realImage = new RealImage(this.filename);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image firstImage = new ProxyImage("Goku_20MB.jpg");
        Image secondImage = new ProxyImage("Goku_10mb.jpg");

        firstImage.display();
        secondImage.display();

        firstImage.display();
        secondImage.display();
    }
}