package myToolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Alexey.Chursin
 * Date: Aug 25, 2010
 * Time: 2:09:00 PM
 */
public class MyToolWindowFactory implements ToolWindowFactory {
  // Create the tool window content.
  public void createToolWindowContent(Project project, ToolWindow toolWindow) {
    /*MyToolWindow myToolWindow = new MyToolWindow(toolWindow);
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(myToolWindow.getContent(), "", false);
    toolWindow.getContentManager().addContent(content);*/

    final JFXPanel panel = new JFXPanel();
    toolWindow.getComponent().add(panel);
    Platform.runLater(() -> initFX(panel));
  }

  private void initFX(JFXPanel fxPanel) {
    try {
      FXMLLoader.setDefaultClassLoader(MyToolWindowFactory.class.getClassLoader());
      Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));

      fxPanel.setScene(new Scene(root, 300, 275));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
