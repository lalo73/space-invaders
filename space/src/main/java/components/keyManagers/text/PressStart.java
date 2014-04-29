package components.keyManagers.text;

import com.uqbar.vainilla.GameScene;
import scenes.levels.Level1;

public class PressStart extends SelectableText{
    @Override
    public GameScene nextScene() {
        return new Level1();
    }
}
