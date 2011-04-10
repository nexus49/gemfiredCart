package com.cartservice.ws.resources.cart;

import com.cartservice.model.Cart;
import com.cartservice.storage.GemfireDAO;
import com.cartservice.ws.dto.CartDTO;
import com.cartservice.ws.dto.CartsDTO;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Bastian Echterhoelter
 * Date: 4/3/11
 * Time: 7:29
 */
@Path("/carts")
public class CartsResource {

    @GET
    @Produces(
            {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getCarts(@QueryParam("offset") @DefaultValue("0") final int offset, @QueryParam("limit") @DefaultValue("10") final int limit) {

        GemfireDAO dao = GemfireDAO.getInstance();

        Set<String> daoCarts = dao.getCartIds();
        ArrayList<CartDTO> carts = new ArrayList<CartDTO>();

        for (String cartId : daoCarts) {
            Cart cart = dao.getCart(cartId);
            carts.add(new CartDTO(cart));
        }


        return Response.ok().entity(new CartsDTO(carts)).build();
    }

    @POST
    @Consumes("text/plain")
    public void createCart(String userId) {
        GemfireDAO dao = GemfireDAO.getInstance();

        Cart cart = new Cart();
        cart.setCartId(userId);
        cart.setUsername(userId);
        dao.addCart(userId, cart);
    }
}
