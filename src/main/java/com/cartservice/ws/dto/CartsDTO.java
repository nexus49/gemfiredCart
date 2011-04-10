package com.cartservice.ws.dto;

import com.cartservice.storage.GemfireDAO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

/**
 * Created by Bastian Echterhoelter
 * Date: 4/5/11
 * Time: 8:38
 */
@XmlRootElement(name = "carts")
public class CartsDTO {

    public CartsDTO(){}


    private List<CartDTO> carts;

    public CartsDTO(final List<CartDTO> carts)
	{
		super();
		this.setCarts(carts);
    }

    public List<CartDTO> getCarts() {

        return carts;
    }

    public void setCarts(List<CartDTO> carts) {
        this.carts = carts;
    }
}