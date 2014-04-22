package pool.makers;

import space.SpaceGame;


public abstract class ComponentMaker<Component> {
    SpaceGame game;

    public ComponentMaker(SpaceGame spaceGame){
        setGame(spaceGame);
    }

    public abstract Component create();

    public SpaceGame getGame() {
        return game;
    }

    public void setGame(SpaceGame game) {
        this.game = game;
    }
}
