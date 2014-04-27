package scenes.statics;

import com.uqbar.vainilla.GameScene;
import components.BasicSpaceComponent;
import space.SpaceGame;


public abstract class StaticScene extends GameScene {

    public abstract  BasicSpaceComponent getBackground();

    @Override
    public void onSetAsCurrent(){
        super.onSetAsCurrent();
        addComponent(getBackground());
    }

    @Override
    public SpaceGame getGame(){
        return (SpaceGame) super.getGame();
    }
}
