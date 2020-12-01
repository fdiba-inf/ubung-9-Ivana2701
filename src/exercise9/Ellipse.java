package exercise9;

public class Ellipse {
  private Point anfangsPunkt;
  private double a;
  private double b;

public Ellipse(){
  anfangsPunkt = new Point(0, 0);
  a = 1;
  b = 1;
}

public Ellipse(Point anfangsPunkt, double a, double b){
  this.anfangsPunkt = new Point (anfangsPunkt);
  this.a = a;
  this.b = b;
}

public Ellipse(Ellipse otherEllipse){
  anfangsPunkt = new Point(otherEllipse.anfangsPunkt);
  this.a = otherEllipse.a;
  this.b = otherEllipse.b;
}

public boolean isValid(){
  return a > 0 && b > 0;
}

public void initialize(){
  do{
    anfangsPunkt.initialize();
    a = Utils.INPUT.nextDouble();
    b = Utils.INPUT.nextDouble();
  }while(!isValid());
}

public double calculatePerimeter(){
  return Math.PI * (3 * (a + b) - Math.sqrt((3* a + b) * (3 * b + a)));
}

public double calculateArea(){
  return Math.PI * a * b;
}

public String getType(){
  if(a == b){
    return "Cycle";
  }
  else{
    return "Ellipse";
  }
}

public String toString(){
  return String.format("%s-[%s, %s], %s, P=%s, A=%s", anfangsPunkt, a, b, getType(), calculatePerimeter(), calculateArea());
}

public boolean equal(Ellipse otherEllipse) {
    boolean vergleich1 = Utils.equals(this.a, otherEllipse.a);
    boolean vergleich2 = Utils.equals(this.b, otherEllipse.b);
    boolean vergleich3 = Utils.equals(this.a, otherEllipse.b);
    boolean vergleich4 = Utils.equals(this.b, otherEllipse.a);

    return ((vergleich1 && vergleich2) || (vergleich3 && vergleich4));
    }
}