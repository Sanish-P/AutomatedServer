/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.DAO.Impl;

import com.Sanish.automatedserver.DAO.UserDAO;
import com.Sanish.automatedserver.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gandoff
 */
public class UserDAOImpl implements UserDAO {
    

    @Override
    public User getUserByUserName(String userName) {
        for (User user : getAll()) {
            if(user.getUserName().equals(userName)){
            return user;
            }
        }
        return null;
    }


    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"Sanish","Sanish"));
        users.add(new User(2,"Pashupati","Pashupati"));
        users.add(new User(1,"Rokin","Rokin"));
        users.add(new User(1,"Rojen","Rojen"));
        return users;
    }
    
}
