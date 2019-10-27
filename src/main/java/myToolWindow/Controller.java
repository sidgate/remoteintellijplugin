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
		engine.loadContent("<b>Hello world</b> <br><table><tr><td>col 1</td><td>col2</td></tr></table>");
	//	engine.load("http://www.google.com");
	}
}
