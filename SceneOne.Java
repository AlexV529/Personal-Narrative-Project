import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** Instance Variables */
  private int[][] intro;
  private SharpImage image;
  
  /** Constructor */
  public SceneOne(int[][] intro) {
    this.intro = intro;
    image = new SharpImage("introduction.png");
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   * draws the introduction
   */
  public void drawScene() {
    clear("white");
    
    drawText("Rocket League", 10, 25);
    drawText("Fast paced car soccer", 10, 50);
    drawText("Favorite Aspects: Gameplay, Training, Competition", 10, 75);
    drawText("Favorite Customization: Wheels, Decal, Cars", 10, 100);
    drawText("Ratings:", 5, 325);
    
    image.sharpen();
    drawImage(image, 80, 100, 200);

    drawIntroBarGraph();

    pause(2);
  }

  //returns the average rating
  public int getAverageRating() {
    int sum = 0;
    int count = 0;

    for (int[] row : intro) {
      for (int value : row) {
        sum += value;
        count++;
      }
    }
    return sum / count;
  }

  /*
  *Draws bars rating what I like most
  *Precondition: Values are from 1-5
  *Postcondition: the bars show what i like most
  */
  public void drawIntroBarGraph() {
    int x = 80;
    for (int row = 0; row < intro.length; row++) {
      for (int col = 0; col < intro[0].length; col++) {
        int height = intro[row][col] * 18;
        drawRectangle(x, 400 - height, 18, height);
        x += 30;
      }
    }
  }

}