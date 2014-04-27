package components.keyManagers.text;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.events.constants.Key;
import components.BasicSpaceComponent;

public abstract class SelectableText extends BasicSpaceComponent {
    private boolean selected;
    private Key enterKey = Key.ENTER;

    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if (isSelected() && enterKeyPressed(deltaState))
            getGame().setCurrentScene(nextScene());
    }

    public abstract GameScene nextScene();

    public boolean enterKeyPressed(DeltaState deltaState) {
        return deltaState.isKeyReleased(getEnterKey());
    }

    public void select() {
        setSelected(true);
    }

    public void deselect() {
        setSelected(false);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Key getEnterKey() {
        return enterKey;
    }

    public void setEnterKey(Key enterKey) {
        this.enterKey = enterKey;
    }
}
