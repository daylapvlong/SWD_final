/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinator;

import service.CookieService;
import utils.HandleCookie;

/**
 *
 * @author admin's
 */
public class CartCoordinator {
    private CookieService cookieService;
    
    public CartCoordinator() {
        cookieService = new HandleCookie(); 
    }
    
    public CookieService getCookieService() {
        return cookieService;
    }

    public void setCookieService(CookieService cookieService) {
        this.cookieService = cookieService;
    }
}
