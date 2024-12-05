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
                input = bracketCal(input);
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

    // 괄호 처리 (괄호 안에서부터 처리)
    private static String bracketCal(String input) {
        int start = input.lastIndexOf('(');
        int end = input.indexOf(')', start);

        String inside = input.substring(start + 1, end);
        String evaluated = String.valueOf(run(inside));

        return input.substring(0, start) + evaluated + input.substring(end + 1);
    }

    // 기본 계산
    private static String operation(String input, String ops) {
        String[] parts = input.split(" ");
        StringBuilder result = new StringBuilder();
        boolean operationDone = false;   // 한번에 하나만 계산되도록

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(ops) && !operationDone) {
                int left = Integer.parseInt(parts[i - 1]);
                int right = Integer.parseInt(parts[i + 1]);

                result.setLength(result.length() - parts[i - 1].length() - 1);
                result.append(parts[i].equals("+") ? left + right : left * right);
                result.append(" ");
                i++;
                operationDone = true;
            } else {
                result.append(parts[i]).append(" ");
            }
        }
        return result.toString().strip();
    }
}