package org.example.문제정리;

import java.util.Scanner;
import java.util.Stack;

// 백준 https://www.acmicpc.net/problem/11047

public class 그리디01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //동전의 개수
        int K = sc.nextInt(); //목표 액수

        //동전을 담을 자료구조
        Stack<Integer> A = new Stack<>();
        for (int i = 0; i < N; i++) {
            A.push(sc.nextInt());
        }
        sc.close();

        int count = 0; // 동전의 수
        while (!A.isEmpty()) {
            int coinAmt = A.pop(); // 꼭대기 동전부터 추출
            if (coinAmt <= K) {
                count += (K / coinAmt); // 동전 개수 누적
                K %= coinAmt; // 잔액 갱신
            }

            if (K == 0) break;
        }
        System.out.println(count);
    }

}
