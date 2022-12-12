package org.example.문제정리;

/*


A   3 5 2 7
S   5 7 7

1:  A[0] < A[1] -  S[0] = A[1]
2:  A[1] > A[2] -  1번인덱스 스킵
3:  A[2] < A[3] -  S[2] = A[3]
    A[1] < A[3] -  S[1] = A[3]


A   9 5 4 8
S  -1 8 8 -1

1: A[0] > A[1]  - 0번 스킵
2: A[1] > A[2]  - 1번 스킵
3: A[2] < A[3]  - S[2] = A[3]
   A[1] < A[3]  - S[1] = A[3]
   A[0] > A[3]  - 0번 스킵


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 17298
public class 스택_오큰수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N]; // 수열 배열
        int[] S = new int[N]; // 정답 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 오큰수를 처리할 인덱스를 저장할 스택
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 처음에는 0번 인덱스를 스택에 추가하고 시작

        // 3 5 2 7    ||
        // 9 5 4 8    ||
        for (int i = 1; i < N; i++) {

            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                S[stack.pop()] = A[i]; // 정답 배열에 오큰수를 저장
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            S[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : S) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);


    }
}
