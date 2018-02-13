package net.vk.shoppingbackend.dao;

import java.util.List;

import net.vk.shoppingbackend.dto.Address;
import net.vk.shoppingbackend.dto.Cart;
import net.vk.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);

	User getByEmail(String email);

	boolean addAddress(Address address);

	Address getBillingAddress(User user);

	List<Address> listShippingAddress(User user);

}
