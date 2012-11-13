package ipcam;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		// Create a new Swing JFrame to hold all of our UI
		JFrame mainFrame = new JFrame("Awesome Camera Interface");
		// Quit the application when the user closes the frame
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Camera parameters
		String camURL = "http://cs3240-cam1.cs.virginia.edu:81";
		String user = "admin";
		String pass = "admin";

		// Create the video panel
		VideoPanel videoPanel = new VideoPanel(camURL, user, pass,
				VideoPanel.RESOLUTION_HIGH);

		// Set the frame layout and add our video panel and a motion control
		// panel
		GridLayout layout = new GridLayout(2, 1);
		mainFrame.setLayout(layout);

		mainFrame.add(videoPanel);
		mainFrame.add(new MotionControlPanel(camURL, user, pass));

		// Display the frame
		mainFrame.setSize(600, 400);
		mainFrame.setVisible(true);

		// Begin video playback
		// Note that this MUST be called after mainFrame.setVisible(true)!
		videoPanel.start();
	}
}
