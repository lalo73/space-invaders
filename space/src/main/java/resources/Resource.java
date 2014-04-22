package resources;


import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.exceptions.GameException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Resource extends Sprite{

    public Resource(BufferedImage image) {
        super(image);
    }

    public static Resource fromImage(String imageFileName) {
        BufferedImage image;

        try {
            image = ImageIO.read(Resource.class.getResource(imageFileName));
        }
        catch(Exception e) {
            throw new GameException("The resource '" + imageFileName + "' was not found");
        }

        return new Resource(image);
    }
    
    
}
