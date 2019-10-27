package myToolWindow;

import com.intellij.openapi.wm.ToolWindow;
import javafx.fxml.FXMLLoader;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;

public class MyToolWindow {
    private JButton refreshToolWindowButton;
    private JButton hideToolWindowButton;
    private JLabel currentDate;
    private JLabel currentTime;
    private JLabel timeZone;
    private JPanel myToolWindowContent;
    private JLabel remoteResponse;
    private JCheckBox checkBox1;
	private JEditorPane editorPane;

    public MyToolWindow(ToolWindow toolWindow) {

        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        refreshToolWindowButton.addActionListener(e -> editorPane.setText("<h1>hello</h1><p/><p><b>refreshed</b></p>"));
		HTMLEditorKit kit = new HTMLEditorKit();
		editorPane.setEditable(false);
		editorPane.setEditorKit(kit);
		Document doc = kit.createDefaultDocument();
		editorPane.setDocument(doc);
		editorPane.setText("<h1>hello</h1><p/><p><b>Sid</b></p>");


    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
