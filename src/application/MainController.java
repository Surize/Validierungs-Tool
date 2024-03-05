package application;


import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class MainController {
	
    @FXML
    private Button btnXml;

    @FXML
    private Button btnXsd;

    @FXML
    private TextArea taXml;

    @FXML
    private TextArea taXSD;

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea taValidationCheck;
    
    // Create a FileChooser object
    final FileChooser fc = new FileChooser();
    
    static String xmlFilePath = "";
    static String xsdFilePath = "";
    
    
    
    @FXML
     public void fileChooserXml(ActionEvent event) {
    	fc.setTitle("XML file chooser");
    	fc.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fc.showOpenDialog(null);
        if (file != null) {
             taXml.appendText(file.getAbsolutePath());
             xmlFilePath = file.getAbsolutePath();
             //System.out.println(xmlFilePath);
        } else {
        	 taXml.appendText("No XML has been selected");
        }
        
      
    }
    	
    @FXML
     public void fileChooserXsd(ActionEvent event) {
    	fc.setTitle("XSD file chooser");
    	fc.setInitialDirectory(new File(System.getProperty("user.home")));
    	fc.setInitialFileName("*.xsd");
        File file = fc.showOpenDialog(null);
        if (file != null) {
            taXSD.appendText(file.getAbsolutePath());
            xsdFilePath = file.getAbsolutePath();
            //System.out.println(xsdFilePath);
        } else {
        	taXSD.appendText("No XSD has been selected");
        }
    }
    

    @FXML
    public void validationCheck(ActionEvent event) {
    	String result = JavaSaxValidator.validateXml(xmlFilePath,xsdFilePath);
    	String nonSplitResult = result;
    	String splitResult = nonSplitResult.replace(";", "\n");
    	//System.out.println(splitResult);
    	taValidationCheck.appendText(splitResult);
    }

}
