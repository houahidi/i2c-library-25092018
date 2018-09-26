package fr.uni.institute.dao.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import fr.uni.institute.library.business.inventory.Category;
import fr.uni.institute.library.dao.CategoryDao;
import fr.uni.institute.library.dao.DaoException;
import fr.uni.institute.library.dao.jdbc.CategoryDaoJdbc;

public class CategorieTestCase {
	
	private static Logger logger = Logger.getLogger(CategorieTestCase.class);
	private CategoryDao categorieDao;
	private int nombreCategorie ;
	@Before
	public void setUp() throws Exception {
		logger.info("Initialisation des ressources");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.90.100:3306/uni_library_db", "root", "admin");		
		
		
		categorieDao = new  CategoryDaoJdbc(connection);
		nombreCategorie =8;
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		logger.info("Libération des ressources");
	}

	@Test
	public void test1ResearchAllCategories() {
		logger.info("test1ResearchAllCategories");
		
		try {
			Collection<Category> liste = categorieDao.researchAllCategories();
			assertNotNull(liste);
			assertEquals(nombreCategorie, liste.size());
		} catch (DaoException e) {
			fail(e.getMessage()); 
		}
		
	}



}
