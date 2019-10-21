package myToolWindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
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

    public MyToolWindow(ToolWindow toolWindow) {
        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        refreshToolWindowButton.addActionListener(e -> currentDateTime());

        this.currentDateTime();
    }


    public void currentDateTime() {
        // Get current date and time

        try {
            BufferedReader stream = new BufferedReader(new InputStreamReader(new URL("http://localhost:8081/hello").openStream()));
            String response = stream.readLine();
            remoteResponse.setText(response);

            Calendar instance = Calendar.getInstance();
            currentDate.setText(instance.get(Calendar.DAY_OF_MONTH) + "/"
                                    + (instance.get(Calendar.MONTH) + 1) + "/" +
                instance.get(Calendar.YEAR));
            currentDate.setIcon(new ImageIcon(getClass().getResource("/myToolWindow/Calendar-icon.png")));
            int min = instance.get(Calendar.MINUTE);
            String strMin;
            if (min < 10) {
                strMin = "0" + String.valueOf(min);
            } else {
                strMin = String.valueOf(min);
            }
            currentTime.setText(instance.get(Calendar.HOUR_OF_DAY) + ":" + strMin);
            currentTime.setIcon(new ImageIcon(getClass().getResource("/myToolWindow/Time-icon.png")));
            // Get time zone
            long gmt_Offset = instance.get(Calendar.ZONE_OFFSET); // offset from GMT in milliseconds
            String str_gmt_Offset = String.valueOf(gmt_Offset / 3600000);
            str_gmt_Offset = (gmt_Offset > 0) ? "GMT + " + str_gmt_Offset : "GMT - " + str_gmt_Offset;
            timeZone.setText(str_gmt_Offset);
            timeZone.setIcon(new ImageIcon(getClass().getResource("/myToolWindow/Time-zone-icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
