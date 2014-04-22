package pool;


import pool.makers.ComponentMaker;

import java.util.ArrayList;
import java.util.List;

public abstract class Pool<Component> {
    List<Component> componentList;
    ComponentMaker<Component> componentMaker;

    public Pool(ComponentMaker<Component> componentMaker) {
        setComponentList(new ArrayList<Component>());
        this.componentMaker = componentMaker;
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

    public ComponentMaker<Component> getComponentMaker() {
        return componentMaker;
    }

    public void setComponentMaker(ComponentMaker<Component> componentMaker) {
        this.componentMaker = componentMaker;
    }
}
