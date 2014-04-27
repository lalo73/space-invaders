package scenes.statics;

import com.uqbar.vainilla.GameScene;
import components.BasicSpaceComponent;
import resources.Resource;
import space.SpaceGame;


public class StaticScene extends GameScene {

    @Override
    public void onSetAsCurrent(){
        super.onSetAsCurrent();
        BasicSpaceComponent component = new BasicSpaceComponent(getGame().getResource("gameOverBackground"), 0, 0);
        addComponent(component);
    }

    @Override
    public SpaceGame getGame(){
        return (SpaceGame) super.getGame();
    }
}
