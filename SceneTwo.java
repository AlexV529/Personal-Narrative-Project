import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** Instance Variables */
  private int[][] modes;
  private SharpImage image;
  
  /** Constructor */
  public SceneTwo(int[][] modes) {
    this.modes = modes;
    image = new SharpImage("modes.png");
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   * draws all the gamemodes
   */
  public void drawScene() {
    clear("white");
    
    drawText("Game Modes", 40, 30);
    drawText("Ranked: 1v1, 2v2, 3v3", 40, 60);
    drawText("Extra: Rumble, Hoops, Dropshot", 40, 90);
    drawText("Ratings:", 5, 325);

    image.sharpen();
    drawImage(image, 80, 100, 220);

    drawModeBarGraph();

    pause(2);
  }

  /*
  *Draws bars showing which game modes I play most
  *Precondition: Values are from 1-5
  *Shows which modes I play least and most
  */
  public void drawModeBarGraph() {
  int x = 80;
    for (int row = 0; row < modes.length; row++) {
      for (int col = 0; col < modes[0].length; col++) {
        int height = modes[row][col] * 20;
        drawRectangle(x, 400 - height, 20, height);
        x += 30;
      }
    }
  }
  
}