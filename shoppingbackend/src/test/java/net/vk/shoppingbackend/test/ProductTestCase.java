package net.vk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.vk.shoppingbackend.dao.ProductDAO;
import net.vk.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.vk.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	
	/*@Test
	public void testCRUDProduct() {

		// create operation
		product = new Product();

		product.setName("Apple iPhone X");
		product.setBrand("Apple");
		product.setDescription("This is the description for Apple iPhone X");
		product.setUnitPrice(102000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Something went wrong while adding a new product!", true, productDAO.add(product));

		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");

		assertEquals("Something went wrong while updating the existing record", true, productDAO.update(product));

		// deleting the product
		assertEquals("something went wrong while deleting a product", true, productDAO.delete(product));

		// list
		assertEquals("something went wrong while fetching the list of products", 6, productDAO.list().size());

	}
*/
	

	@Test
	public void testListActiveProducts() {
		assertEquals("something went wrong while fetching list of active products",
				5, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("something went wrong while fetching list of active products",
				3, productDAO.listActiveProductsByCategory(3).size());
		
		assertEquals("something went wrong while fetching list of active products",
				2, productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testGetLatestProducts() {
				
		assertEquals("something went wrong while fetching list of active products",
				3, productDAO.getLatestActiveProducts(3).size());
	}
	
}
