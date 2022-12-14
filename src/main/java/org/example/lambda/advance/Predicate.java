package org.example.lambda.advance;

public interface Predicate<T> {

    boolean test(T t);  // 타입을 범욕적으로 만들고 싶으면 제러닉 타입을 사용한다


}
