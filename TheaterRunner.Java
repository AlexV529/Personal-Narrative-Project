import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
    
    /*Scene1: my favorite aspect of the game
    *Gameplay, training, competition
    *wheel, decal, cars
    */
    int[][] introData = {{5, 4, 5},   
                         {4, 5, 4}};
    /*
    *Scene2: The game modes I play the most
    *2v2, 1v1, 3v3 
    *rumble, hoops, dropshot
    */
    int[][] gameModes = {{5, 4, 3},   
                         {1, 2, 2}};
    
    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(introData);
    SceneTwo scene2 = new SceneTwo(gameModes);

    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    
  }
}