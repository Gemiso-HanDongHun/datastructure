package org.example.chap11;

import java.util.LinkedList;
import java.util.List;

// 인접 리스트 형식 그래프 구현
public class GraphList {

    // 정점들을 저장할 리스트
    private List<Vertex> vertices;

    // 그래프들의 연결관계를 저장할 인접 리스트
    private List<List<Vertex>> adjList;

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
}
