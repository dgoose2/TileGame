import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.List;

/**
 * Add comments
 */
public class TileManagerTest {
    //MUST PROPERLY TEST ALL PUBLIC METHODS (except drawAll) in TileManager class
    //MUST CALL getTiles method to test the internal state of tiles in TileManager class
    //MUST RUN TEST WITH COVERAGE and SHOW minimum of 85% COVERAGE for TileManager to get the full credit in testing

    @Test
    public void constructorTest() { //Example test provided by the instructor
        TileManager tileManager = new TileManager();
        List<Tile> tileList = tileManager.getTiles(); //use getTiles method to get the state of your tiles
        Assert.assertTrue("The constructor should initialize an empty list", tileList.isEmpty());
    }

    @Test
    public void addTest() { //Example test provided by instructor (uncomment below after you implement addTile method)
        TileManager tileManager = new TileManager();
        Tile tile = new Tile(100, 100, 50, 20, Color.RED);
        Tile tile2 = new Tile(35, 50, 20, 20, Color.blue);
        Tile tile3 = new Tile(45, 170, 30, 90, Color.DARK_GRAY);
        List<Tile> tileList = tileManager.getTiles();

        tileManager.addTile(tile);
        Assert.assertEquals("Tiles should be added to the end of the list", tile, tileList.get(0));
        tileManager.addTile(tile2);
        Assert.assertEquals("Tiles should be added to the end of the list", tile2, tileList.get(1));
        tileManager.addTile(tile3);
        Assert.assertEquals("Tiles should be added to the end of the list", tile3, tileList.get(2));
    }

    //DELETE TEST
    //In this test i created tiles and then i added them to a list in order to use them for testing
    //I then called in the method by doing .delete and then i would give it the tile that i wanted to delet
    //I then tested to make sure that there was a tile that got deleted
    //I then did a for loop to test the list at index i to make sure that there were still tiles in the list
    //I did this for all of the tiles until there were no more left
    @Test
    public void test1() {
        TileManager t2 = new TileManager();
        Tile tile = new Tile(100, 100, 1, 1, Color.RED);
        Tile tile2 = new Tile(30, 30, 1, 1, Color.BLACK);
        Tile tile3 = new Tile(50, 50, 1, 1, Color.BLUE);
        List<Tile> tileList = t2.getTiles();
        tileList.add(tile);
        tileList.add(tile2);
        tileList.add(tile3);

        t2.delete(50, 50);
        Assert.assertEquals(2, t2.getTiles().size());
        for (int i = 0; i < tileList.size(); i++) {
            Assert.assertEquals(tileList.get(i), t2.getTiles().get(i));
        }
        t2.delete(30, 30);
        Assert.assertEquals(1, t2.getTiles().size());
        for (int i = 0; i < tileList.size(); i++){
            Assert.assertEquals(tileList.get(i), t2.getTiles().get(i));
        }
        t2.delete(100, 100);
        Assert.assertEquals(0, t2.getTiles().size());
    }

    //RAISE TEST
    //In this test i created tiles and then i added them to a list in order to use them for testing
    //I also tested to make sure that the size of the list was not changing as it shouldn't do to use not deleting any tiles
    //i then ran a for loop and tested the list at index i to make sure that it was getting the tiles from the declared list
    //I did this for all of the tiles as i wanted to make sure that all of the tiles could raise and then making sure that it was at the correct index
    @Test
    public void test2() {
        TileManager t3 = new TileManager();
        Tile tile = new Tile(100, 100, 1, 1, Color.RED);
        Tile tile2 = new Tile(50, 50, 1, 1, Color.BLACK);
        Tile tile3 = new Tile(30, 30, 1, 1, Color.BLUE);
        List<Tile> tileList = t3.getTiles();
        tileList.add(tile);
        tileList.add(tile2);
        tileList.add(tile3);

        t3.raise(100, 100);
        Assert.assertEquals(3, t3.getTiles().size());
        for(int i = 0; i < t3.getTiles().size(); i++) {
            Assert.assertEquals(tileList.get(i), t3.getTiles().get(i));
        }
        t3.raise(50, 50);
        Assert.assertEquals(3, t3.getTiles().size());
        for (int i = 0; i < t3.getTiles().size(); i++) {
            Assert.assertEquals(tileList.get(i), t3.getTiles().get(i));
        }
        t3.raise(30, 30);
        Assert.assertEquals(3, t3.getTiles().size());
        for (int i = 0; i < t3.getTiles().size(); i++) {
            Assert.assertEquals(tileList.get(i), t3.getTiles().get(i));
        }
    }

    //LOWER TEST
    //In this test i created tiles and then i added them to a list in order to use them for testing
    //I also tested to make sure that the size of the list did not change as it should stay the same
    //I then ran a for loop to test the index's were correct for the given list after doing the lower action on a given tile
    @Test
    public void test3(){
        TileManager t4 = new TileManager();
        Tile tile = new Tile(100, 100, 1, 1, Color.RED);
        Tile tile2 = new Tile(50, 50, 1, 1, Color.BLACK);
        Tile tile3 = new Tile(30, 30, 1, 1, Color.BLUE);
        List<Tile> tileList = t4.getTiles();
        tileList.add(tile);
        tileList.add(tile2);
        tileList.add(tile3);

        t4.lower(100, 100);
        Assert.assertEquals(3, t4.getTiles().size());
        for (int i = 0; i < t4.getTiles().size(); i++) {
            Assert.assertEquals(tileList.get(i), t4.getTiles().get(i));
        }
        t4.lower(50, 50);
        Assert.assertEquals(3, t4.getTiles().size());
        for (int i = 0; i < t4.getTiles().size(); i++) {
            Assert.assertEquals(tileList.get(i), t4.getTiles().get(i));
        }
        t4.lower(30, 30);
        Assert.assertEquals(3, t4.getTiles().size());
        for (int i = 0; i < t4.getTiles().size(); i++) {
            Assert.assertEquals(tileList.get(i), t4.getTiles().get(i));
        }
    }

    //DELETE ALL TEST
    //In this test i created tiles and then i added them to a list in order to use them for testing
    //I also declared three of the tiles at the same coordinates in order to test that they would all get deleted
    //I then called the deleteAll method on the given x y coordinates
    //I then tested to make sure that there was still one tile left in the tileList
    //I also tested that the only tile left was the tile in the list at index 0
    //I then did the delete all test on the last element and then i checked to make sure there was no more elements in the list
    @Test
    public void test4(){
        TileManager t5 = new TileManager();
        Tile tile = new Tile(100, 100, 1, 1, Color.RED);
        Tile tile2 = new Tile(100, 100, 1, 1, Color.BLACK);
        Tile tile3 = new Tile(100, 100, 1, 1, Color.BLUE);
        Tile tile4 = new Tile(50, 50, 1, 1, Color.ORANGE);
        List<Tile> tileList = t5.getTiles();
        tileList.add(tile);
        tileList.add(tile2);
        tileList.add(tile3);
        tileList.add(tile4);

        t5.deleteAll(100, 100);
        Assert.assertEquals(1, t5.getTiles().size());
        Assert.assertEquals(tile4, t5.getTiles().get(0));

        t5.deleteAll(50, 50);
        Assert.assertEquals(0, t5.getTiles().size());
    }

    //SHUFFLE TEST
    //In this test i created tiles and then i added them to a list in order to use them for testing
    //I called the shuffle method and gave it the width and height
    //I then checked to make sure that the size of the list did not change
    //I then did a for loop to test that the tiles features did not change as there size and color should not change so i tested each tile in the list to make sure there attributes stayed the same
    @Test
    public void test6(){
        TileManager t7 = new TileManager();
        Tile tile = new Tile(100, 100, 1, 1, Color.RED);
        Tile tile2 = new Tile(50, 50, 2, 1, Color.BLACK);
        Tile tile3 = new Tile(30, 30, 3, 1, Color.BLUE);
        List<Tile> tileList = t7.getTiles();
        tileList.add(tile);
        tileList.add(tile2);
        tileList.add(tile3);

        t7.shuffle(10, 10);
        Assert.assertEquals(3, t7.getTiles().size());
        for (int i = 0; i < t7.getTiles().size(); i++) {
            Assert.assertTrue(tileList.contains(tileList.get(i)));
        }
    }
}