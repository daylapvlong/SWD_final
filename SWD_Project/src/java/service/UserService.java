/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.User;

/**
 *
 * @author Legion
 */
public interface UserService {
    public User authenticate(String username, String password);
}
