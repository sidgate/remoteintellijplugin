import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.wm.ToolWindowManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloAction extends AnAction {
	public HelloAction() {
		super("Hello");
	}

	public void actionPerformed(AnActionEvent event) {
		Project project = event.getProject();
		//Messages.showMessageDialog(project, "Hello world!", "Greeting", Messages.getInformationIcon());

		ToolWindowManager.getInstance(project).getToolWindow("Sample Calendar").show(()->{});



	}
}