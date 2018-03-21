package Ex2;

public class Toy implements Present {
    @Override
    public String itCanBePresented() {
        return "Toy can be presented!";
    }

    @Override
    public void whoAmI() {
        System.out.println("I am a Toy");
    }
}
