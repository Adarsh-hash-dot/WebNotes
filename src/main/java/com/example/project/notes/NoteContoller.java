package com.example.project.notes;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.example.project.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NoteContoller {
    @Autowired
    UserService userService;

    @Autowired
    NoteService noteService;

    @GetMapping("/showNotes/{emailID}")
    public ArrayList<String> show(@PathVariable String emailID) {
        return noteService.show(emailID);
    }
    
    @PostMapping("/addNote/{emailID}")
    public String addNote(@PathVariable String emailID, @RequestBody String Note) {
        boolean result = noteService.addNote(emailID,Note);
        if(result) return "Success";
        else return "failed";
    }

    @PostMapping("/deleteNote/{emailID}/{num}")
    public String deleteNote(@PathVariable String emailID,@PathVariable int num) {
        boolean result = noteService.deleteNote(emailID,num);
        if(result) return "Success";
        else return "failed";
    }

    @PostMapping("/upDateNote/{emailID}/{num}")
    public String upDateNote(@PathVariable String emailID,@PathVariable int num,@RequestBody String Note) {
            boolean result = noteService.update(emailID,num,Note);
            if(result) return "success";
            else return "failed";
    }

}
