import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;

public class EarthQuakeSim5{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      Point5[] cities = getCities(sc);
      
      //get the epicenter
      System.out.print("What is the epicenter (x,y)? ");
      int x = sc.nextInt();
      int y = sc.nextInt();
      Point5 epicenter = new Point5(x ,y);
      //get the radius
      System.out.print("What is the radius? ");
      int radius = sc.nextInt();
      
      drawEarthQuake(cities, epicenter, radius);
      
   }
   
   //read in the points
   //@param s scanner to console
   //@return Point5[] the cities that could be effected by the earthequake
   public static Point5[] getCities(Scanner s){
      System.out.print("How many Cities? ");
      int numCities = s.nextInt();
      //create our array of cities
      Point5[] cities = new Point5[numCities];
      //loop through and read in every city
      for(int i = 0; i < numCities; i++){
         System.out.print("Enter the x and y cordinate for City " + (i+1) + ": ");
         //read tthe x and y cordinate
         int x = s.nextInt();
         int y = s.nextInt();
         //creat the city
         Point5 city = new Point5(x, y);
         //add it to the arry
         cities[i] = city;
      }
      //return our new array of cities
      return cities;
      
   }
   
   public static void drawEarthQuake(Point5[] cities, Point5 epicenter, int radius){
      //make the drawing panel
      DrawingPanel p = new DrawingPanel(500, 500);
      //draw the circle
      Graphics g = p.getGraphics();
      g.setColor(Color.RED);
      g.drawOval(epicenter.getX() - radius, epicenter.getY() - radius, radius * 2, radius * 2);
      //draw each point
      for(int i = 0; i<cities.length; i++){
         cities[i].printEarthQuake(g, epicenter, radius);
      }
      
      
   }
}