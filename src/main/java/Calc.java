public class Calc {
    public static int run(String input) {
        input = input.replace(" ","");
        if(input.contains("+")){
            return operation(input, "\\+");
        } else if (input.contains("-")) {
            return operation(input, "-");
        }
        return 0;
    }

    public static int operation(String input, String operator) {
        String[] inputParts = input.split(operator);

        int firstNum = Integer.parseInt(inputParts[0]);
        int secondNum = Integer.parseInt(inputParts[1]);

        if(operator.equals("\\+")) return firstNum+secondNum;
        if(operator.equals("-")) return firstNum-secondNum;

        return 0;
    }


}
