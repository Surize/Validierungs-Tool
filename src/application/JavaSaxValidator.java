package application;

import java.io.File;
//import java.io.PrintStream;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


import org.xml.sax.InputSource;

public class JavaSaxValidator extends MainController {

	 public static String validateXml(String xmlName, String schemaName) {
		  String result = " Validation was successful."; 
	  try {
	   // creating a Validator instance
	   Schema schema = loadSchema(schemaName);
	   Validator validator = schema.newValidator();

	   // preparing the XML file as a SAX source
	   SAXSource source = new SAXSource(new InputSource(new java.io.FileInputStream(xmlName)));

	   // validating the SAX source against the schema
	   validator.validate(source);
	   //System.out.println("Validation was successful.");

	  } catch (Exception e) {
	   // catching all validation exceptions
	   //System.out.println("Validation failed: " + e.toString());
	   result = " Validation failed: " + e.toString();
	  }
	  return result;
	 }

	 /**
	  * This method is used to load the schema name provide to the method.
	  * 
	  * @param name
	  * @return
	  */

	 public static Schema loadSchema(String name) throws Exception {
	  Schema schema = null; 
	   String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	   SchemaFactory factory = SchemaFactory.newInstance(language);
	   schema = factory.newSchema(new File(name));
	   return schema;
	 }

	}

