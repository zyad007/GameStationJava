/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IServices;

import Entities.User;
import java.util.UUID;

/**
 *
 * @author Zyad
 */
public interface IUserServices {
    void signUp(User user);
    User signIn(String username, String password);
    User getById(UUID id);
    boolean addScore(int score, UUID id);
}
