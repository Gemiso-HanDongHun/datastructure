package org.example.chap11;

// 정점 노드

public class Vertex { // 범용성을 높이려면 제네릭을 사용해서 <v, t> 이런식으로 id와 date에 각각 v, t를 형 지정을 해준다

    private int id; // 정점 고유 번호 (key)
    private String date; // 정점에 저장할 데이터

    private boolean visitFlag; // 정점 방문 여부

    public Vertex(String data) {
        this.date = data;
        this.id = -1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVisitFlag(boolean visitFlag) {
        this.visitFlag = visitFlag;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public boolean isVisitFlag() {
        return visitFlag;
    }
}
