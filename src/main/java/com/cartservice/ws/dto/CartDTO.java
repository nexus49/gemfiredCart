package com.cartservice.ws.dto;

import com.cartservice.model.Cart;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bastian Echterhoelter
 * Date: 4/5/11
 * Time: 8:39
 */
@XmlRootElement(name = "cart")
public class CartDTO {


    private String cartID;

    private String username;

    public CartDTO() {}

    public CartDTO(Cart cart) {
        this.username = cart.getUsername();
        this.cartID = cart.getCartId();
    }

    public String getCartID() {
        return cartID;
    }

    public String getUsername() {
        return username;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
