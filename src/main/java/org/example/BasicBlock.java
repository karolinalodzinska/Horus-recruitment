package org.example;

public class BasicBlock implements Block{
    private final String color;
    private final String material;

    public BasicBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}

