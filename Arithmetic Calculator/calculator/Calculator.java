package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private int n1;
    private int n2;

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    private List<Integer> results = new ArrayList<>();

    public double calculate(int n1, int n2, char operator) {
        double result = 0;
        switch (operator) {
            case '+': //문자는 '', 문자열 ""
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                if (n2 == 0) { //소수점 셋째자리까지 출력
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                } else {
                    System.out.println((double) n1 / n2);
                }
                break;
            default:
                System.out.println("유효하지 않은 입력입니다.");
                return 0;
        } //원래 예외처리를 굉장히 간단히 작성하였는데 다른 사람들이 한 걸 참고하여 강화시키려함.
        //스택으로 처리하면 더 깔끔히 구현할 수 있었을 것 같다. 하필 메소드에 switch기능을 이용해서 더 난잡한 것 같음. 이런 메소드에 switch적용된 예제를 본적도 없다. 다른 사람들은 calculate메소드를 어떻게 구현했을지 가장 궁금함.
        results.add((int) result);
        System.out.println("계산결과: " + (int) result);
        return result;
    }

    public void removeResult(String input) {
        if(input.equals("esc")) {
            System.out.println("인덱스 결과를 삭제하지 않습니다.");
            return;
        }
        try {
            int index = Integer.parseInt(input); // 문자열을 정수로 변환

            if (index >= 0 && index < results.size()) {
                System.out.println(index + " 인덱스 결과를 삭제합니다: " + results.remove(index));
            }
        } catch (NumberFormatException e) { //숫자 이외 예외처리
            System.out.println("잘못된 입력입니다. 숫자 또는 'esc'를 입력하세요.");
        }
        System.out.println("삭제 후 계산결과: " + results);
    }


    public void AllResults() {
        if (results.isEmpty()) {
            System.out.println("계산 결과가 없습니다.");
        } else {
            System.out.println("모든 계산결과: " + results);
        }
    }

    public boolean confirmExit(Scanner sc) {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        String exit = sc.next();
        if (exit.equals("exit")) {
            System.out.println("프로그램이 종료되었습니다.");
            return true;
        } else {
            System.out.println("프로그램 종료를 취소하였습니다.");
            return false;
        }
    }
}


//Scanner을 매개변수로 받을 수 있다는 걸 알게되고 class에 종료플레그를 만들었음.
//개선점. 연산기호에 대한 예외를 던지는 것이 적절. 웬만해선 기능 main에 구현 X
