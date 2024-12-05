public class Calc {
    public static int run(String input) {
        System.out.println("Cal start!");

        input = input.replace("- ", "+ -");
        System.out.println("mission : " + input);

        while (true) {
            // if문들로 계산 우선순위 설정
            if (input.contains("*")) {
                input = operation(input, "*");
            } else if (input.contains("+")) {
                input = operation(input, "+");
            } else if (input.contains("-") && !input.matches("-?\\d+")) {
                input = operation(input, "-");
            } else {
                break;
            }
        }

        int result = Integer.parseInt(input);
        System.out.println("result : " + result);
        return result;
    }

    private static String operation(String input, String ops) {
        String[] parts = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        boolean oped = false;

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