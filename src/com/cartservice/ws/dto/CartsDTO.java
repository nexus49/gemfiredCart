package com.cartservice.ws.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bastian Echterhoelter
 * Date: 4/5/11
 * Time: 8:38
 */
@XmlRootElement(name = "carts")
public class CartsDTO {


    @XmlElement(name = "carts")
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