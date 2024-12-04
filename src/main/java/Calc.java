public class Calc {
    public static int run(String input) {
        return simplePlusMinus(input);
    }

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