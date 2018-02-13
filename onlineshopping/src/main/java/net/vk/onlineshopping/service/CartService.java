package net.vk.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.vk.onlineshopping.model.UserModel;
import net.vk.shoppingbackend.dao.CartLineDAO;
import net.vk.shoppingbackend.dao.ProductDAO;
import net.vk.shoppingbackend.dto.Cart;
import net.vk.shoppingbackend.dto.CartLine;
import net.vk.shoppingbackend.dto.Product;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession session;

	@Autowired
	ProductDAO productDAO;

	private Cart getCart() {

		// returns the cart of the user who has logged in

		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	// returns the entire cartlines
	public List<CartLine> getCartLines() {
		Cart cart = this.getCart();

		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {
		// fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if (cartLine == null) {
			return "result=error";
		} else {
			Product product = cartLine.getProduct();

			double oldTotal = cartLine.getTotal();

			if (product.getQuantity() <= count) {

				count = product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			return "result=updated";
		}
	}

	public String deleteCartLine(int cartLineId) {
		// fetch the cartline

		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		}

		else {

			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);

			// remove the cartline
			cartLineDAO.delete(cartLine);

			return "result=deleted";
		}
	}

	public String addCartLine(int productId) {
		String response = null;

		Cart cart = this.getCart();

		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);

		if (cartLine == null) {

			// add a new cartline

			cartLine = new CartLine();

			// fetch the product

			Product product = productDAO.get(productId);

			cartLine.setCartId(cart.getId());

			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);

			cartLineDAO.add(cartLine);

			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());

			cartLineDAO.updateCart(cart);

			response = "result=added";

		}

		return response;
	}
}
