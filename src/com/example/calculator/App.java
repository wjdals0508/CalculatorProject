package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        while (true) {
            System.out.println("\n첫 번째 숫자를 입력하세요.");
            int firstNum = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요.");
            int secondNum = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요.");
            char operSymbol = sc.next().charAt(0);

            System.out.println("\n---------------------------------");
            System.out.println("결과 : " + cal.Calculate(firstNum, secondNum, operSymbol));
            System.out.println("---------------------------------");
            outResult(cal.getLastResults(cal.getHistoryNum()));
            System.out.println("---------------------------------");

            String functionScan;

            functionLoop:
            while(true) {
                System.out.println("\n무엇을 원하십니까?");
                System.out.println(" y  : 계속 계산하기");
                System.out.println(" h  : 연산 기록 보기");
                System.out.println(" r  : 가장 오래된 연산 기록 삭제");
                System.out.println(" ra : 모든 연산 기록 삭제");
                System.out.println(" x  : 계산기 종료");

                functionScan = sc.next();

                switch(functionScan) {
                    case "y":
                    case "x":
                        break functionLoop;

                    case "h":
                        System.out.println("---------------------------------");
                        outResult(cal.getLastResults(cal.getHistoryNum()));
                        System.out.println("---------------------------------");
                        break;

                    case "r":
                        cal.removeOldestResult();
                        System.out.println("**가장 오래된 연산 기록 삭제 완료**");
                        break;

                    case "ra":
                        cal.removeAllResult();
                        System.out.println("**모든 연산 기록 삭제 완료**");
                        break;
                }
/*
                if (functionScan.equals("y") || functionScan.equals("x")) break;
                else if (functionScan.equals("h")) {
                    System.out.println("---------------------------------");
                    outResult(cal.getLastResults(cal.getHistoryNum()));
                    System.out.println("---------------------------------");
                }
                else if (functionScan.equals("r")) {
                    cal.removeOldestResult();
                    System.out.println("**가장 오래된 연산 기록 삭제 완료**");
                }
                else if (functionScan.equals("ra")) {
                    cal.removeAllResult();
                    System.out.println("**모든 연산 기록 삭제 완료**");
                }
*/
            }

            if (functionScan.equals("x")) break;
        }
    }
    public static void outResult(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
