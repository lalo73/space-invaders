package scenes.statics;

import components.BasicSpaceComponent;

public class PressStartScene extends StaticScene{

    @Override
    public void setBackground(){
        BasicSpaceComponent component = new BasicSpaceComponent(getGame().getResource("pressStart"), 0, 0);
        addComponent(component);
    }
}
