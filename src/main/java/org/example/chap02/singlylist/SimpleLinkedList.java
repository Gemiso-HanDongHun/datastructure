package org.example.chap02.singlylist;

// 감시노드 - 첫번째 노드나 마지막 노드를 기억하는 노드
class SentinelNode<E> {

    private Node<E> firstNode;

    // 빈 리스트 인지 확인하는 메서드
    public boolean isEmpty() {
        return firstNode == null;
    }

    public void setFirstNode(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

}

// 일반노드 - 저장할 값과 다른 일반 노드를 기억하는 노드
class Node<E> {
// E는 element(요소) 어떤 문자나 써도 된다

    // 저장할 값
    private E data;
    // 제너릭을 E(꼭 E라고 하지 않아도 되고 asdffs 처럼 아무 문자나 지정가능) 라고 하는 이유는
    // 현재 object나 String 처럼 미리 타입을 지정하지 않고 변수를 선언할 때 지정하겠다는 의미이다

    // 내 다음 노드의 주소를 기억
    private Node<E> nextNode;

    // 노드가 생성될 때 저장할 값을 같이 기억
    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

}

// 단방향 단순 연결 리스트
public class SimpleLinkedList<E> {

    // 연결 리스트는 언제나 감시노드를 가지고 있어야 한다.
    private SentinelNode<E> header;

    private int size; // 총 저장 개수

    // 생성자
    // 리스트 생성시 감시노드도 같이 만들어저야 함
    public SimpleLinkedList() {
        this.header = new SentinelNode<>();
    }

    // 리스트의 맨 앞에 데이터를 추가하는 기능
    public void addFirst(E data) {

        // 새롭게 추가할 데이터를 신규 노드에 저장
        Node<E> newNode = new Node<>(data);
        System.out.printf("\n새롭게 추가될 노드 주소: %s\n", newNode);

        // 감시노드한테 연락해서 기존의 첫번째 노드의 주소를 받아옴
        Node<E> oldFirstNode = header.getFirstNode();
        System.out.printf("\n감시노드가 원래 감시하던 주소: %s\n", oldFirstNode);

        // 새롭게 첫번째노드가 될 녀석에게 기존 첫번째의 주소를 기억하게 함.
        newNode.setNextNode(oldFirstNode);
        System.out.printf("\n새로운 노드가 감시할 다음 주소: %s\n", newNode.getNextNode());

        // 감시노드한테 새로운 노드를 감시하게 함.
        header.setFirstNode(newNode);
        System.out.printf("\ng감시노드가 새롭게 감시할 다음 주소: %s\n", header.getFirstNode());

        size++;
    }

    // 맨 첫번째 데이터 삭제
    public Node<E> removeFirst() {

        // 빈 리스트가 아닐경우
        if (!header.isEmpty()) {

            // 삭제 대상 노드를 키핑
            Node<E> targetNode = header.getFirstNode();

            // 삭제 대상 노드의 다음 노드 주소 가져오기
            Node<E> nextNode = targetNode.getNextNode();

            // 감시 노드가 새로운 노드의 주소를 기억
            header.setFirstNode(nextNode);   // 즉, 여기서 첫번째 노드가 죽으니 자연스럽게 두번째 노드를 반환하게 된다

            size--;
            return targetNode;

        }

        return null; // 빈 리스트면 null을 반환

    }

    // 특정 위치 노드 삭제하기
    public Node<E> remove(E data) {

        // 첫번째 노드부터 탐색을 시작하여 타겟노드까지 저장할 변수
        Node<E> cur = header.getFirstNode();

        // 삭제 대상의 바로 이전노드를 저장할 변수
        Node<E> prev = null;

        // 삭제 대상 탐색하기
        while (cur != null && !data.equals(cur.getData())) {

            // 현재 타겟을 이전노드에 백업
            prev = cur;

            // 다음 노드를 현재노드로 재설정
            cur = cur.getNextNode();

        }

        // 삭제 처리 진행 현재 cur ==> : 삭제대상노드, prev : 삭제대상의 이전노드

        // 1. 삭제 대상이 맨 첫번째 노드인 경우
        if (prev == null && cur != null) {
            removeFirst();

        }
        // 2. 삭제 대상이 중간어딘가 혹은 맨 끝인 경우
        else if (prev != null && cur != null) {
            prev.setNextNode(cur.getNextNode());
        }

        size--;
        return cur; // 지운애를 뱉어준다
    }

    // 데이터 중간 삽입
    public void add(int index, E data) {

        // 새로운 노드 생성
        Node<E> newNode = new Node<>(data);

        // 새롭게 추가될 위치의 이전노드를 저장할 변수
        Node<E> prev = header.getFirstNode();

        // 들어갈 위치의 이전 노드 탐색
        // 원하는 위치 이전까지만 루프를 돌리면서 탐색
        for (int i = 0; i < index - 1; i++) {
            prev = prev.getNextNode();
        }

        // 새로운 노드의 다음노드로 이전노드의 다음노드를 저장
        newNode.setNextNode(prev.getNextNode());
        // 이전노드의 새로운 다음노드로 새 노드를 저장
        prev.setNextNode(newNode);

        size++;
    }

    public int size() {
        return size;
    }


    // 리스트를 전체 순회하여 데이터를 출력
    public String toString() {
        String str = "[ ";
        Node<E> current = header.getFirstNode();

        while (current != null) {
            str += current.getData();
            current = current.getNextNode();

            if (current != null) {
                str += ", ";
            }
        }
        str += " ]";
        return str;
    }

}


