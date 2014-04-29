package scenes.statics;


import components.BasicSpaceComponent;
import components.keyManagers.KeyManager;
import components.keyManagers.text.PressStart;
import components.keyManagers.text.SelectableText;

import java.util.ArrayList;
import java.util.List;

public class GameOver extends StaticScene {

    @Override
    public BasicSpaceComponent getBackground() {
        return new BasicSpaceComponent(getGame().getResource("gameOverBackground"), 0, 0);
    }

    @Override
    public KeyManager getKeyManager() {
        List<SelectableText> selectableTexts = new ArrayList<SelectableText>();
        selectableTexts.add(new PressStart());
        return new KeyManager(selectableTexts.get(0), selectableTexts);
    }
}
