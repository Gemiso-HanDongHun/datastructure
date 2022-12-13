package org.example.chap08.quick;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 오른쪽 피벗 선택 방식
     *
     * @param a         정렬할 배열
     * @param leftmost  현재 부분배열의 왼쪽
     * @param rightmost 현재 부분배열의 오른쪽
     */

    private static void quickSort(int[] a, int leftmost, int rightmost) {

        /*
         *  leftmost가 rightmost보다 크거나 같다면 정렬 할 원소가
         *  1개 이하이므로 정렬하지 않고 return한다.
         */
        if (leftmost >= rightmost) {
            return;
        }

        /*
         * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
         * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
         *
         * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
         * 분할 정복을 해준다.
         *
         */
        int pivot = partition(a, leftmost, rightmost);

        quickSort(a, leftmost, pivot - 1);
        quickSort(a, pivot + 1, rightmost);
    }

    /**
     * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
     *
     * @param a     정렬 할 배열
     * @param left  현재 배열의 가장 왼쪽 부분
     * @param right 현재 배열의 가장 오른쪽 부분
     * @return 최종적으로 위치한 피벗의 위치(start)를 반환
     */
    private static int partition(int[] a, int left, int right) {

        int start = left - 1;
        int end = right;
        int pivot = a[right];        // 부분리스트의 오른쪽 요소를 피벗으로 설정

        // start가 end보다 작을 때 까지만 반복한다.
        while (start < end) {

            /*
             * end가 start보다 크면서, start의 요소가 pivot보다 큰 원소를
             * 찾을 떄 까지 start를 증가시킨다.
             */
            while (a[++start] < pivot) ;

            /*
             * end가 start보다 크면서, end의 요소가 pivot보다 작거나 같은 원소를
             * 찾을 떄 까지 end를 감소시킨다.
             */
            while (start < end && a[--end] >= pivot) ;

            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
            swap(a, start, end);
        }

        /*
         *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[right])의 원소와
         *  end가 가리키는 원소를 바꾼다.
         */
        swap(a, right, end);

        // 두 요소가 교환되었다면 피벗이었던 요소는 end에 위치하므로 end를 반환한다.
        return end;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {1, 11, 88, 55, 99, 77, 66, 44, 22, 33};
        sort(arr);

        System.out.println("정렬 후: " + Arrays.toString(arr));

    }

}