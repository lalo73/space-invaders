package components.fx;


import resources.Resource;
import space.SpaceGame;

public class NyanCatManager extends FXManager {
    private NyanCat nyanCat;

    @Override
    public int runEvery() {
        return 20;
    }

    @Override
    public void showFX() {
        initNyanCat();
        getScene().addComponent(nyanCat);
    }

    public void initNyanCat() {
        SpaceGame game = getGame();
        Resource resource = game.getResource("helicop");
        double x = 0 - resource.getWidth();
        double y = game.getDisplayHeight() / 2;
        if (getNyanCat() == null)
            setNyanCat(new NyanCat(resource, x, y, 1, 0, 200, this));
        else {
            getNyanCat().setDestroyPending(false);
            getNyanCat().setX(x);
            getNyanCat().setY(y);
        }

    }


    public NyanCat getNyanCat() {
        return nyanCat;
    }

    public void setNyanCat(NyanCat nyanCat) {
        this.nyanCat = nyanCat;
    }
}
