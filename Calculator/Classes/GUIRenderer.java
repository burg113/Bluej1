package Classes;

import Classes.Renderable;

import java.util.*;

public class GUIRenderer {

    List<Renderable> renderables = new ArrayList<Renderable>();

    public GUIRenderer(){}

    public void render(){
        for (Renderable r : renderables) {
            r.render();
        }
    }

    public void add(Renderable renderable){
        renderables.add(renderable);
    }

    public void remove(Renderable renderable){
        renderables.remove(renderable);
    }


}
