package imageviewer.controller;

import imageviewer.view.ui.SwingImageDisplay;
import imageviewer.view.ui.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    
    private SwingImageDisplay imageDisplay;

    public MainFrame() {
        ini();
    } 
    
    private void ini() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay(), BorderLayout.CENTER);
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.show(imageDisplay.current().prev());
            }
        });
        return button; 
    }
    
    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.show(imageDisplay.current().next());
            }
        });
        return button; 
    }
    
    private JPanel imageDisplay() {
        imageDisplay = new SwingImageDisplay();
        return imageDisplay;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
