package scenes.statics;

import com.uqbar.vainilla.GameScene;
import space.SpaceGame;


public abstract class StaticScene extends GameScene {

    public void setBackground(){

    }

    @Override
    public void onSetAsCurrent(){
        super.onSetAsCurrent();
        setBackground();
    }

    @Override
    public SpaceGame getGame(){
        return (SpaceGame) super.getGame();
    }
}
