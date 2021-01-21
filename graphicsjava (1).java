import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Font;

public class graphicsjava extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(255,0,0));
		g2.setFont(new Font("serif",Font.BOLD + Font.ITALIC,23));
		g2.drawString("Welcome to clever doctors app",60,70);
	}
}
