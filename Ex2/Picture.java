package Ex2;

public class Picture implements Present {
    @Override
    public String itCanBePresented() {
        return "Picture can be presented!";
    }

    @Override
    public void whoAmI() {
        System.out.println("I am a Picture");
    }
}
