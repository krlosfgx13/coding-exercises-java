package org.example.coding.oop;

public class Evaluation {

    public interface Shape{
        float getArea();
        float getPerimeter();
    }

    public static class Rectangle implements Shape{
        private float length;
        private float width;

        public Rectangle(float new_length, float new_width){
            this.length = new_length;
            this.width = new_width;
        }

        @Override
        public float getArea() {
            System.out.println("Finding the area of a Rectangle with length = " + length + " and width = " + width);
            return length * width;
        }

        @Override
        public float getPerimeter() {
            System.out.println("Finding the perimeter of a Rectangle with length = " + length + " and width = " + width);
            return 2 * (length + width);
        }

        public String toString(){
            return "Rectangle = with length " + length + " and width " + width + " has an area of " + getArea() + " and a perimeter of " + getPerimeter();
        }
    }

    public static class Square extends Rectangle{
        private float side;

        public Square(float side){
            super(side, side);
            this.side = side;
        }

        public float getArea(){
            System.out.println("Finding the area of a Square with side = " + side);
            return side * side;
        }

        public float getPerimeter(){
            System.out.println("Finding the perimeter of a Square with side = " + side);
            return 4 * side;
        }

        public String toString(){
            return "Square = with side" + side + " has an area of " + getArea() + " and a perimeter of " + getPerimeter();
        }
    }

    public static class Circle implements Shape{
        private float radius;

        public Circle(float radius){
            this.radius = radius;
        }

        @Override
        public float getArea() {
            System.out.println("Finding the area of a Circle with radius = " + radius);
            return 3.1416f * radius;
        }

        @Override
        public float getPerimeter() {
            System.out.println("Finding the perimeter of a Circle with radius = " + radius );
            return 6.28f * radius;
        }

        public String toString(){
            return "Circle = with radius " + radius + " has an area of " + getArea() + " and a perimeter of " + getPerimeter();
        }
    }

    public static void main(String[] args){
        Shape rectangle = new Rectangle(4.2f, 6.0f);
        Shape circle = new Circle(3.5f);
        Square square = new Square(4);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.toString());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());
    }
}
