package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

public class SearchKey {
    private String id;
    private  String attribute;
    private  String value;


    public SearchKey() {
    }

    public SearchKey( String id, String attribute, String value) {
        this.id = id;
        this.attribute = attribute;
        this.value = value;
    }

    public String getName() {
        return id;
    }

    public void setName(String id) {
        this.id = id;
    }
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return "SearchKey{" +
                "id='" + id + '\'' +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
