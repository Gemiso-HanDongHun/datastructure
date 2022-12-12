package org.example.문제정리;

import java.lang.reflect.Array;
import java.util.Arrays;

// 백준 https://www.acmicpc.net/problem/1517

/*
     p1                p2
       |                 |
       0   1   2   3     4  5   6   7
   temp  [ 24, 32, 42, 60 ] [ 5, 15, 45, 90 ]

   arr   [  5 ]
            |
        insertSpot

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

public class 버블소트 {

    public static void main(String[] args) {

    }

}
