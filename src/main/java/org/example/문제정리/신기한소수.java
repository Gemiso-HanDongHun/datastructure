package org.example.문제정리;

// 백준 https://www.acmicpc.net/problem/2023

import java.util.Scanner;

public class 신기한소수 {

    /*
     1. 소수는 약수가 1과 자기 자신인 수를 말합니다. 예를 들어 4는 약수가 1, 2, 4이므로 소수가 아니고
        7은 약수가 1과 7이므로 소수입니다.

     2. 우선 자리수가 1개인 소수는 2, 3, 5, 7이고
        자리수가 2개인 소수는 11, 13, 17, 19, 23, 29, 31, 37, 41, 43 ...
        자리수가 3개인 소수는 101, 103, 107, 109, 113, 127, 131 ....
        즉 , 소수는 자리수가 늘어날 때마다 1의 자리수가 홀수라는 규칙이 있습니다.

      3. 그러면 신기한 소수를 만들려면 우선은 1의 자리 소수부터 출발하여
         자리수를 늘려가며 매칭하면서 2자리수를 만들어 해당수가 소수인지 확인하고
         맞으면 자리수를 또 늘려서 해당수가 소수인지 확인하는 깊이 우선탐색을 실행합니다.
         총 4자리까지 수행한 결과 소수라면 해당 수는 신기한 소수로 판단하는 방식입니다.

      4. 예를들면  1의 자리 소수 2부터 출발해서 뒤에 홀수를 붙여봅니다.
         우선 21은 소수가 아니므로 DFS를 종료하고 23은 소수이므로 DFS를 더 진행합니다.
         231은 소수가 아니므로 DFS를 종료하고 233은 소수이므로 DFS를 더 진행합니다.
         2331은 소수가 아니므로 DFS를 종료하고 2333은 소수이므로 출력합니다.
         2335, 2337은 소수가 아니므로 DFS를 종료하고 2339는 소수이므로 출력합니다.

      5. 이런식으로 DFS 재귀레벨이 4가 될때가지 DFS를 반복합니다.


         2    1    1    1
         3    3    3    3
         5    5    5    5
         7    7    7    7
              9    9    9

 */

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }

    /**
     * DFS 메서드
     *
     * @param number - 소수 판별할 숫자
     * @param level  - 재귀 깊이 레벨
     */
    static void DFS(int number, int level) {

        if (level == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        // 자리수가 올라갈수록 홀수들만 뒤에 이어붙여서 DFS 반복 수행
        for (int i = 1; i < 10; i += 2) {
            int newNumber = number * 10 + i; // 자리수 증가
            if (isPrime(newNumber)) { // 소수면 DFS 추가진행
                DFS(newNumber, level + 1);
            }
        }
    }


    // 어떤 숫자가 소수인지 판별하는 메서드
    static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
