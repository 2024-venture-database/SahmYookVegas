package com.SYVegas.chip;

public class ChipDTO implements java.io.Serializable {

    private int chipId;
    private String chipName;
    private String chipDescription;
    private String chipType;
    private String chipStatus;

    public ChipDTO() {
    }

    public ChipDTO(int chipId, String chipName, String chipDescription, String chipType, String chipStatus) {
        this.chipId = chipId;
        this.chipName = chipName;
        this.chipDescription = chipDescription;
        this.chipType = chipType;
        this.chipStatus = chipStatus;
    }

    public int getChipId() {
        return chipId;
    }

    public void setChipId(int chipId) {
        this.chipId = chipId;
    }

    public String getChipName() {
        return chipName;
    }

    public void setChipName(String chipName) {
        this.chipName = chipName;
    }

    public String getChipDescription() {
        return chipDescription;
    }

    public void setChipDescription(String chipDescription) {
        this.chipDescription = chipDescription;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public String getChipStatus() {
        return chipStatus;
    }

    public void setChipStatus(String chipStatus) {
        this.chipStatus = chipStatus;
    }

    @Override
    public String toString() {
        return "ChipDTO{" +
                "chipId=" + chipId +
                ", chipName='" + chipName + '\'' +
                ", chipDescription='" + chipDescription + '\'' +
                ", chipType='" + chipType + '\'' +
                ", chipStatus='" + chipStatus + '\'' +
                '}';
    }
}
