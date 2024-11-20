import java.util.Random;

public class RollDices {

    public static String rollD4() {
        Random random = new Random();
        int roll = random.nextInt(4) + 1;
        return String.format("Rolagem do D4: %d", roll);
    }
    public static String rollD6() {
        Random random = new Random();
        int roll = random.nextInt(6) + 1;
        return String.format("Rolagem do D6: %d", roll);
    }
    public static String rollD8() {
        Random random = new Random();
        int roll = random.nextInt(8) + 1;
        return String.format("Rolagem do D8: %d", roll);
    }
    public static String rollD10() {
        Random random = new Random();
        int roll = random.nextInt(10) + 1;
        return String.format("Rolagem do D10: %d", roll);
    }
    public static String rollD12() {
        Random random = new Random();
        int roll = random.nextInt(12) + 1;
        return String.format("Rolagem do D12: %d", roll);
    }
    public static String rollD20() {
        Random random = new Random();
        int roll = random.nextInt(20) + 1;
        return String.format("Rolagem do D20: %d", roll);
    }
}
