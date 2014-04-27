package scenes.statics;


import components.BasicSpaceComponent;

public class GameOver extends StaticScene {

    @Override
    public BasicSpaceComponent getBackground() {
        return new BasicSpaceComponent(getGame().getResource("gameOverBackground"), 0, 0);
    }
}
