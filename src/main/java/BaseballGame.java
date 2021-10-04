import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        String answer = randomNumber();
        String input = "";
        int continueFlag = 1;

        Scanner scanner = new Scanner(System.in);

        while (continueFlag == 1) {
            System.out.println(">>>>> 숫자를 입력해 주세요 :");
            input = scanner.nextLine();

            char[] ans = answer.toCharArray();
            char[] in = input.toCharArray();

            int strikeCnt=0, ballCnt=0;

            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < ans.length; j++) {
                    if(in[i] == ans[j]) {
                        if(i == j) strikeCnt++;
                        else ballCnt++;
                    }
                }
            }

            if(strikeCnt == 3) {
                System.out.println(">>>>> 3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println(">>>>> 정답입니다.! => 답: " + answer + ", 입력값: " + input);
                System.out.println(">>>>> 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                continueFlag = scanner.nextInt();

                if(continueFlag == 1) answer = randomNumber();
            } else {
                if(strikeCnt == 0 && ballCnt ==0) {
                    System.out.println(">>>>> 낫싱");
                } else {
                    String disRes = "";
                    if(ballCnt != 0) disRes = ballCnt + "볼 ";
                    if(strikeCnt != 0) disRes = strikeCnt + "스트라이크";

                    System.out.println(disRes);
                    System.out.println(">>>>> 정답 => 답: " + answer + ", 입력값: " + input);
                }
            }
        }
    }

    public static String randomNumber() {
        Random random = new Random();

        String answer = "";

        for (int i = 0; i < 3; i++) {
            String ranStr = "";

            while (true) {
                ranStr = String.valueOf(random.nextInt(9));

                if(!answer.contains(ranStr)) break;
            }

            answer += ranStr;
        }

        System.out.println(">>>>> 정답 => 답: " + answer);

        return answer;
    }

}


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(">>>>> 연산 입력:");
//        String input = scanner.nextLine();
//
//        String[] values = input.split(" ");
//
//        int res = Integer.parseInt(values[0]);
//        for (int i = 1; i < values.length; i++) {
//            if(isDigit(values[i])) {
//                int num = Integer.parseInt(values[i]);
//
//                if(values[i-1].equals("+")) res += num;
//                else if(values[i-1].equals("-")) res -= num;
//                else if(values[i-1].equals("*")) res *= num;
//                else if(values[i-1].equals("/")) res /= num;
//            }
//            System.out.println(">>>>> " + i + " values[" + i + "]:" + values[i] + ", 합: " + res);
//        }
//
//        System.out.println(">>>>> 합: " + res);
//    }

//    public static boolean isDigit(String str) {
//
//        try {
//            int res = Integer.parseInt(str);
//
//            return true;
//        }
//        catch (Exception e) {
//            return false;
//        }
//    }
