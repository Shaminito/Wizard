package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CMain implements Initializable{

	
	@FXML
	AnchorPane panel2;
	
	@FXML
	AnchorPane panel3;
	
	@FXML
	AnchorPane panel4;

	@FXML
	ImageView up_arrow;
	
	@FXML
	ImageView down_arrow;
	
	int posicion = 0;
	
	TranslateTransition translateTransition1;
	TranslateTransition translateTransition2;
	TranslateTransition translateTransition3;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		allPaneTransition(translateTransition1, 0.1, panel2, 700);
		allPaneTransition(translateTransition2, 0.1, panel3, 700);
		allPaneTransition(translateTransition3, 0.1, panel4, 700);
		
		up_arrow.setOnMouseClicked(event ->{
			if(posicion == 0) {
				allPaneTransition(translateTransition1, 3, panel2, -700);
				posicion++;
			}
			else if(posicion == 1) {
				allPaneTransition(translateTransition2, 3, panel3, -700);
				posicion++;
			}
			else if(posicion == 2) {
				allPaneTransition(translateTransition3, 3, panel4, -700);
				posicion++;
			}
		});
		
		down_arrow.setOnMouseClicked(event ->{
			if(posicion == 1) {
				allPaneTransition(translateTransition1, 0.3, panel2, -50).setOnFinished(event1 -> {
					allPaneTransition(translateTransition1, 2.7, panel2, 750);
				});
				posicion--;
			}
			else if(posicion == 2) {
				allPaneTransition(translateTransition2, 0.3, panel3, -50).setOnFinished(event1 -> {
					allPaneTransition(translateTransition2, 2.7, panel3, 750);
				});
				posicion--;
			}
			else if(posicion == 3) {
				allPaneTransition(translateTransition3, 0.3, panel4, -50).setOnFinished(event1 -> {
					allPaneTransition(translateTransition3, 2.7, panel4, 750);
				});
				posicion--;
			}
		});
	}

	private TranslateTransition allPaneTransition(TranslateTransition translateTransition, double tiempo, Node panel,int pos) {
		translateTransition = new TranslateTransition(Duration.seconds(0.3), panel);
		translateTransition.setByY(pos);
		translateTransition.play();
		return translateTransition;
	}
}