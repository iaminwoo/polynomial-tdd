public class Calc {
    public static int run(String input) {
        String[] inputParts = input.split("\\+");
        int firstNum = Integer.parseInt(inputParts[0].strip());
        int secondNum = Integer.parseInt(inputParts[1].strip());

        return firstNum + secondNum;
    }
}
