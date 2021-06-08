package com.example.project.user;

import com.example.project.notes.*;


import java.util.ArrayList;
//@Component
public class User {
    
    private String emailID;
    private String password;
    private ArrayList<Note> noteList;

    public User(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
        noteList = new ArrayList<>();
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(ArrayList<Note> noteList) {
        this.noteList = noteList;
    }

    
    
}

