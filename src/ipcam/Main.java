package ipcam;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Awesome Camera Interface");
		String camURL = "http://cs3240-cam1.cs.virginia.edu:81";
		String user = "admin";
		String pass = "admin";
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		VideoPanel videoPanel = new VideoPanel(camURL, user, pass,
				VideoPanel.RESOLUTION_LOW);
		GridLayout layout = new GridLayout(2, 1);
		mainFrame.setLayout(layout);
		mainFrame.add(videoPanel);

		mainFrame.add(new MotionControlPanel(camURL, user, pass));

		mainFrame.setSize(600, 400);

		mainFrame.setVisible(true);

		videoPanel.start();
	}
}
