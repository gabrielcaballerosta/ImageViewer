package imageviewer.view.ui;
import imageviewer.model.Image;
import imageviewer.view.ui.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    
    private Image currentImage;
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if (currentImage == null) return;
        g.drawImage(imageOf(currentImage),0,0,null);
    }
    
    @Override
    public void show(Image image) {
        currentImage = image;
        repaint();
    }

    @Override
    public Image current() {
        return currentImage;
    }
    
    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException ex) {
            return null;
        }
    }
}
