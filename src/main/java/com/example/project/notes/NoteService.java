package com.example.project.notes;

import java.util.ArrayList;

import com.example.project.user.User;
import com.example.project.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoteService {
    @Autowired
    UserService  us;
    
    public ArrayList<String> show(String emailID) {
        ArrayList<String> result = new ArrayList<>();
        User u = us.getUser(emailID);
        if(u == null) result.add("user not available");
        else {
            ArrayList<Note> list = u.getNoteList();
        
            for(Note n : list) result.add(n.getNote());
        }
       

        return result;
    }

    public boolean addNote(String emailID,String note) {
       User u = us.getUser(emailID);
        if(u == null) return false;
        else {
            Note n = new Note(emailID, note);
            u.getNoteList().add(n);
            return true;
        }
        
    }

    public boolean deleteNote(String emailID,int num) {
        User u = us.getUser(emailID);
        if(u == null) return false;
        else if(num < 0 || num >= u.getNoteList().size()) return false;
        else {
            u.getNoteList().remove(num);
            return true;
        }
    }

    public boolean update(String emailID,int num,String note) {
        User u = us.getUser(emailID);
        if(u == null) return false;
        else if(num < 0 || num >= u.getNoteList().size()) return false;
        else {
            Note n = new Note(emailID, note);
            u.getNoteList().set(num,n);
            return true;
        }
    }
   
}
