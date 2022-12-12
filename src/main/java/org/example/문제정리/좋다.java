package org.example.문제정리;

import java.util.Arrays;
import java.util.Scanner;

// 백준 https://www.acmicpc.net/problem/1253
public class 좋다 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 10; // 수의 개수
        int count = 0; // 좋은 수의 개수

        // 수를 담을 배열
        long[] A = {-3, -5, 1, 15, 4, 0, 7, 9, -2, 3};
//        long[] A = new long[N];

        // 배열 초기화
//        for (int i = 0; i < N; i++) {
//            A[i] = sc.nextLong();
//        }
        sc.close();

        // 배열 정렬
        Arrays.sort(A);

        System.out.println(Arrays.toString(A));

        // 모든 수를 순회하여 좋은 수인지 판단
        // 좋은 수 판단을 위한 숫자 타겟팅
        for (int i = 0; i < A.length; i++) {
            long target = A[i]; // 좋은 수 판단 타겟 숫자

            // 투 포인터 초기화
            int start = 0, end = N - 1;

            // 투포인터 알고리즘
            while (start < end) {
                // 포인터가 지목한 두수를 더함
                long M = A[start] + A[end];
                if (target == M) {
                    // 일단은 좋은 수인데 혹시 타겟을 포함해서 더한건 아닌지 확인
                    if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    } else {
                        count++;
                        break;
                    }

                } else if (M < target) { // 두 수의 합이 타겟보다 작으면
                    start++;
                } else {
                    end--;
                }
            }
        }
    }
}
