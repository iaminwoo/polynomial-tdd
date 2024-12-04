public class Calc {
    public static int run(String input) {
        int result;

        if(input.contains("*")){
            result = multiply(input);
        }else{
            result = simplePlusMinus(input);
        }

        return result;
    }

    private static int multiply(String input) {
        input = input.replace(" ","");

        String[] parts = input.split("\\*");

        int first = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);


        return (first * sec);
    }

    // 각 부호별로 분리해서 더함
    // 예를들어 "10 - 10 - 10" -> [10, -10, -10]으로
    public static int simplePlusMinus(String input) {
        input = input.replace(" ","");

        String[] numbers = input.split("[+-]");
        String[] ops = input.split("\\d+");
        int[] numToOps = new int[numbers.length];

        for(int i = 0 ; i < numbers.length ; i++){
            numToOps[i] = Integer.parseInt(ops[i] + numbers[i]);
        }

        int result = 0;
        for(int num : numToOps){
            result += num;
        }

        return result;
    }
}