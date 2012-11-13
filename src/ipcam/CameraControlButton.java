package ipcam;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;

public class CameraControlButton extends JButton {
	private static final int UP = 0;
	private static final int STOPUP = 1;
	private static final int DOWN = 2;
	private static final int STOPDOWN = 3;
	private static final int LEFT = 4;
	private static final int STOPLEFT = 5;
	private static final int RIGHT = 6;
	private static final int STOPRIGHT = 7;
	private static final int CENTER = 25;

	public static final int DIRECTION_UP = 0;
	public static final int DIRECTION_DOWN = 1;
	public static final int DIRECTION_LEFT = 2;
	public static final int DIRECTION_RIGHT = 3;

	private static final String CONTROL_ENDPOINT = "decoder_control.cgi";

	private String camURL;
	private String user;
	private String pass;
	private int direction;

	public CameraControlButton(String camURL, String user, String pass,
			int direction) {
		this.camURL = camURL;
		this.user = user;
		this.pass = pass;
		this.direction = direction;

		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				onPushed();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				onReleased();
			}
		});
	}

	private void onPushed() {
		switch (direction) {
		case DIRECTION_UP:
			sendCommand(UP);
			break;
		case DIRECTION_DOWN:
			sendCommand(DOWN);
			break;
		case DIRECTION_LEFT:
			sendCommand(LEFT);
			break;
		case DIRECTION_RIGHT:
			sendCommand(RIGHT);
			break;
		}
	}

	private void onReleased() {
		switch (direction) {
		case DIRECTION_UP:
			sendCommand(STOPUP);
			break;
		case DIRECTION_DOWN:
			sendCommand(STOPDOWN);
			break;
		case DIRECTION_LEFT:
			sendCommand(STOPLEFT);
			break;
		case DIRECTION_RIGHT:
			sendCommand(STOPRIGHT);
			break;
		}
	}

	private void sendCommand(int command) {
		try {
			String commandString = String.format(
					"%s/%s?user=%s&pwd=%s&command=%d", camURL,
					CONTROL_ENDPOINT, user, pass, command);
			System.out.println("Sending command: " + commandString);
			URLConnection connection = new URL(commandString).openConnection();
			connection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
