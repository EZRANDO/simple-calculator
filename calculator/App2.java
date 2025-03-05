package calculator;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* Calculator 인스턴스 생성 */
        Calculator calc = new Calculator();

        /* 반복문 시작 */
        //계산 반복을 위해 무한 루프를 해야된다는 것을 모르고있었음. 어떻게 입력받은 숫자와 연산자가 Calculator클래스의 연산 메서드를 실행하게 만들 수있을지 고민함.
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            calc.calculate(num1, num2, operator);
            calc.AllResults();

            System.out.print("삭제할 계산결과의 인덱스를 입력하세요. 취소하려면 esc를 누르세요.");
            sc.nextLine();
            String input = sc.nextLine(); // nextInt() 사용으로 문제 해결

            calc.removeResult(input);


            if (calc.confirmExit(sc)) {
                break;

            }

        }
    }
}