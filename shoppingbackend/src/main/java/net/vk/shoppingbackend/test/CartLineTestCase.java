package net.vk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.vk.shoppingbackend.dao.CartLineDAO;
import net.vk.shoppingbackend.dao.ProductDAO;
import net.vk.shoppingbackend.dao.UserDAO;
import net.vk.shoppingbackend.dto.Cart;
import net.vk.shoppingbackend.dto.CartLine;
import net.vk.shoppingbackend.dto.Product;
import net.vk.shoppingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;

	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.vk.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
	}

	@Test
	public void testAddNewCartLine() {

		// first get the user

		user = userDAO.getByEmail("kv123451@gmail.com");

		// second fetch the cart

		// third get the product

		product = productDAO.get(21);

		cart = user.getCart();

		// fourth create a new cartline

		cartLine = new CartLine();

		cartLine.setBuyingPrice(product.getUnitPrice());

		cartLine.setProductCount(cartLine.getProductCount() + 1);

		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());

		cartLine.setAvailable(true);

		cartLine.setCartId(cart.getId());

		cartLine.setProduct(product);

		assertEquals("Failed to add the cart line", true, cartLineDAO.add(cartLine));

		// update the cart

		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());

		cart.setCartLines(cart.getCartLines() + 1);

		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));

	}

}
