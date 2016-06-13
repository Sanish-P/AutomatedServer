/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.DAO;

import com.Sanish.automatedserver.entity.User;
import java.util.List;

/**
 *
 * @author gandoff
 */
public interface UserDAO {
     
     public User getUserByUserName(String userName);
     public List<User> getAll();
}
