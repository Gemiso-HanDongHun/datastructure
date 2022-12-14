package org.example.문제정리;

// 백준 https://www.acmicpc.net/problem/1541

import java.util.Arrays;
import java.util.StringTokenizer;

public class 그리디02 {

    public static void main(String[] args) {

        // 문자열 분리 함수
        // split, StringTokenizer

        // split
//        String[] sArr = str.split("-");     // - 를 기준으로 스플릿하라는 뜻 (즉, 괄호친 효과랑 같음)
//        System.out.println(Arrays.toString(sArr));

        // StringTokenizer
        String str = "100-40+50+74-30+29-45+43+11";
        StringTokenizer st = new StringTokenizer(str, "-");

        int answer = 0; // 연산결과 저장
        for (int i = 0; st.hasMoreTokens(); i++) { // 토큰이 있는 동안에
            String s = st.nextToken();
            int sum = makeSum(s);  // Alt + Enter
            if (i == 0) {
                answer += sum;
            } else {
                answer -= sum;
            }
            System.out.println(s);
        }

//        String[] sArr2 = sArr[1].split("+");
//        System.out.println(Arrays.toString(sArr2));

    }

    // 토큰문자열 (ex : 50+20+30)을 받아서 총합을 구해주는 메서드
    private static int makeSum(String s) {
        int total = 0;
        StringTokenizer st = new StringTokenizer(s, "+");
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }

        return total;
    }

}