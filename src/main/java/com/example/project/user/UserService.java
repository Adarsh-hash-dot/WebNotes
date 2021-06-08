package com.example.project.user;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private HashMap<String,User> userMap = new HashMap<>();

    public User getUser(String emailID) {
        return userMap.get(emailID);
    }

    public HashMap<String,User> show() {
        return userMap;
    }

    public boolean add(User user) {
        String key = ((User) user).getEmailID();
        if(userMap.containsKey(key)) {
            return false;
        }
        else {
            userMap.put(key, (User) user);
            return true;
        }
    }

    public boolean contains(User user) {
        String key = ((User) user).getEmailID();
        if(userMap.containsKey(key)){
            User u = userMap.get(key);
            if(u.getPassword().equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean remove(User user) {
        String key = ((User) user).getEmailID();
        if(userMap.containsKey(key)) {
            userMap.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePassword(User user,String newPassword) {
        String key = ((User) user).getEmailID();
        if(userMap.containsKey(key)) {
            User u = userMap.get(key);
            u.setPassword(newPassword);
            return true;
        } else {
            return false;
        }
    }

    

}
