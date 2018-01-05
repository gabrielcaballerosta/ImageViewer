package imageviewer.controller;

import imageviewer.view.persistence.FileImageLoader;
import imageviewer.model.Image;
import java.io.File;
import java.io.IOException;

public class ImageViewer {

    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\Gabriel\\Pictures\\Imagen");
        FileImageLoader listImage = new FileImageLoader(folder);
        Image image = listImage.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
