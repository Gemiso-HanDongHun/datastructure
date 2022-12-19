package org.example.문제정리;

// 백준 https://www.acmicpc.net/problem/13023

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ABCDE {

    /*
  1. 문제에서 요구하는 관계는 A, B, C, D, E 순서로 친구관계가 연결되는지 묻고 있으므로
     DFS를 수행했을 때 재귀가 5번 이상 들어간적이 있다면 해당 관계를 만족하는것이 됩니다.
  2. 따라서 인접리스트로 그래프를 구성한 후 DFS를 수행합니다.

   ex) 첫번째 입출력 예시
    0  ->  4
    1  ->  7
    2  ->  7
    3  ->  7, 4, 5
    4  ->  7, 3, 6, 0
    5  ->  3
    6  ->  4
    7  ->  1, 3, 4, 2

   3. DFS 수행시

      재귀 1   ->   재귀 2   ->   재귀 3   ->   재귀 4   ->   재귀 5

        0             4             7             1             7 (이미 방문했으므로 재귀 종료)
        ----------------------------------------------------------------------------------------
                                                  3             7 (이미 방문했으므로 재귀 종료)
                                                                4 (이미 방문했으므로 재귀 종료)
                                                              * 5 (재귀가 더 진행되므로 관계를 만족하므로 1리턴 후 재귀 종료)
        ----------------------------------------------------------------------------------------
                                                  4  (이미 방문했으므로 재귀 종료)
        ----------------------------------------------------------------------------------------
                                                  2             7  (이미 방문했으므로 재귀 종료)
                                    3
                                    6
                                    0 (이미 방문했으므로 재귀 종료)

    4. 모든 노드를 돌아도 1이 리턴되지 않았다면 0을 리턴하고 종료
 */


    static List<List<Integer>> adjList = new LinkedList<>(); // 그래프 인접 리스트
    static boolean[] visited;  // 방문 배열

    static boolean arrive; // 재귀 5레벨 이상 도착했는지 여부

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //  정점 수
        int M = sc.nextInt(); //  간선 수

        // 정점 수만큼 인접 리스트 초기화
        for (int i = 0; i < N; i++) {
            adjList.add(new LinkedList<>());
        }
        // 정점 수만큼 방문 배열 초기화
        visited = new boolean[N];

        // 간선 수만큼 인접 리스트에 연결정보 추가
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt(); // 시작점
            int e = sc.nextInt(); // 끝점
            // 단, 무방향 그래프이므로 양쪽 다 추가한다.
            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }

        // 모든 정점 노드를 돌면서 DFS 수행
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive) break; // 5벨에 도달하면 DFS 종료
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static void DFS(int num, int level) {
        // 재귀가 5레벨에 도달하면 재귀 종료
        if (level == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[num] = true; // 방문처리

        List<Integer> connectedList = adjList.get(num);
        for (Integer n : connectedList) {
            if (!visited[n]) {
                DFS(n, level + 1); // 재귀 레벨을 늘려가며 DFS 수행
            }
        }
        visited[num] = false; // 재귀 전 단계로 복귀시에 방문기록을 리셋
    }

}
