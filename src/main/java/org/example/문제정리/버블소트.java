package org.example.문제정리;

/*
           p1                        p2
           |                         |
           0   1   2   3      4  5   6   7
   temp  [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

   arr   [  5  15    ]
                   |
              insertSpot  2

    - 병합 과정에서 뒤쪽 배열의 값이 작은경우 5의 값이
       4번인덱스에서 0번으로 이동하므로
       버블정렬에서 4번 스왑이 일어났다고 볼 수 있음

                             |  |
       0   1   2   3     4   5  6   7
    [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

    [  5, 15, 24, 32  , 42, 45 ]

    - 병합 과정에서 뒤쪽 배열의 값이 작은경우 45의 값이 6번인덱스에서 5번으로 이동하므로
      버블정렬에서 1번 스왑이 일어났다고 볼 수 있음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트 {

    private static int[] temp; // 병합 작업에 쓸 임시 배열
    private static long count; // swap 횟수 누적

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        sort(A);

        System.out.println(count);

    }

    // 병합 정렬 알고리즘

    /**
     * @param arr - 분할 할 배열
     * @param s   - 분할 시작 위치
     * @param e   - 분할 끝 위치
     */
    private static void mergeSort(int[] arr, int s, int e) {

        // 분할한 배열의 원소가 1개 이하면 return
        if (e - s < 1) return; // 재귀함수 종료 조건

        // 분할의 중앙점을 찾아야 함
        int m = (s + e) / 2;

        // 분할 작업
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        // 병합 작업

        // 부분 배열을 임시 배열에 저장
        for (int i = s; i <= e; i++) {
            temp[i] = arr[i];
        }

        // 포인터 2개 선언
        int p1 = s;
        int p2 = m + 1;

        // 포인터끼리 비교한 후 원본배열에 넣어야 할 위치를 지정
        int insertSpot = s;

        // 병합 루프
        while (p1 <= m && p2 <= e) {
            if (temp[p1] < temp[p2]) {
                arr[insertSpot++] = temp[p1++];
            } else {
                count += (p2 - insertSpot);
                arr[insertSpot++] = temp[p2++];
            }
        }

        /*
           오른쪽 부분배열이 먼저 소모된 경우에는,
           왼쪽 부분배열은 아직 데이터가 남아있기 때문에
           마저 뽑아서 원본배열에 순서대로 채워야 한다.
         */
        while (p1 <= m) {
            arr[insertSpot++] = temp[p1++];
        }
        while (p2 <= e) {
            arr[insertSpot++] = temp[p2++];
        }

    }

    public static void sort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }
}
