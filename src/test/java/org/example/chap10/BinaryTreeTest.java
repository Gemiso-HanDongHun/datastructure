package org.example.chap10;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void traverse() {

        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("ddd", "zzz");
        treeMap.put("aaa", "zzz");
        treeMap.put("zzz", "zzz");

        System.out.println(treeMap);


        BinaryTree tree = new BinaryTree();


        /*
                              50

                27                              68

        12              36              55              82

    7      19      **       49      **      **      76      **

         */
        tree.add(50);
        tree.add(27);
        tree.add(68);
        tree.add(12);
        tree.add(36);
        tree.add(55);
        tree.add(82);
        tree.add(7);
        tree.add(19);
        tree.add(49);
        tree.add(76);

        System.out.println("============ 순회 ===============");
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());

        // 트리 출력
        System.out.println("============ 트리출력 ===============");
        tree.display();
        tree.delete(27);
        tree.display();


        System.out.println("============ 이진트리출력 ===============");

        BinaryTree tree2 = new BinaryTree();
        tree2.add(50);
        tree2.add(40);
        tree2.add(30);
        tree2.add(20);

        tree2.display();

    }
}