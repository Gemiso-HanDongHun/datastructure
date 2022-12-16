package org.example.chap11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixTest {


    @Test

    void tts(){
        // 그래프 생성
        GraphMatrix gm = new GraphMatrix();

        // 정점 생성
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");

        // 정점을 그래프에 추가
        gm.addVertex(A);
        gm.addVertex(B);
        gm.addVertex(C);
        gm.addVertex(D);
        gm.addVertex(E);

        gm.showGraph();
        System.out.println("==========================================");

        // 정점들을 간선으로 연결
        gm.addEdge(A, B);
        gm.addEdge(B, E);
        gm.addEdge(E, D);
        gm.addEdge(B, C);

        // 그래프 출력
        gm.showGraph();
    }
}