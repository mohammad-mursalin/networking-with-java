import javax.swing.*;

public class ImageDisplay {

    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load Image
        ImageIcon imageIcon = new ImageIcon("image.jpg");

        // Create Label and add image to it
        JLabel label = new JLabel(imageIcon);

        // Add label to frame
        frame.add(label);

        // Adjust frame size
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
