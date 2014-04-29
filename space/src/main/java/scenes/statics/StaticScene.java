package scenes.statics;

import com.uqbar.vainilla.GameScene;
import components.BasicSpaceComponent;
import components.keyManagers.KeyManager;
import scenes.BasicSpaceScene;
import space.SpaceGame;


public abstract class StaticScene extends BasicSpaceScene {

    public abstract BasicSpaceComponent getBackground();

    public abstract KeyManager getKeyManager();

    @Override
    public void onSetAsCurrent() {
        addComponent(getBackground());
        KeyManager keyManager = getKeyManager();
        addComponent(keyManager);
        addComponents(keyManager.getSelectableTexts());
        super.onSetAsCurrent();
    }

    @Override
    public SpaceGame getGame() {
        return (SpaceGame) super.getGame();
    }
}
