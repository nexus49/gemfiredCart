package com.cartservice.model;

import java.io.Serializable;

/**
 * Created by Bastian Echterhoelter
 * Date: 4/8/11
 * Time: 22:06
 */
public class Cart implements Serializable {

    private static final long serialVersionUID = -3569243165627161127L;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    private String cartId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    @Override
    public String toString() {
        return "Profile ("+cartId +")[username=" + username + "]";
    }


}
