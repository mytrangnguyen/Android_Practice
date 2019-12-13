package com.example.bookmanagement;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String year;

    public Book(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setName(String name, String year){
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
