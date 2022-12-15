package org.example.chap10;

class Node {
    private int key; // 트리의 키 (데이터)
    private Node leftChild; // 왼쪽 자식
    private Node rightChild; // 오른쪽 자식

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.format("[ %d ]", key);
    }
}

public class BinaryTree {

    private Node root; // 루트 노드

    // 트리에 데이터 삽입
    public void add(int key) {

        // 삽입할 데이터 노드 생성
        Node newNode = new Node(key);

        // 지금 삽입된 노드가 트리의 첫번째 노드라면
        if (root == null) { // 빈트리라면
            root = newNode;
        } else {
            Node current = root;
            Node parent; // 탐색한 부모노드를 저장

            while (true) {  // 부모를 찾을때까지 무한루프를 돌림
                parent = current;

                // 삽입될 데이터가 타겟노드의 데이터보다 작은 경우
                if (key < current.getKey()) {
                    current = current.getLeftChild();

                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }

                } else {   // 삽입될 데이터가 타겟노드의 데이터보다 클 경우
                    current = current.getRightChild();

                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    //============= 순회 =============//

    // 전위 순회 (pre order) - 중전후
    public void preOrder(Node tempRoot) {
        if (tempRoot != null) {
            System.out.printf("%d ", tempRoot.getKey());
            preOrder(tempRoot.getLeftChild());
            preOrder(tempRoot.getRightChild());
        }
    }

    // 중위 순회 (in order) - 전중후
    public void inOrder(Node tempRoot) {
        if (tempRoot != null) {
            inOrder(tempRoot.getLeftChild());
            System.out.printf("%d ", tempRoot.getKey());
            inOrder(tempRoot.getRightChild());
        }
    }

    // 후위 순회 (post order) - 전후중
    public void postOrder(Node tempRoot) {
        if (tempRoot != null) {
            postOrder(tempRoot.getLeftChild());
            postOrder(tempRoot.getRightChild());
            System.out.printf("%d ", tempRoot.getKey());
        }
    }

    //===================== 탐색 ===================//

    public Node find(int targetData) {

        Node current = root;

        while (true) {
            if (current == null) return null; // 탐색 실패

            // 찾는 값이 현재 노드의 값보다 작은 경우
            if (targetData < current.getKey()) {
                current = current.getLeftChild();
            } else if (targetData > current.getKey()) {
                current = current.getRightChild();
            } else {
                return current; // 탐색 성공
            }
        }

    }

    //============ 최대, 최소값 탐색 =================//
    public Node findMin() {
        if (isEmpty()) return null; // 탐색 실패

        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    public Node findMax() {
        if (isEmpty()) return null; // 탐색 실패

        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    public Node getRoot() {

        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

}
