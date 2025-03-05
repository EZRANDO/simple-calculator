package calculator;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("더하기", (a, b) -> a + b),
    MINUS("빼기", (a, b) -> a - b),
    MULTIPLY("곱하기", (a, b) -> a * b),
    DIVIDE("나누기", (a, b) -> a / b);

    private String operator;
    private BiFunction<Double, Double, Double> action;

    OperatorType(String operator, BiFunction<Double, Double, Double> action) {
        this.operator = operator;
        this.action = action;
    }

    // 연산을 수행하는 메서드
    public double select(double a, double b) {
        return action.apply(a, b);
    }

    public String getOperator() {
        return operator;
    }

    public static class ArithmeticCalculator {

        // 제네릭 메서드
        public <T extends Number> double calculate(T a, T b, OperatorType operator) {
            // OperatorType의 select 메서드는 double 타입을 반환하므로, 제네릭을 사용하더라도 double로 처리해야 함
            return operator.select(a.doubleValue(), b.doubleValue());
        }

        public static void main(String[] args) {
            ArithmeticCalculator calculator = new ArithmeticCalculator();

            // Double 타입 계산기
            double num1 = 10.5;
            double num2 = 5.5;

            double sum = calculator.calculate(num1, num2, OperatorType.PLUS);
            double diff = calculator.calculate(num1, num2, OperatorType.MINUS);
            double product = calculator.calculate(num1, num2, OperatorType.MULTIPLY);
            double quotient = calculator.calculate(num1, num2, OperatorType.DIVIDE);

            System.out.println("덧셈: " + sum);
            System.out.println("뺄셈: " + diff);
            System.out.println("곱셈: " + product);
            System.out.println("나눗셈: " + quotient);
        }
    }
}
