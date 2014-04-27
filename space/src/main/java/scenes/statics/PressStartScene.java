package scenes.statics;

import components.BasicSpaceComponent;

public class PressStartScene extends StaticScene{

    @Override
    public BasicSpaceComponent getBackground(){
        return new BasicSpaceComponent(getGame().getResource("pressStart"), 0, 0);
    }
}
