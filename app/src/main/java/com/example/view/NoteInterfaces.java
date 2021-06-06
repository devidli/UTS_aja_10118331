package com.example.view;

import android.database.Cursor;

import com.example.view.Note;
import com.example.view.Note;

public interface NoteInterfaces {
    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);
}
// 06-06-2021
// 10118331
// Devidli Setiawan
// IF-8