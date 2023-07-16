package functional;

public class AppleFancyFormater implements AppleFormatter{
    @Override
    public String accept(Apple a) {
        String characteristic = a.getWeight() > 150 ? "heavy" : "light";
        return "A ".concat(characteristic).concat(" ").concat(a.getColor()).concat(" apple");
    }
}
