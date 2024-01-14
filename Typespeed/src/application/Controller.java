package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Controller implements Initializable{
	
	@FXML
	private Label displayUsername;
	
	@FXML
	private Text total;
	
	@FXML
	private Text wpm;
	
	@FXML
	private Text invalid;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	        File newFile = new File("username.txt");
	        if (newFile.length() != 0) {
	            Scanner reader = null;
	            try {
	                reader = new Scanner(newFile);
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            }
	            String data = reader.nextLine();
	            displayUsername.setText("Welcome, "+data);
	        }
	        
	        int[] data = FileHandling.sumUpNumbers("src/data");
	        total.setText(String.valueOf(data[0]));
	        wpm.setText(String.valueOf(Math.round(data[1]*1.0/data[3])));
	        invalid.setText(String.valueOf(data[2]));
		
	}
	
	public void playGame(ActionEvent ddd) throws IOException {
        Main m = new Main();

        File newFile = new File("username.txt");
        if (newFile.length() == 0) {
            try {
                m.changeScene("popup.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            m.changeScene("game.fxml");
        }
	
	}
}
