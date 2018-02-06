package net.vk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.vk.shoppingbackend.dao.UserDAO;
import net.vk.shoppingbackend.dto.Address;
import net.vk.shoppingbackend.dto.Cart;
import net.vk.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.vk.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*
	 * @Test public void testAdd() {
	 * 
	 * user = new User(); user.setFirstname("Amitabh");
	 * user.setLastname("Bachchan"); user.setEmail("bigb@gmail.com");
	 * user.setContactNumber("1234567890"); user.setRole("USER");
	 * user.setPassword("12345");
	 * 
	 * // add the user assertEquals("Failed to add user", true,
	 * userDAO.addUser(user));
	 * 
	 * address = new Address(); address.setAddressLineOne("Prateeksha, 10th Road");
	 * address.setAddressLineTwo("Juhu Scheme"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("400049"); address.setBilling(true);
	 * 
	 * // link the user with the address using user id
	 * 
	 * address.setUserId(user.getId());
	 * 
	 * // add the billing address
	 * 
	 * assertEquals("Failed to add billing address", true,
	 * userDAO.addAddress(address));
	 * 
	 * if (user.getRole().equals("USER")) {
	 * 
	 * // create a cart for this user
	 * 
	 * cart = new Cart(); cart.setUser(user);
	 * 
	 * // add the cart assertEquals("Failed to add cart", true,
	 * userDAO.addCart(cart));
	 * 
	 * // add a shipping address for this user
	 * 
	 * }
	 * 
	 * // add a shipping address for this user
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("205, Silver Beach Apartment");
	 * address.setAddressLineTwo("Near Sun and Sand Hotel");
	 * address.setCity("Mumbai"); address.setState("Maharashtra");
	 * address.setCountry("India"); address.setPostalCode("400049"); // set shipping
	 * to true address.setShipping(true);
	 * 
	 * // link it with the user
	 * 
	 * address.setUserId(user.getId());
	 * 
	 * // add the shipping address
	 * 
	 * assertEquals("Failed to add shipping address", true,
	 * userDAO.addAddress(address));
	 * 
	 * }
	 */

	/*
	 * @Test public void testAdd() {
	 * 
	 * user = new User(); user.setFirstname("Amitabh");
	 * user.setLastname("Bachchan"); user.setEmail("bigb@gmail.com");
	 * user.setContactNumber("1234567890"); user.setRole("USER");
	 * user.setPassword("12345");
	 * 
	 * // add the user
	 * 
	 * if (user.getRole().equals("USER")) {
	 * 
	 * // create a cart for this user
	 * 
	 * cart = new Cart(); cart.setUser(user);
	 * 
	 * // attach cart with the user
	 * 
	 * user.setCart(cart);
	 * 
	 * } assertEquals("Failed to add user", true, userDAO.addUser(user));
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCart() {
	 * 
	 * // fetch the user by its email
	 * 
	 * user = userDAO.getByEmail("bigb@gmail.com");
	 * 
	 * // get the cart of the user
	 * 
	 * cart = user.getCart();
	 * 
	 * cart.setGrandTotal(527104); cart.setCartLines(2);
	 * 
	 * assertEquals("Failed to update the cart", true, userDAO.updateCart(cart)); }
	 */

	/*
	 * @Test public void testAddAddress() {
	 * 
	 * // we need to add user
	 * 
	 * user = new User(); user.setFirstname("Amitabh");
	 * user.setLastname("Bachchan"); user.setEmail("bigb@gmail.com");
	 * user.setContactNumber("1234567890"); user.setRole("USER");
	 * user.setPassword("12345");
	 * 
	 * assertEquals("Failed to add user", true, userDAO.addUser(user));
	 * 
	 * // we need to add billing address
	 * 
	 * address = new Address(); address.setAddressLineOne("Prateeksha, 10th Road");
	 * address.setAddressLineTwo("Juhu Scheme"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("400049"); address.setBilling(true);
	 * 
	 * // attach address to the user
	 * 
	 * address.setUser(user);
	 * 
	 * assertEquals("Failed to add billing address", true,
	 * userDAO.addAddress(address));
	 * 
	 * // we need to add shipping address
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("205, Silver Beach Apartment");
	 * address.setAddressLineTwo("Near Sun and Sand Hotel");
	 * address.setCity("Mumbai"); address.setState("Maharashtra");
	 * address.setCountry("India"); address.setPostalCode("400049");
	 * address.setShipping(true);
	 * 
	 * // attach address to the user
	 * 
	 * address.setUser(user);
	 * 
	 * assertEquals("Failed to add shipping address", true,
	 * userDAO.addAddress(address));
	 * 
	 * }
	 */

/*	@Test
	public void testAddAddress() {

		user = userDAO.getByEmail("bigb@gmail.com");

		address = new Address();
		address.setAddressLineOne("450, Silver Beach Apartment");
		address.setAddressLineTwo("Near Oberoi Hotel");
		address.setCity("Patna");
		address.setState("Bihar");
		address.setCountry("India");
		address.setPostalCode("800001");
		address.setShipping(true);

		// attach address to the user

		address.setUser(user);

		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));

	}*/
	
	@Test
	public void testGetAddresses() {
		user = userDAO.getByEmail("bigb@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size does not match",
				2, userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch the billing address and size does not match",
				"Mumbai", userDAO.getBillingAddress(user).getCity());

	}

}
