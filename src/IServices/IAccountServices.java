/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IServices;

/**
 *
 * @author Zyad
 */
public interface IAccountServices {
    boolean login(String userName, String password);
    boolean signUp(String userName, String password);
}
