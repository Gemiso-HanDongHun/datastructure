package org.example.lambda.basic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testtt() {


        // 람다식을 쓰기 위한 전제조건
        // 해당 인터페이스에 추상메서드가 단 한개일 것!
        Calculator addCalc = (n1, n2) -> n1 + n2;     // 람다 표현식

        int r1 = addCalc.calc(10, 20);
        System.out.println("r1 = " + r1);

        Calculator multiCalc = (n1, n2) -> n1 * n2;
        int r2 = multiCalc.calc(10, 20);
        System.out.println("r2 = " + r2);

        Operator op = new Operator(10, 20);

        op.operate(addCalc);

        int r3 = op.operate((n1, n2) -> n1 - n2);
        System.out.println("r3 = " + r3);

        int r4 = op.operate((n1, n2) -> n1 % n2);
        System.out.println("r4 = " + r4);


//        Calculator casio = new CasioCalculator();
//        casio.add(10, 20);
//
//        Calculator sharp = new Calculator() {   // {}가 클래스 블럭이다.    즉, new~ 부터 클래스를 여기서 구현하는 것으로
//                                                // 클래스와 동일하게 Override를 해주어야 한다
//            @Override
//            public int add(int n1, int n2) {
//                System.out.println("샤프 계산기 더하기");
//                return n1 + n2;
//            }
//
//            @Override
//            public int sub(int n1, int n2) {
//                return 0;
//            }
//        };
//
//        sharp.add(30, 45);

    }

}