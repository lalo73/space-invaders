package pool;


import components.invaders.Invader;
import pool.makers.InvaderMaker;
import space.SpaceGame;

public class InvadersPool extends Pool<Invader>{
    public InvadersPool(SpaceGame spaceGame) {
        super(new InvaderMaker(spaceGame));
    }

    @Override
    protected Invader create() {
        return getComponentMaker().create();
    }
}
