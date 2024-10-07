package inheritance_overload;

public class Main {
    public static void main(String[] args) {
        Shape genericShape = new Shape();
        Shape circle = new Shape(5.0);
        Shape square = new Shape(4,5);
        Shape rectangle = new Shape(4,1.0,2.0);
        Shape triangle = new Shape(3,1.0,2.0,3.0);

        System.out.println(genericShape.getShapeDetails());
        System.out.println(circle.getShapeDetails());
        System.out.println(square.getShapeDetails());
        System.out.println(rectangle.getShapeDetails());
        System.out.println(triangle.getShapeDetails());
    }
}

class Shape {
    private String shapeName;
    private int numOfEdges;
    public Shape() {
        System.out.println("shape has been created");
        shapeName = "Undefined shape";
    }
    public Shape(double radius) {
        System.out.println("circle has been created");
        shapeName = "circle";
        numOfEdges = 0;
    }
    public Shape(int edges, double edgeLength) {
        System.out.println("square has been created");
        shapeName = "square";
        numOfEdges = edges;
    }
    public Shape(int edges,double e1, double e2) {
        System.out.println("rectangle has been created");
        shapeName = "rectangle";
        numOfEdges = edges;
    }
    public Shape (int edges,double e1, double e2, double e3) {
        System.out.println("triangle has been created");
        shapeName = "triangle";
        numOfEdges = edges;
    }
    public String getShapeDetails (){
        return "Shape Name: " + shapeName + ", Number of Edges: " + numOfEdges;
    }
}






/**
 * Define a class called Shape that has:
 *
 * an instance variable shapeName
 * an instance variable numberOfEdges
 * 1 basic constructor method with no params that
 * informs the user about the Shape object creation
 * assign Undefined shape to the object's shapeName
 * 4 params overload constructor methods: for circle:
 * takes a double radius param
 * informs the user about the object creation
 * assigns the shapeName for square:
 * takes an int edges param and a double edgeLength param
 * informs the user about the object creation
 * assigns the values to numberOfEdges and to shapeName for rectangle:
 * takes an int edges param and 2 double (e1, e2) params
 * informs the user about the object creation
 * assigns the values to numberOfEdges and to shapeName for triangle:
 * takes an int edges param and 3 double (e1, e2, e3) params
 * informs the user about the object creation
 * assigns the values to numberOfEdges and to shapeName
 * a method called getShapeDetails() that returns an informative String containing:
 * shapeName
 * numberOfEdges
 * Define a testing class where you:
 *
 * create the 5 Shape objects using all the different constructor invocations
 * invoke getShapeDetails() for each Shape object and assign the returned values to dedicated String variables
 * print in console the values of the 5 dedicated String variables
 * */