public class WindowButton implements Button{
    @Override
    public void render() {
        System.out.println("<button>Window Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - Hello World");
    }
}
