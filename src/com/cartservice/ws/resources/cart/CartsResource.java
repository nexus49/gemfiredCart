package com.cartservice.ws.resources.cart;

import com.cartservice.ws.dto.CartDTO;
import com.cartservice.ws.dto.CartsDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bastian Echterhoelter
 * Date: 4/3/11
 * Time: 7:29
 */
@Path("carts/")
public class CartsResource {

    @GET
	@Produces(
	{ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getAddresses(@QueryParam("offset") @DefaultValue("0") final int offset, @QueryParam("limit") @DefaultValue("10") final int limit)
	{
		return Response.ok().entity(createDummyDTO()).build();
	}

    private CartsDTO createDummyDTO() {
        CartDTO cart = new CartDTO();
        cart.setUsername("nexus49");
        cart.setCartID("123");
        List<CartDTO> cartsList = new ArrayList<CartDTO>();
        cartsList.add(cart);
        return new CartsDTO(cartsList);
    }
}
