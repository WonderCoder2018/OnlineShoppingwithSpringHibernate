package net.vk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.vk.shoppingbackend.dao.CategoryDAO;
import net.vk.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.vk.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop!");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully fetched single category from the table!",
	 * "Television", category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully updated single category in the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully deleted single category in the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 *
	 * 
	 * assertEquals("Successfully fetched the list of categories from the table!",
	 * 2, categoryDAO.list().size());
	 * 
	 * }
	 */

	/*@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_4.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_5.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(2);

		category.setName("TV");

		assertEquals("Successfully updated single category in the table!", true, categoryDAO.update(category));

		// delete the category
		category = categoryDAO.get(1);

		assertEquals("Successfully deleted single category in the table!", true, categoryDAO.delete(category));
	
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1, categoryDAO.list().size());
		
	}*/

}
