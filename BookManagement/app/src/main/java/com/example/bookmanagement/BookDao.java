package com.example.bookmanagement;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BookDao {

    @Query("SELECT * FROM Book")
    List<Book> getAll();

    @Insert
    void insert(Book todo);

    @Update
    void update(Book todo);

    @Delete
    void delete(Book todo);
}
