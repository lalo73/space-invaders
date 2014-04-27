package scenes.statics;


import components.BasicSpaceComponent;

public class GameOver extends StaticScene  {

    @Override
    public void setBackground(){
        BasicSpaceComponent component = new BasicSpaceComponent(getGame().getResource("gameOverBackground"), 0, 0);
        addComponent(component);
    }
}
