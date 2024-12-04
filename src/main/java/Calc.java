public class Calc {
    public static int run(String input) {
        input = input.replace(" ","");
        if(input.contains("+")){
            return operation(input, "\\+");
        } else if (input.contains("-")) {
            return operation(input, "-");
        }
        return Integer.parseInt(input);
    }

    public static int operation(String input, String operator) {
        String[] inputParts = input.split(operator, 2);

        for(int i = 0 ; i < 2 ; i++){
            if(inputParts[i].contains("+") || inputParts[i].contains("-")){
                System.out.println("before : " + inputParts[i]);
                inputParts[i] = String.valueOf(run(inputParts[i]));
            }
            System.out.println("after : " + inputParts[i]);
        }

        int firstNum = Integer.parseInt(inputParts[0]);
        int secondNum = Integer.parseInt(inputParts[1]);

        if(operator.equals("\\+")) return firstNum+secondNum;
        if(operator.equals("-")) return firstNum-secondNum;

        return 0;
    }


}