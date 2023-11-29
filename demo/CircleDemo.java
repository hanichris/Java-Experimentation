package demo;
import com.examples.circle.Circle;

public class CircleDemo {

    public static void moveCircle(Circle circle, int deltaX, int deltaY){
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        circle = new Circle(0, 0);
    }
    
    public static void main(String[] args) {

        Circle myCircle = new Circle(1, 1);
        myCircle.printCenter();
        CircleDemo.moveCircle(myCircle, 5, 6);
        myCircle.printCenter();

        
    }
}
