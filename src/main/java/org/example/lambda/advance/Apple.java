package org.example.lambda.advance;

public class Apple {

    enum Color {RED, GREEN}  // 정해져 있는 값에 대해선 enum을 사용한다

    private int weight; // 사과의 무게
    private Color color; // 사과의 색상

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String
    toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}






