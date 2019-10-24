package myToolWindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	private WebView myWebView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		WebEngine engine = myWebView.getEngine();
		engine.load("http://www.google.com");
	}
}
