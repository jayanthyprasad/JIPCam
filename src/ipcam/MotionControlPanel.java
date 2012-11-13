package ipcam;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A JPanel containing buttons to control camera orientation
 */
public class MotionControlPanel extends JPanel {
	/**
	 * Constructor
	 * 
	 * Creates a new MotionControlPanel to control the camera at camURL using
	 * the given username and password
	 * 
	 * @param camURL
	 *            The URL of the camera to connect to
	 * @param user
	 *            The username to login to the camera
	 * @param pass
	 *            The password to login to the camera
	 */
	public MotionControlPanel(String camURL, String user, String pass) {
		this.setLayout(new GridLayout(1, 4));
		JButton up = new CameraControlButton(camURL, user, pass,
				CameraControlButton.DIRECTION_UP);
		JButton down = new CameraControlButton(camURL, user, pass,
				CameraControlButton.DIRECTION_DOWN);
		JButton left = new CameraControlButton(camURL, user, pass,
				CameraControlButton.DIRECTION_LEFT);
		JButton right = new CameraControlButton(camURL, user, pass,
				CameraControlButton.DIRECTION_RIGHT);
		up.setText("Up");
		this.add(up);
		down.setText("Down");
		this.add(down);
		left.setText("Left");
		this.add(left);
		right.setText("Right");
		this.add(right);
	}
}
