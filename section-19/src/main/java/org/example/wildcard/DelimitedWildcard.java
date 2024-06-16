package org.example.wildcard;

import org.example.wildcard.entities.Circle;
import org.example.wildcard.entities.IShape;
import org.example.wildcard.entities.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class DelimitedWildcard {
    public static void main(String[] args) {
        List<IShape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        System.out.println("Total area: " + totalArea(myShapes));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(3.0));
        myCircles.add(new Circle(2.0));

        System.out.println("Total area of circles: " + totalArea(myCircles));
    }

    public static double totalArea(List<? extends IShape> list) {
        double totalArea = 0;

        for (IShape shape : list) {
            totalArea += shape.area();
        }

        return totalArea;
    }
}
