package org.example.lambda.basic;

@FunctionalInterface // 람다식을 쓸 수 있는 인터페이스인지 컴파일러안에서 체크
public interface Calculator {

    int calc(int n1, int n2);

    // default 메서드는 에러가 발생하지 않음






    

//    int add(int n1, int n2);

//    int sub(int n1, int n2);
//
//    default int multi(int n1, int n2) {  // default를 붙이면 강제 Override 강요를 없애준다
//        return 0;
//    }

}
