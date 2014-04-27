package components.keyManagers;

import components.keyManagers.text.SelectableText;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class KeyManagerTest extends TestCase {

    private KeyManager keyManager;
    private SelectableText current;
    private List<SelectableText> selectableTexts;

    @Override
    public void setUp() {

        selectableTexts = new ArrayList<SelectableText>();
        for (int i = 0; i < 5; i++) {
            selectableTexts.add(new SimpleSelectableText());
        }
        current = selectableTexts.get(0);
        keyManager = new KeyManager(current, selectableTexts);

    }

    public void testNextOfFirst() {
        SelectableText suppoustNext = selectableTexts.get(1);
        keyManager.selectNext();
        assertEquals(suppoustNext, keyManager.getCurrent());
    }

    public void testNextOfLast() {
        SelectableText suppoustNext = selectableTexts.get(0);
        keyManager.setCurrent(selectableTexts.get(selectableTexts.size() - 1));
        keyManager.selectNext();
        assertEquals(suppoustNext, keyManager.getCurrent());
    }

}
