package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure, CompositeBlock {
    private final List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .flatMap(this::flattenBlocks)
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    private Stream<Block> flattenBlocks(Block block) {
        if (block instanceof CompositeBlock) {
            return ((CompositeBlock) block)
                    .getBlocks()
                    .stream()
                    .flatMap(this::flattenBlocks);
        } else {
            return Stream.of(block);
        }
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .flatMap(this::flattenBlocks)
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
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
