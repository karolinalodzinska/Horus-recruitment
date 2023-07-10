package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Wall wall = new Wall();

        wall.addBlock(Wall.createBlock("red", "brick"));
        wall.addBlock(Wall.createBlock("red", "brick"));
        wall.addBlock(Wall.createBlock("red", "wood"));
        wall.addBlock(Wall.createBlock("blue", "wood"));

        Optional<Block> foundBlockByColor = wall.findBlockByColor("grey");
        if (foundBlockByColor.isPresent()) {
            System.out.println("Found block: " + foundBlockByColor.get().getColor());
        } else {
            System.out.println("Block not found");
        }

        List<Block> foundBlocksByMaterial = wall.findBlocksByMaterial("wood");
        System.out.println("Found blocks: " + foundBlocksByMaterial.size());

        int totalBlocks = wall.count();
        System.out.println("Total blocks: " + totalBlocks);
    }
}
