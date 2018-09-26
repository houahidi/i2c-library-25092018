package fr.uni.institute.library.web.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class IndexITestCase {

	@Test
	public void test() {
		final String ADDRESS = "http://localhost:8080/library-web/";
		

		 	try {
					WebConversation webConversation = new WebConversation();
					WebResponse menuResponse = webConversation.getResponse(ADDRESS);
					assertEquals("UNI Institute - UNI Library - []", menuResponse.getTitle());
				} catch (SAXException  e) {
					fail("SAXException: " + e.getMessage());
				} catch (IOException e) {
					fail("IOException: " + e.getMessage());
				}
			
	}

}