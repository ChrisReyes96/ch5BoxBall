import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
    
    /**
     * Class BallDemo - a short demonstration showing animation with the 
     * Canvas class. 
     *
     * @author Christopher Reyes
     * @version 03.28.2019
     *
     * @author Michael Kölling and David J. Barnes
     * @version 2011.07.31
     */
    
    public class BallDemo   
    {
        private Canvas myCanvas;
        private ArrayList<BoxBall> balls;
        /**
         * Create a BallDemo object. Creates a fresh canvas and makes it visible.
         * 
         */
        public BallDemo()
        {
            myCanvas = new Canvas("Ball Demo", 600, 500);
            balls = new ArrayList<>();
        }
        
        /**
         * Creates a method that simulates the bouncing of an amount of balls insid a box.
         * @param number the number of balls inside  the box
         */
        
          public void boxBounce(int number) {
          // creates new random object
            Random random = new Random(); 
          //assings values of variables used to create random colors 
            int red = 0;
            int green = 0;
            int blue = 0; 
            int numberBalls = 0;
            // create multiple balls
            while (numberBalls != number){
                   //random numbers for xPosition, yPosition, and diameter
                   int yPos = random.nextInt(200) + 200;
                   int xPos = random.nextInt(500) + 50;
                   int diameter = random.nextInt(20)+10;
         
                   // random color 
                   Color color = Color.black;
                   red = random.nextInt(220);
                   green = random.nextInt(220);
                   blue = random.nextInt(220);
                   color = new Color (red, green, blue);
                   balls.add(new BoxBall(xPos, yPos, diameter, color, myCanvas));
                   numberBalls++;
                }
       
                // loop that similates the movement of the balls
                while (true){
                    for (int i=0; i<balls.size(); i++){
                        // gets the balls and calls the move method
                        balls.get(i).move();
                        myCanvas.wait(10);  
                        // redraws rectangle walls    
                        myCanvas.drawLine(50, 400, 550, 400);
                        myCanvas.drawLine(50,200,550,200); 
                        myCanvas.drawLine(50,200,50,400);
                        myCanvas.drawLine(550,200,550,400);
                    }
                }
    }
    
        /**
         * Simulate two bouncing balls
         */
        public void bounce()
        {
            int ground = 400;   // position of the ground line
    
            myCanvas.setVisible(true);
    
            // draw the ground
            myCanvas.drawLine(50, ground, 550, ground);
    
            // crate and show the balls
            BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
            ball.draw();
            BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
            ball2.draw();
    
            // make them bounce
            boolean finished =  false;
            while(!finished) {
                myCanvas.wait(50);           // small delay
                ball.move();
                ball2.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                    finished = true;
                }
            }
    }
}
