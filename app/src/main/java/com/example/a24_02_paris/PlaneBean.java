package com.example.a24_02_paris;

public class PlaneBean {

    private String name;

    public PlaneBean() {
    }

    public PlaneBean(String name) {
        this.name = name;
    }

    public void test(){
        name = "toto";
        setName("Toto2");
    }

    public String getName() {
        System.out.println("cocou");
        return name;
    }

    private void setName(String name) {
        System.out.println("CheckPermission");
        this.name = name;
    }

    private void setNameWithPermission(String name) {
        System.out.println("CheckPermission");
        this.name = name;
    }


}
