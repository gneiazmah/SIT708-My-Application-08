package com.example.sit708_my_application_01;

public class Items {

    private int ID;
    private String Name;
    private String Phone;
    private String Description;
    private String Date;
    private String Location;

    private int postType;


    public Items(){}

    public Items(int ID, String name, String phone, String description, String date, String location, int postType) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Description = description;
        Date = date;
        Location = location;
        this.postType = postType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }
}
