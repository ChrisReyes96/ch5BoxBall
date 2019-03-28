
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
* Class BoxBall - a graphical ball that bounces inside a box. It simulates the movement and 
* bouncing of a ball in walls of a box. 
* 
* This movement can be initiated by repeated calls to the "move" method.
* 
* @author Christopher Reyes
* @author Michael Kölling (mik)
* @author David J. Barnes
* @author Bruce Quig
*
* @version 03.28.2019
*/

public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int bottomWall = 400; 
    private int topWall = 200; 
    private int leftWall = 50; 
    private int rightWall = 550; 
    private Canvas canvas;
    private int ySpeed = 8; 
    private int xSpeed = 14;

       /**
       * Constructor for objects of class BouncingBall
       *
       * @param xPos the horizontal coordinate of the ball
       * @param yPos the vertical coordinate of the ball
       * @param ballDiameter the diameter (in pixels) of the ball
       * @param ballColor the color of the ball
       * @param drawingCanvas the canvas to draw this ball on
       */
      public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
       Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
      
    }
    
    
    
    /**
    * Draw this ball at its current position onto the canvas.
    **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
    * Erase this ball at its current position.
    **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    /**
    * Move this ball according to its position and speed and redraw.
    **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        xPosition = xPosition + xSpeed; // xPosition += xSpeed;
        yPosition = yPosition + ySpeed;
        //stops on right wall
        if (xPosition + diameter > rightWall) {
            xPosition = rightWall - diameter;
            xSpeed = xSpeed * -1;
        }
        
        //stops on bottom wall
        if (yPosition + diameter >bottomWall){
            yPosition = bottomWall - diameter;
            ySpeed = ySpeed * -1;
        }
        
        //stops on left wall
        if (xPosition   <= leftWall){
            xPosition = leftWall ;
            xSpeed = xSpeed * -1;
        }
        
        //stops on top wall 
        if (yPosition  <= topWall){
            yPosition = topWall;
            ySpeed = ySpeed * -1;
            
        }

        // draw again at new position
        draw();
    }
    /**
    * return the horizontal position of this ball
    */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
    * return the vertical position of this ball
    */
    public int getYPosition()
    {
        return yPosition;
    }
}



