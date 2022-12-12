package org.example.chap05.queue;

class Node<E> {

    private E item;
    private Node<E> link;

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }
}

public class Queue<E> {

    private Node<E> front; // 맨 앞 노드를 감시
    private Node<E> rear; // 맨 뒤 노드를 감시

    public Queue() {
        front = new Node<>();
        rear = new Node<>();
    }

    // 큐가 비었는지 확인
    public boolean isEmpty() {
        return front.getLink() == null;
    }

    // 큐에 데이터 추가 (rear쪽으로)
    public void add(E item) {
        // 새 노드 생성
        Node<E> newNode = new Node<>();
        newNode.setItem(item); // 새 노드에 자료 저장

        // 링크 연결
        if (isEmpty()) { // 첫번째 노드가 저장되는 경우
            front.setLink(newNode);
            rear.setLink(newNode);
        } else { // 기존 노드에 연결되는 경우
            // 추가 되기 전 마지막 노드
            Node<E> lastNode = rear.getLink();
            lastNode.setLink(newNode);
            rear.setLink(newNode);
        }
    }

    // 큐에서 데이터 삭제 (front쪽)
    public E poll() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return null;
        } else {
            // 삭제 대상 가져오기
            Node<E> delTarget = front.getLink();

            // front가 삭제 대상 뒤에 있는 노드를 감시
            front.setLink(delTarget.getLink());

            return delTarget.getItem();
        }
    }
}

