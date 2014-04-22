package pool;


import java.util.ArrayList;
import java.util.List;

public abstract class Pool<Component> {
    List<Component> componentList;

    public Pool() {
        setComponentList(new ArrayList<Component>());
    }

    public Component get(){
        Component component;
        if(getComponentList().isEmpty()){
            component = this.create();
        } else {
            component = getComponentList().remove(0);
        }
        return component;

    }

    public void add(Component component){
        getComponentList().add(component);
    }

    protected abstract Component create();

    protected List<Component> getComponentList() {
        return componentList;
    }

    protected void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }
}
