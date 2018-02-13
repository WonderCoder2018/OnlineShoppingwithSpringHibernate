package net.vk.shoppingbackend.dao;

import java.util.List;

import net.vk.shoppingbackend.dto.Cart;
import net.vk.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	CartLine get(int id);

	boolean add(CartLine cartLine);

	boolean update(CartLine cartLine);

	boolean delete(CartLine cartLine);

	List<CartLine> list(int cartId);

	// other business methods related to the cart line

	List<CartLine> listAvailable(int cartId);

	CartLine getByCartAndProduct(int cartId, int productId);

	boolean updateCart(Cart cart);

}
