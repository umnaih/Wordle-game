import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnimationFram extends JFrame{

	AnimationPanel panel;
	public AnimationFram() {
		this.setPreferredSize(new Dimension(500,500));
		panel= new AnimationPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
