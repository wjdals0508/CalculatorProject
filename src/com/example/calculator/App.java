package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator aCal = new ArithmeticCalculator();

        while (true) {
            String functionScan;

            // 계산기 추가 기능
            functionLoop:
            while(true) {
                System.out.println("\n무엇을 원하십니까?");
                System.out.println(" c  : 계산하기");
                System.out.println(" h  : 연산 기록 보기");
                System.out.println(" s  : 결과값 찾기");
                System.out.println(" r  : 가장 오래된 연산 기록 삭제");
                System.out.println(" ra : 모든 연산 기록 삭제");
                System.out.println(" x  : 계산기 종료");

                functionScan = sc.next();

                switch(functionScan) {
                    case "c":
                    case "x":
                        break functionLoop;

                    case "h":
                        outResult(aCal.getLastResults(aCal.getHistoryNum()));
                        break;

                    case "r":
                        aCal.removeOldestResult();
                        System.out.println("**가장 오래된 연산 기록 삭제 완료**");
                        break;

                    case "ra":
                        aCal.removeAllResult();
                        System.out.println("**모든 연산 기록 삭제 완료**");
                        break;

                    case "s":
                        System.out.println("**입력받은 값보다 큰 결과값들을 출력 합니다**");
                        Number searchNum = parseScanToNumber(sc.next());

                        System.out.println("입력 받은 값 : " + searchNum);
                        outResult((ArrayList<String>) aCal.searchResult(searchNum));
                        break;
                }
            }

            // 계산기 종료
            if (functionScan.equals("x")) break;

            System.out.println("\n첫 번째 숫자를 입력하세요.");
            Number firstNum = parseScanToNumber(sc.next());

            System.out.println("두 번째 숫자를 입력하세요.");
            Number secondNum = parseScanToNumber(sc.next());

            System.out.println("사칙연산 기호를 입력하세요.");
            char operSymbol = sc.next().charAt(0);

            System.out.println("결과 : " + aCal.Calculate(firstNum, secondNum, operSymbol));
            outResult(aCal.getLastResults(aCal.getHistoryNum()));
        }
    }

    // 계산 히스토리 출력
    public static void outResult(ArrayList<String> list) {
        System.out.println("---------------------------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("---------------------------------");
    }

    // 입력 받은 숫자 String을 Double이나 Int로 변경
    public static Number parseScanToNumber(String number){
        if(number.contains(".")){
            return Double.parseDouble(number);
        } else {
            return Integer.parseInt(number);
        }
    }
}
