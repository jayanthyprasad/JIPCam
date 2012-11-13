package ipcam;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A button enabling control of a robot's motors by toggling the speeds of the
 * left and right motors
 */
public class MotionControlPanel extends JPanel {
	/**
	 * Constructor
	 * 
	 * Creates a new RobotMovementPanel
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
