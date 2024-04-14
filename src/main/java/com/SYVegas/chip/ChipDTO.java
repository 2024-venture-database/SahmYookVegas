package com.SYVegas.chip;

public class ChipDTO implements java.io.Serializable {

    private int chipId;
    private int attribute;

    public ChipDTO() {
    }

    public ChipDTO(int chipId, int attribute) {
        this.chipId = chipId;
        this.attribute = attribute;
    }

    public int getChipId() {
        return chipId;
    }

    public void setChipId(int chipId) {
        this.chipId = chipId;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "ChipDTO{" +
                "chipId=" + chipId +
                ", attribute=" + attribute +
                '}';
    }
}
