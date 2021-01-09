import java.awt.Graphics;
import java.awt.Color;


public class Point5{
   //II: fileds int x and y
   private int x;
   private int y;
   
   //III: constructors (3)
   //by position (x, y) (The constructor that sets the fields)
   public Point5(int x, int y){
      this.x = x;
      this.y = y;
   }
   //copy constructor (Another point) (The constructor that coppies another version of the same object)
   public Point5(Point5 p){
      this(p.x, p.y);
   }
   //default constructor (The constructor that creates a point orgin)
   public Point5(){
      this(0, 0);
   }
   

   //IV: Getter and Setter Methods
   //get x & y
   public int getX(){
      return x;
   }
   public int getY(){
      return y;
   }
   
   //set x & y
   public void setX(int x){
      this.x = x;
   }
   public void setY(int y){
      this.y = y;
   }
   
   
   //V: other Methods
   
   //teach the point to print itself
   public String toString(){
      String result = "(" + x + "," + y + ")";
      return result;
   }
   //Draw itselft given a grapgic object and color
   public void draw(Graphics g, Color c){
      //set the color
      g.setColor(c);
      //draw the point(3 by 3 pixel circle centered on a real point)
      //           x, y, width, hight
      g.fillOval(x-1, y-1, 3, 3);
      //draw the string
      //             string,   x,   y
      g.drawString(toString(), x+4, y-4);
   }
   //Translate itself (given another point)
   public void translate(Point5 p){
      x += p.x;
      y += p.y;
   }
   //Distanse to another point (Use distance formula)
   public double distance(Point5 p) {
      int xDiff = p.x - x;
      int yDiff = p.y - y;
      
      double dist = Math.sqrt(xDiff*xDiff + yDiff * yDiff);
      return dist;
   }
   //Given an epicenter and distance.. print self with the right color
   //@param epicenter A Point5 epicenter
   //@param radius How far away the earthquake effects
   //@return nothing
   public void printEarthQuake(Graphics g, Point5 epicenter, int radius){
      //calculate the distance from our point to the epicenter
      double dist = distance(epicenter);
      //if we are in the radius.. print the point in red otherwise black
      if(dist <= radius){
         this.draw(g, Color.RED);
      } 
      else {
         this.draw(g, Color.BLACK);
      }
   }
   
}