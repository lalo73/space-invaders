package components;


import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.SpaceScene;
import space.SpaceGame;

public class BasicSpaceComponent extends GameComponent<SpaceScene> {
    public BasicSpaceComponent(Appearance appearance, double x, double y){
        super(appearance, x, y);
    }

    public BasicSpaceComponent() {
        super();
    }

    @Override
    public SpaceGame getGame(){
        return (SpaceGame) super.getGame();
    }
}
