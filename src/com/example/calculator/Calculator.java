package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    // 캡슐화
    private ArrayList<String> results = new ArrayList<>();
    private int historyNum = 3;

    public String Calculate(int firstNum, int secondNum, char operSymbol) {

        int answer;
        String result;

        // 더하기
        if (operSymbol == '+') {
            answer = firstNum + secondNum;
            result = firstNum + " + " + secondNum + " = " + answer;
        }

        // 빼기
        else if (operSymbol == '-') {
            answer = firstNum - secondNum;
            result = firstNum + " - " + secondNum + " = " + answer;
        }

        // 곱하기
        else if (operSymbol == '*') {
            answer = firstNum * secondNum;
            result = firstNum + " * " + secondNum + " = " + answer;
        }

        // 나누기
        else if (operSymbol == '/') {
            if (secondNum == 0) {
                return "0으로 나눌 수 없습니다.";
            }
            answer = firstNum / secondNum;
            result = firstNum + " / " + secondNum + " = " + answer;
        }

        // 유효하지 않은 사칙연산
        else {
            return "유효하지 않은 사칙연산 입니다.";
        }

        results.add(result);

        return Integer.toString(answer);
    }

    public ArrayList<String> getLastResults(int n) {

        ArrayList<String> newResults = new ArrayList<>();
        int newSize = Math.min(results.size(), n);

        for (int i = 0; i < newSize; i++) {
            newResults.add(results.get(results.size() - i - 1));
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
        results.remove(0);
    }

    // 모든 연산 기록 삭제
    public void removeAllResult() {
        results.clear();
    }

}
