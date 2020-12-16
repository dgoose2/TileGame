import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Add your own comments here
 */
public class TileManager {
    private List<Tile> tiles; //DO NOT MODIFY THIS LINE
    //Implement your own code here
    //In this method i created and array list to the list created above called tiles
    public TileManager(){
        this.tiles = new ArrayList<>();
    }

    //In this method i added a tile to my arrayList called tiles
    public void addTile(Tile tile){
        tiles.add(tile);
    }

    //In this method i ran a loop in order to run all of the tiles and have them drawn
    //I did a for each loop as i wanted to use each tile within the arrayList
    public void drawAll(Graphics graphics){
        for (Tile t : tiles){
            t.draw(graphics);
        }
    }

    //In this method i did a for loop in order to get each tile at the index i and then i did an if statement to test it
    //And if the if statement was true which it tested that it was within the given x and y bounds and then if it was it would delete all of the tiles in the bound
    public void deleteAll(int x, int y){
        for (int i = tiles.size()-1; i >= 0; i--){
            Tile tile = tiles.get(i);
            if (helperMethod(x, y, tile)){
                tiles.remove(i);
            }
        }
    }

    //In this method i did the same for loop as above in order to access all of the tiles and then the same if statement however in this if statement i broke out of the statement
    //I chose to break out of it as if i did not it would delete all of the elements within the bounds which i did not want it to do
    public void delete(int x, int y){
        for (int i = tiles.size()-1; i >= 0; i--){
            Tile tile = tiles.get(i);
            if (helperMethod(x, y, tile)){
                tiles.remove(i);
                break;
            }
        }
    }

    //In this method i did a for loop to acces the tiles and then i would remove the tile at the index i and then i would add it to the front of the arrayList
    //I did this as i wanted to lower the tile and that would mean that it was drawn first so it should be at the beginning of the arrayList
    //I also did a break statement so i was only lowering one tile
    public void lower(int x, int y){
        for (int i = tiles.size() - 1; i >= 0; i--){
            Tile tile = tiles.get(i);
            if (helperMethod(x, y, tile)){
                tiles.remove(i);
                tiles.add(0, tile);
                break;
            }
        }
    }

    //In this method i ran a for loop in order to access all of the tiles and then i did an if statement to remove the tile from the arrayList at index i
    //I then added the tile to the list as if it was the last element as i wanted to to raise which would mean that it was drawn last
    //I also did a break so i was only raising one tile
    public void raise(int x, int y){
        for (int i = tiles.size() - 1; i >= 0; i--) {
            Tile tile = tiles.get(i);
            if (helperMethod(x, y, tile)) {
                tiles.remove(i);
                tiles.add(tile);
                break;
            }
        }
    }

    //In this method i created a helper method in order to to test the bounds of the tile i did this so i could call it into the above methods
    //I then would cal it and use it in order to test where the tiles were on the drawing panel and allow the testing to be cleaner
    public Boolean helperMethod(int x, int y, Tile tile){
        return (x >= tile.getX() && x <= tile.getX() + tile.getWidth()
                && y >= tile.getY() && y <= tile.getY() + tile.getHeight() );
    }

    //In this method i called the .shuffle action in order to shuffle the tiles in the arrayList
    //I then created a random in order to randomly generate where the x and y coordinates would be for the tiles when i called the shuffle method in the drawing panel
    public void shuffle(int width, int height){
        Collections.shuffle(this.tiles);
        List<Tile> tile = new ArrayList<>();
        Random rand = new Random();
        for (Tile t : this.tiles){
            t.setX(rand.nextInt(width - t.getWidth()));
            t.setY(rand.nextInt(height - t.getHeight()));
            tile.add(t);
        }
        this.tiles = tile;
    }

    //*** FOR TESTING PURPOSE ONLY ****//
    //SHOULD USE THIS METHOD ONLY IN J-UNIT TEST CODE
    //DO NOT MODIFY THIS METHOD
    public List<Tile> getTiles() {
        return tiles;
    }
}
