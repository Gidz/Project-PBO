package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PopupController {
	
	@FXML
	private TextField username;
	
	public void submit(ActionEvent ae) throws IOException {
        String name = username.getText();
        FileWriter myObj = new FileWriter("username.txt");
        myObj.write(name);
        myObj.close();

        Main m = new Main();
        m.changeScene("sample.fxml");
    }

}
