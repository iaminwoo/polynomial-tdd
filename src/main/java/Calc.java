public class Calc {
    public static int run(String input) {
        System.out.println("Cal start!");
        System.out.println("mission : " + input);

        //빼기 계산을 음수 더하기로 처리
        input = input.replace("- ", "+ -");

        // while문으로 한번씩 계산
        // if문들로 계산 우선순위 설정
        while (true) {
            if(input.contains("(")){
                input = bracketOps(input);
            }else if (input.contains("*")) {
                input = operation(input, "*");
            } else if (input.contains("+")) {
                input = operation(input, "+");
            }else {
                break;
            }
        }

        int result = Integer.parseInt(input);
        System.out.println("result : " + result);
        return result;
    }

    private static String bracketOps(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int bracketEnd = 0;
        int bracketNum = 1;
        boolean inBracket = false;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(' && !inBracket){
                inBracket = true;
                continue;
            } else if (input.charAt(i) == '(') {
                bracketNum++;
            }

            if(inBracket){
                stringBuilder.append(input.charAt(i));
            }

            if(input.charAt(i) == ')'){
                if(bracketNum == 1){
                    inBracket = false;
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                    bracketEnd = i;
                }
                bracketNum--;
            }

        }

        String bracketResult = String.valueOf(run(stringBuilder.toString()));
        System.out.println(bracketResult);
        input = bracketResult + input.substring(bracketEnd+1);

        return input;
    }

    private static String operation(String input, String ops) {
        String[] parts = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        boolean oped = false;   // 한번에 하나만 계산되도록

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(ops) && !oped) {
                int numA = Integer.parseInt(parts[i - 1]);
                int numB = Integer.parseInt(parts[i + 1]);

                stringBuilder.delete(stringBuilder.length() - parts[i - 1].length() - 1, stringBuilder.length());
                switch (parts[i]) {
                    case "+":
                        stringBuilder.append(numA + numB);
                        break;
                    case "*":
                        stringBuilder.append(numA * numB);
                        break;
                    case "-":
                        stringBuilder.append(numA - numB);
                        break;
                }
                stringBuilder.append(" ");
                i++;
                oped = true;
            } else {
                stringBuilder.append(parts[i] + " ");
            }
        }
        return stringBuilder.toString().strip();
    }
}