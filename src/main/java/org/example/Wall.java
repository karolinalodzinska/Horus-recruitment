package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure, CompositeBlock {
    private final List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksByMaterial = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                blocksByMaterial.add(block);
            }
        }
        return blocksByMaterial;
    }

    @Override
    public int count() {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                count += ((CompositeBlock) block).getBlocks().size();
            }
        }
        return count;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    // Additional method to add block to structure
    public void addBlock(Block block) {
        blocks.add(block);
    }

    // Implementation of Factory design pattern to create factory of blocks
    public static Block createBlock(String color, String material) {
        return new BasicBlock(color, material);
    }
}
