package org.example.chap02.singlylist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SimpleLinkedListTest {

    @Test
    @DisplayName("addFirst 테스트")
    void addFirstTest() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.addFirst("짜장면");
        list.addFirst("짬뽕");
        list.addFirst("볶음밥");

    }

    @Test
    @DisplayName("removeFirst 테스트")
    void removeFirstTest() {

        SimpleLinkedList<String> list = new SimpleLinkedList<>();

        list.addFirst("짜장면");
        list.addFirst("짬뽕");
        list.addFirst("볶음밥");

        System.out.println(list);

        list.removeFirst();

        System.out.println(list);

        list.removeFirst();

//        list.removeFirst();
        System.out.println(list);

    }


    @Test
    @DisplayName("remove 테스트")
    void removeTest() {

        SimpleLinkedList<String> foodlist = new SimpleLinkedList<>();

        foodlist.addFirst("짜장면");
        foodlist.addFirst("짬뽕");
        foodlist.addFirst("볶음밥");

        System.out.println(foodlist);

        foodlist.remove("짬뽕");

        System.out.println(foodlist);


    }


    @Test
    @DisplayName("add 테스트")
    void addTest() {

        SimpleLinkedList<String> foodlist = new SimpleLinkedList<>();
        System.out.println(foodlist.size());

        foodlist.addFirst("짜장면");
        foodlist.addFirst("짬뽕");
        foodlist.addFirst("볶음밥");
        foodlist.addFirst("깐풍기");


        System.out.println(foodlist);
        foodlist.add(1, "유린기");
        foodlist.add(4, "김밥");

        System.out.println(foodlist);
        System.out.println(foodlist.size());

    }


}