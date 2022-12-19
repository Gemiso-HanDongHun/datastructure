package org.example.chap11;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// 인접 리스트 형식 그래프 구현
public class GraphList {

    // 정점들을 저장할 리스트
    private List<Vertex> vertices;

    // 그래프들의 연결관계를 저장할 인접 리스트
    private List<List<Vertex>> adjList;

    public GraphList(int a) {

        // 제너릭 자체가 List<> 형태이므로 무조건 List 형태로 들어와야 한다
        //  adjList.add(List<>);
    }

    public GraphList() {
        vertices = new LinkedList<>(); // 정점들이 저장될 1차원리스트
        adjList = new LinkedList<>(); // 정점의 관계들이 저장될 2차원리스트

    }

    // 정점 추가 메서드
    public void addVertex(Vertex v) {

        v.setId(vertices.size()); // 정점에 id부여
        vertices.add(v); // 정점을 정점리스트에 추가
        adjList.add(new LinkedList<>()); // 인접리스트에 1차원리스트 추가
    }

    // 간선 연결하기 (무방향 그래프)
    public void addEdge(Vertex departure, Vertex destination) {

        adjList.get(departure.getId()).add(destination);
        adjList.get(destination.getId()).add(departure);
    }

    // 인접 리스트 그래프 출력
    public void showGraph() {

        for (int i = 0; i < adjList.size(); i++) {
            System.out.printf("%s | ", vertices.get(i).getDate());
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.printf("%s ", adjList.get(i).get(j).getDate());
            }
            System.out.println();
        }
    }

    // 깊이 우선 탐색 - 스택 방식 구현
    public void DFS(Vertex start) {
        // 정점들을 저장할 스택
        Stack<Vertex> stack = new Stack<>();
        // 탐색 시작 정점을 스택에 저장
        stack.push(start);

        // 스택이 빌 때까지 DFS 반복 수행
        while (!stack.isEmpty()) {

            // 스택에서 정점을 꺼낸다.
            Vertex current = stack.pop();
            // 해당 정점에 방문표시
            current.setVisitFlag(true);
            // 방문한 정점의 데이터를 가져오기
            System.out.printf("%s ", current.getDate());

            // 해당 정점에 연결되어 있는 다른 정점들을 찾아서 모두 스택에 저장
            List<Vertex> list = adjList.get(current.getId());
            for (Vertex v : list) {
                // 방문한 적 없는 정점만 스택에 추가
                if (!v.isVisitFlag()) {
                    stack.push(v);
                }
            }
        }
        System.out.println();
    }


    // 깊이 우선 탐색 구현 - 재귀
    public void DFS2(Vertex current) {

        // 재귀 탈출 조건 - 이미 방문했으면 나오기
        if (current.isVisitFlag()) {
            System.out.println();
            return;
        }

        // 현재 정점에 방문처리
        current.setVisitFlag(true);
        // 현재 정점을 출력
        System.out.printf("%s ", current.getDate());

        // 현재 정점에 연결된 모든 정점을 가져오기
        List<Vertex> connectedVertices = adjList.get(current.getId());

        for (int i = connectedVertices.size() - 1; i >= 0; i--) {
            // 연결된 정점하나 가져오기
            Vertex v = connectedVertices.get(i);
            if (!v.isVisitFlag()) {
                DFS2(v); // 방문되지 않은 정점 재귀호출
            }
        }
    }

    // 너비 우선 탐색
    public void BFS(Vertex start) {
        // 너비우선 탐색에 필요한 큐 생성
        Queue<Vertex> queue = new LinkedList<>();

        // 탐색 시작 정점을 큐에 저장
        queue.offer(start);

        // 큐가 빌 때까지 BFS 반복 수행
        while (!queue.isEmpty()) {

            // 큐에서 정점을 꺼낸다.
            Vertex current = queue.poll();
            // 해당 정점에 방문표시
            current.setVisitFlag(true);
            // 방문한 정점의 데이터를 가져오기
            System.out.printf("%s ", current.getDate());

            // 해당 정점에 연결되어 있는 다른 정점들을 찾아서 모두 큐에 저장
            List<Vertex> list = adjList.get(current.getId());
            for (Vertex v : list) {
                // 방문한 적 없는 정점만 큐에 추가
                if (!v.isVisitFlag()) {
                    queue.offer(v);
                }
            }
        }
        System.out.println();
    }


/*
    // 그래프 인접 리스트 방식
    static List<List<Integer>> adjList = new LinkedList<>();
    // 방문 체크 배열
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수

        // 정점의 수만큼 인접리스트 내부에 1차원 리스트들을 추가
        for (int i = 0; i < N; i++) {
            adjList.add(new LinkedList<>());
        }
        // 정점 수만큼 방문체크 배열 초기화
        visited = new boolean[N];

        // 간선들을 연결하여 인접리스트에 연결정보 추가하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점
            int e = Integer.parseInt(st.nextToken()); // 끝점

            // 무방향 그래프이므로 양쪽에 모두 연결정보를 추가한다
            adjList.get(s-1).add(e);
            adjList.get(e-1).add(s);
        }

        // DFS를 수행하여 성공한 횟수를 기록하여 출력
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 정점만 DFS 수행
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    // DFS 함수
    private static void DFS(int current) {

        if (visited[current]) return;

        // 현재 정점을 방문체크
        visited[current] = true;

        List<Integer> connectedList = adjList.get(current);
        for (Integer n : connectedList) {
            if (!visited[n - 1]) DFS(n - 1);
        }

    }
   */


}
