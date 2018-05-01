package com.luo.selfservice_supermarket3.Class;
public class Supermarket {
    private String account;
    private String name_s;
    private String describe;
    private String city;
    private String addres;
    private String coordinate;
    private String head;
    private String img_1;
    private String img_2;
    private String img_3;
    private double mark;
    public Supermarket(String account, String name_s) {
        super();
        this.account = account;
        this.name_s = name_s;
    }
    public Supermarket(String account,String name_s,String addres,double mark) {
        super();
        this.account = account;
        this.addres = addres;
        this.name_s = name_s;
        this.mark = mark;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getName_s() {
        return name_s;
    }
    public void setName_s(String name_s) {
        this.name_s = name_s;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddres() {
        return addres;
    }
    public void setAddres(String addres) {
        this.addres = addres;
    }
    public String getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
    public String getHead() {
        return head;
    }
    public void setHead(String head) {
        this.head = head;
    }
    public String getImg_1() {
        return img_1;
    }
    public void setImg_1(String img_1) {
        this.img_1 = img_1;
    }
    public String getImg_2() {
        return img_2;
    }
    public void setImg_2(String img_2) {
        this.img_2 = img_2;
    }
    public String getImg_3() {
        return img_3;
    }
    public void setImg_3(String img_3) {
        this.img_3 = img_3;
    }
    public double getMark() {
        return mark;
    }
    public void setMark(float mark) {
        this.mark = mark;
    }

}
