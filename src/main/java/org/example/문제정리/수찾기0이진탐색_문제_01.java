package org.example.문제정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 https://www.acmicpc.net/problem/1920

public class 수찾기0이진탐색_문제_01 {

    public static int binarySearch(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {

            // mid 인덱스값 계산
            mid = (left + right) / 2;

            if (target == arr[mid]) { // 찾고자 하는 값이 mid값과 일치할 경우 탐색 종료
                return mid;
            }

            if (target < arr[mid]) { // 찾고자 하는 값이 mid값보다 작을 경우
                right = mid - 1;
            } else { // 찾고자 하는 값이 mid값보다 클 경우
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            long target = Long.parseLong(st.nextToken());
            if (binarySearch(A, target) != -1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}