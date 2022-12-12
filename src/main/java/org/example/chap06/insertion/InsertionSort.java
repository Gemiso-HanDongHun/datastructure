package org.example.chap06.insertion;

// 삽입 정렬

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {

        // [6, 3, 15, 7, 2]
        // 2번째 데이터부터 타겟팅해서 시작
        for (int i = 1; i < arr.length; i++) {

            // 타겟 데이터 백업
            int target = arr[i];
            int temp = arr[i]; // 첫번째 루프에서는 temp가 3이 된다( 2번째 데이터부터 타겟팅 하므로)
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {

                // 타겟의 왼쪽데이터가 타겟보다 크면
                // 왼쪽데이터를 우측으로 한 칸 이동
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target; // 찾은 위치에 타겟 데이터 삽입
        }
    }

    public static void main(String[] args) {
        
        int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

        sort(arr); // 삽입정렬

        System.out.println("정렬 후: " + Arrays.toString(arr));

    }
}
