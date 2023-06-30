package utilidades;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Archivos {
    public static BufferedImage cargarSprites(SpritesURL spritesURL) {
        BufferedImage img = null;
        InputStream is = Archivos.class.getClassLoader().getResourceAsStream(spritesURL.getSpriteURL());
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return img;
    }
}
