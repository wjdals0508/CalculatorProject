package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n첫 번째 숫자를 입력하세요.");
            int firstNum = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요.");
            int secondNum = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요.");
            char operSymbol = sc.next().charAt(0);

            if (operSymbol == '+') {
                int answer = firstNum + secondNum;
                System.out.println(firstNum + " + " + secondNum + " = " + answer);
            }
            else if (operSymbol == '-') {
                int answer = firstNum - secondNum;
                System.out.println(firstNum + " - " + secondNum + " = " + answer);
            }
            else if (operSymbol == '*') {
                int answer = firstNum * secondNum;
                System.out.println(firstNum + " * " + secondNum + " = " + answer);
            }
            else if (operSymbol == '/') {
                if (secondNum == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }

                int answer = firstNum / secondNum;
                System.out.println(firstNum + " / " + secondNum + " = " + answer);
            }
            else {
                System.out.println("유효하지 않은 사칙연산 기호입니다.");
            }

            System.out.println("더 계산 하시겠습니까? (exit 입력 시 종료)");
            String isContinue = sc.next();

            if (isContinue.equals("exit")) break;
        }
    }
}
