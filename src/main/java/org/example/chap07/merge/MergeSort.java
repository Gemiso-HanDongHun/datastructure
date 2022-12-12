package org.example.chap07.merge;

import java.util.Arrays;

public class MergeSort {

    // 병합 작업에 쓰일 임시 배열(divide 즉, 잘라낸것을 담아내는 임시 배열)
    private static int[] temp;

    // 병합 정렬 알고리즘

    // @parma : 변수를 설명할 때 사용하는 어노테이션

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
                arr[insertSpot++] = temp[p2++];
            }
        }

        /*
           오른쪽 부분배열이 먼저 소모된 경우에는,
           왼쪽 부분배열은 아직 데이터가 남아있기 때문에
           마저 뽑아서 원본배열에 순서대로 채워야 한다.
         */
        while (p1 <= m) {   // p1이 남아있으면
            arr[insertSpot++] = temp[p1++];  // p1에 남은 것을 순서대로 꽂는다
        }
        while (p2 <= e) {
            arr[insertSpot++] = temp[p2++];
        }

    }

    public static void sort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

        sort(arr); // 병합 정렬

        System.out.println("정렬 후: " + Arrays.toString(arr));

    }

}
