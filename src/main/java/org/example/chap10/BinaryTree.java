package org.example.chap10;

import java.lang.annotation.Target;
import java.util.Stack;

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

    public boolean isEmpty() {
        return root == null;
    }

    //================ 삭제 ===================//
    public boolean delete(int target) {
        // 삭제 대상 노드와 그 노드의 부모노드를 탐색
        Node current = root;
        Node parent = current;

        // 노드 탐색
        while (target != current.getKey()) {
            if (current == null) return false;

            parent = current;
            if (target < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        // 삭제 진행
        // 1. 삭제 대상노드의 자식이 없는 경우
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {  // 삭제 타겟이 루트
                root = null;

                // 삭제 타겟이 오른쪽 자식이다.
            } else if (current == parent.getRightChild()) {
                parent.setRightChild(null);

            } else {
                parent.setLeftChild(null);

            }
        }
        // 2-1. 삭제 대상 노드의 자식이 하나인 경우 - 왼쪽자식을 가지고 있을 경우
        else if (current.getRightChild() == null) {

            // 삭제 대상이 루트
            if (current == root) {
                root = current.getLeftChild();
            }

            // 삭제 대상이 부모의 왼쪽 자식일 경우
            else if (current == parent.getLeftChild()) {

                // 부모의 새로운 왼쪽 자식으로 삭제 대상의 왼쪽 자식을 연결
                parent.setLeftChild(current.getLeftChild());
            }
            // 삭제대상이 부모의 오른쪽 자식일 경우
            else {
                parent.setRightChild(current.getLeftChild());
            }
        }

        // 2-2. 삭제 대상 노드의 자식이 하나인 경우 - 오른쪽 자식인 경우
        else if (current.getLeftChild() == null) {

            // 삭제 대상이 루트
            if (current == root) {

                // 삭제대상이 부모의 왼쪽자식인 경우
            } else if (current == parent.getLeftChild()) {

                // 부모의 새로운 왼쪽자식으로 삭제대상의 자식을 연결
                parent.setLeftChild(current.getRightChild());

                // 삭제대상이 부모의 오른쪽 자식인 경우
            } else {

                // 부모의 새로운 오른쪽자식으로 삭제대상의 자식을 연결
                parent.setRightChild(current.getRightChild());
            }
        }

        // 3-1. 삭제대상의 자식이 둘일 때
        else {

            // 삭제노드를 대신할 후보노드를 탐색
            Node candidate = getCandidate(current);

            if (current == root) {
                root = candidate;
                candidate.setLeftChild(current.getLeftChild());
            }

            // 삭제대상 노드가 부모의 오른쪽인 경우
            else if (current == root.getRightChild()) {

                // 3-1. 단계 1,  3-2. 단계 3
                parent.setRightChild(candidate);

            } else {
                // 3-1. 단계 1, 3-2. 단계 3
                parent.setLeftChild(candidate);
            }

            // 3-1. 단계 2, 3-2. 단계 4
            candidate.setLeftChild(current.getLeftChild());
        }

        return true;
    }

    // 후보노드 찾기
    private Node getCandidate(Node current) {

        // 후보노드의 부모
        Node candidateParent = current;

        // 후보노드
        Node candidate = current.getRightChild();

        // 삭제노드의 오른쪽자식의 가장 왼쪽 자식 찾기
        while (candidate.getLeftChild() != null) {
            candidateParent = candidate;
            candidate = candidate.getLeftChild();
        }

        // 후보노드가 삭제노드 왼쪽 자식일 때
        if (candidate != current.getRightChild()) {

            // 3-2. 단계 1
            // 후보노드의 오른쪽자식을 후보노드의 부모노드의 왼쪽으로 대체
            candidateParent.setLeftChild(candidate.getRightChild());

            // 3-2. 단계2
            // 후보노드의 부모를 후보노드의 오른쪽 자식으로 만든다
            candidate.setRightChild((candidateParent));
        }

        return candidate;
    }

    //================= 트리 출력 ======================//
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);

        int blank = 32;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;

            for (int i = 0; i < blank; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();

                if (temp != null) {
                    System.out.print(temp.getKey());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());

                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("**");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < blank * 2 - 2; i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            blank /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println();
    }

    public Node getRoot() {

        return root;
    }
}