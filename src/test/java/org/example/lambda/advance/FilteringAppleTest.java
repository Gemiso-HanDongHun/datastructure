package org.example.lambda.advance;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static org.example.lambda.advance.Apple.Color.GREEN;
import static org.example.lambda.advance.Apple.Color.RED;
import static org.example.lambda.advance.Book.Genre.*;
import static org.example.lambda.advance.FilteringApple.*;

class FilteringAppleTest {

    @Test
    void tt() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, GREEN));
        inventory.add(new Apple(155, GREEN));
        inventory.add(new Apple(120, RED));
        inventory.add(new Apple(90, GREEN));
        inventory.add(new Apple(110, RED));
        inventory.add(new Apple(50, RED));

        //녹색사과만 필터링해주세요
        List<Apple> l = filterGreenApples(inventory);
//
//        List<Apple> l = filterApplesByColor(inventory, RED);
//
//        List<Apple> l = filterApples(inventory, apple -> apple.getWeight() > 150&&apple.getColor()==RED);
//        for (Apple apple : l) {
//            System.out.println(apple);
//        }

        //범용 메서드 filter 사용
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(
                Arrays.asList(
                        new Book(10000, HISTORY)
                        , new Book(20000, ESSAY)
                        , new Book(15000, HISTORY)
                        , new Book(14000, BIBLE)
                        , new Book(17000, COMICS)
                        , new Book(13000, COMICS)
                )
        );

        List<Book> books = filter(bookList, b -> b.getGenre() == COMICS);
        List<Apple> ap = filter(inventory, a -> a.getWeight() < 100);
        // 정수 리스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 홀수만 필터링
        List<Integer> integers = filter(numbers, n -> n % 3 == 0);
        for (Integer n : integers) {
            System.out.println(n);
        }

        List<Integer> integerList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(integerList);
    }

    @Test
    void sortTest() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, GREEN));
        inventory.add(new Apple(155, GREEN));
        inventory.add(new Apple(120, RED));
        inventory.add(new Apple(90, GREEN));
        inventory.add(new Apple(110, RED));
        inventory.add(new Apple(50, RED));

        // 정렬
//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight() - o2.getWeight();
//            }
//        });
        
        // 무게 오름차 정렬
        inventory.sort(comparing(Apple::getWeight));
        
        // 무게 내림차 정렬
        inventory.sort(comparing(Apple::getWeight).reversed());


        inventory.forEach(System.out::println);

    }

}