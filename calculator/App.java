package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int n1 = scanner.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = scanner.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            String input = scanner.next();
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            //input 문자열의 첫 번째 문자 (index 0)을 가져와서 operator라는 chat변수에 저장

            char operator = input.charAt(0);
            switch (input) {
                case "+":
                    System.out.println(n1 + n2);
                    break;
                case "-":
                    System.out.println(n1 - n2);
                    break;
                case "*":
                    System.out.println(n1 * n2);
                    break;
                case "/":
                    if (n2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                    } else {
                        System.out.println((double)n1 / n2);
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 입력입니다.");
                    continue;

            }
            //nextLine()입력시 무조건 else문이 출력되는 문제를 확인하였고, next()로 변경하니 의도대로 프로그램이 작동하였다.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = scanner.next();

            if (exit.equals("exit")) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }else {
                System.out.println("프로그램 종료를 취소하였습니다.");
            }

        }

    }
}
//while과 switch문을 같이 활용하여 중괄호로 코드블록을 묶는 것에 주의하였다. 실행결과를 확인해보면서 수정하였다.