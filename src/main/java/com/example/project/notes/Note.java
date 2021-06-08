package com.example.project.notes;

public class Note {
    
    private String userID;
    private String note;

    public Note(String userId,String note) {
        this.userID = userId;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
