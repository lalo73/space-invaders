package components.keyManagers;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;
import components.BasicSpaceComponent;
import components.keyManagers.text.SelectableText;

import java.util.ArrayList;
import java.util.List;

public class KeyManager extends BasicSpaceComponent {

    private Key nextKey = Key.DOWN;
    private Key prevKey = Key.UP;
    private SelectableText current;
    private List<SelectableText> selectableTexts = new ArrayList<SelectableText>();

    public KeyManager(SelectableText current, List<SelectableText> selectableTexts){
        super(0,0);
        setSelectableTexts(selectableTexts);
        setCurrent(current);
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if (nextKeyHasPressed(deltaState))
            selectNext();
        else if (prevKeyHasPressed(deltaState))
            selectPrev();

    }

    public boolean nextKeyHasPressed(DeltaState deltaState) {
        return deltaState.isKeyReleased(getNextKey());
    }

    public boolean prevKeyHasPressed(DeltaState deltaState) {
        return deltaState.isKeyReleased(getPrevKey());
    }

    public void selectNext() {
        getCurrent().deselect();
        SelectableText next = getNextTo(getCurrent());
        setCurrent(next);
    }

    public SelectableText getNextTo(SelectableText current){
        int currentIndex = getSelectableTexts().indexOf(current);
        int nextCurrent = currentIndex + 1;
        if(nextCurrent == getSelectableTexts().size())
            nextCurrent = 0;
        return getSelectableTexts().get(nextCurrent);
    }

    public SelectableText selectPrev() {
        int currentIndex = getSelectableTexts().indexOf(current);
        int prevCurrent = currentIndex - 1;
        if(prevCurrent == 0)
            prevCurrent = getSelectableTexts().size() - 1;
        return getSelectableTexts().get(prevCurrent);
    }

    public Key getNextKey() {
        return nextKey;
    }

    public void setNextKey(Key nextKey) {
        this.nextKey = nextKey;
    }

    public Key getPrevKey() {
        return prevKey;
    }

    public void setPrevKey(Key prevKey) {
        this.prevKey = prevKey;
    }

    public List<SelectableText> getSelectableTexts() {
        return selectableTexts;
    }

    public void setSelectableTexts(List<SelectableText> selectableTexts) {
        this.selectableTexts = selectableTexts;
    }

    public SelectableText getCurrent() {
        return current;
    }

    public void setCurrent(SelectableText current) {
        current.select();
        this.current = current;
    }
}
