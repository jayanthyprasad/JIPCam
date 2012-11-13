package ipcam;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JPanel;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.embedded.videosurface.VideoSurfaceAdapter;

/**
 * A JPanel to display video/audio from an IPCAM
 */
public class VideoPanel extends JPanel {
	/**
	 * Corresponds to a resolution of 640x480
	 */
	public static final int RESOLUTION_HIGH = 32;
	/**
	 * Corresponds to a resolution of 320x480
	 */
	public static final int RESOLUTION_LOW = 8;

	private static final String VIDEO_FEED = "videostream.asf";

	private EmbeddedMediaPlayer mediaPlayer;

	private String camURL;
	private String user;
	private String pass;
	private int resolution;

	/**
	 * Creates a new VideoPanel to playback video from the camera at the given
	 * URL and authenticate with the given username and password.
	 * 
	 * @param camURL
	 *            The url of the IPCAM to connect to
	 * @param user
	 *            The username to login the camera
	 * @param pass
	 *            The password to login the camera
	 * @param resolution
	 *            The resolution to use. This must be one of
	 *            RESOLUTION_[LOW|HIGH].
	 */
	public VideoPanel(String camURL, String user, String pass, int resolution) {
		this.camURL = camURL;
		this.user = user;
		this.pass = pass;
		this.resolution = resolution;

		MediaPlayerFactory factory = new MediaPlayerFactory(new String[] {});

		mediaPlayer = factory.newEmbeddedMediaPlayer();
		this.setLayout(new BorderLayout());
		Canvas vs = new Canvas();
		this.add(vs, BorderLayout.CENTER);
		mediaPlayer.setVideoSurface(factory.newVideoSurface(vs));
		this.setVisible(true);
	}

	/**
	 * Begins playback. Note that the VideoPanel MUST be visible
	 * (setVisible(true)) before this can be called, or an exception will be
	 * raised.
	 */
	public void start() {
		String mediaString = String.format(
				"%s/%s?user=%s&pwd=%s&resolution=%d", camURL, VIDEO_FEED, user,
				pass, resolution);
		mediaPlayer.playMedia(mediaString);
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
