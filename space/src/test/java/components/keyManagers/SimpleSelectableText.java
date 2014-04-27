package components.keyManagers;

import com.uqbar.vainilla.GameScene;
import components.keyManagers.text.SelectableText;

public class SimpleSelectableText extends SelectableText{
    @Override
    public GameScene nextScene() {
        return new GameScene();
    }
}
