package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    // enum 매핑
    public enum OperatorType {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private String string;

        OperatorType(String string) {
            this.string = string;
        }

        public char getChar() {
            return string.charAt(0);
        }
    }

    // 캡슐화
    private ArrayList<String> resultStrings = new ArrayList<>(); // 연산 식 모두 기록
    private int historyNum = 5;

    public <T extends Number> String Calculate(T firstNum, T secondNum, char operSymbol) {

        double answer;

        // 더하기
        if (operSymbol == OperatorType.ADD.getChar()) {
            answer = firstNum.doubleValue() + secondNum.doubleValue();
        }

        // 빼기
        else if (operSymbol == OperatorType.SUBTRACT.getChar()) {
            answer = firstNum.doubleValue() - secondNum.doubleValue();
        }

        // 곱하기
        else if (operSymbol == OperatorType.MULTIPLY.getChar()) {
            answer = firstNum.doubleValue() * secondNum.doubleValue();
        }

        // 나누기
        else if (operSymbol == OperatorType.DIVIDE.getChar()) {
            if (secondNum.doubleValue() == 0) {
                return "0으로 나눌 수 없습니다.";
            }
            answer = firstNum.doubleValue() / secondNum.doubleValue();
        }

        // 유효하지 않은 사칙연산
        else {
            return "유효하지 않은 사칙연산 입니다.";
        }

        resultStrings.add(firstNum + " " + operSymbol + " " + secondNum + " = " + answer);

        return Double.toString(answer);
    }

    public ArrayList<String> getLastResults(int n) {

        ArrayList<String> newResults = new ArrayList<>();

        for (int i = 0; i < Math.min(resultStrings.size(), n); i++) {
            newResults.add(resultStrings.get(resultStrings.size() - i - 1));
        }

        return newResults;
    }

    // Getter
    public int getHistoryNum() {
        return historyNum;
    }

    // Setter
    public void setHistoryNum(int n) {
        this.historyNum = n;
    }

    // 가장 오래된 연산 기록 삭제
    public void removeOldestResult() {
        resultStrings.remove(0);
    }

    // 모든 연산 기록 삭제
    public void removeAllResult() {
        resultStrings.clear();
    }

    // 입력 받은 값보다 큰 결과 값 조회
    public <T extends Number> List<String> searchResult(T searchNum) {

        return resultStrings.stream()
                .filter(num -> Double.parseDouble(num.split(" = ")[1]) > searchNum.doubleValue())
                .collect(Collectors.toList());
    }

}
