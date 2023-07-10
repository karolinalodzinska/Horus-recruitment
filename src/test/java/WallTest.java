import org.example.Block;
import org.example.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WallTest {
    private Wall wall;
    @BeforeEach
    public void setUp() {
        wall = new Wall();
    }

    private List<Block> getSampleBlocks() {
        return Arrays.asList(
                Wall.createBlock("red", "brick"),
                Wall.createBlock("red", "brick"),
                Wall.createBlock("red", "wood"),
                Wall.createBlock("blue", "wood")
        );
    }

    @Test
    public void testFindBlockByColor_ExistingColor_ReturnBlock(){
        // Arrange
        List<Block> blocks = getSampleBlocks();
        wall.addBlocks(blocks);

        // Act
        Optional<Block> foundBlockByColor = wall.findBlockByColor("red");

        // Assert
        Assertions.assertTrue(foundBlockByColor.isPresent());
        Assertions.assertEquals("red", foundBlockByColor.get().getColor());
    }

    @Test
    public void testFindBlockByColor_NonExistingColor_ReturnEmptyOptional(){
        // Arrange
        List<Block> blocks = getSampleBlocks();
        wall.addBlocks(blocks);

        // Act
        Optional<Block> foundBlockByColor = wall.findBlockByColor("green");

        // Assert
        Assertions.assertTrue(foundBlockByColor.isEmpty());
    }

    @Test
    public void testFindBlocksByMaterial_ExistingMaterial_ReturnListOfBlocks() {
        // Arrange
        List<Block> blocks = getSampleBlocks();
        wall.addBlocks(blocks);

        // Act
        List<Block> foundBlocksByMaterial = wall.findBlocksByMaterial("wood");

        // Assert
        Assertions.assertEquals(2, foundBlocksByMaterial.size());
        Assertions.assertEquals("red", foundBlocksByMaterial.get(0).getColor());
        Assertions.assertEquals("blue", foundBlocksByMaterial.get(1).getColor());
    }

    @Test
    public void testFindBlocksByMaterial_NonExistingMaterial_ReturnEmptyList(){
        // Arrange
        List<Block> blocks = getSampleBlocks();
        wall.addBlocks(blocks);

        // Act
        List<Block> foundBlocksByMaterial = wall.findBlocksByMaterial("steel");

        // Assert
        Assertions.assertTrue(foundBlocksByMaterial.isEmpty());
    }

}
