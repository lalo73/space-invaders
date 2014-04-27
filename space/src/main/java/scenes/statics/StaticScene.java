package scenes.statics;

import com.uqbar.vainilla.GameScene;
import components.BasicSpaceComponent;
import resources.Resource;


public class StaticScene extends GameScene {

    @Override
    public void onSetAsCurrent(){
        super.onSetAsCurrent();
        BasicSpaceComponent component = new BasicSpaceComponent(Resource.fromImage("gameOverBackground"), 0, 0);
        addComponent(component);
    }
}
