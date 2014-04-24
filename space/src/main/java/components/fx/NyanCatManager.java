package components.fx;


import resources.Resource;
import space.SpaceGame;

public class NyanCatManager extends FXManager{
    private NyanCat nyanCat;

    @Override
    public int runEvery() {
        return 20;
    }

    @Override
    public void showFX() {
        if(getNyanCat() == null) {
            initNyanCat();
        }
        getScene().addComponent(nyanCat);
    }

    public void initNyanCat(){
        SpaceGame game = getGame();
        Resource resource = game.getResource("nyanCat");
        double x = 0 - resource.getWidth();
        double y = game.getDisplayHeight() / 2;
        NyanCat nyanCat = new NyanCat(resource,x, y, 1, 0, 200);
        setNyanCat(nyanCat);
    }


    public NyanCat getNyanCat() {
        return nyanCat;
    }

    public void setNyanCat(NyanCat nyanCat) {
        this.nyanCat = nyanCat;
    }
}
