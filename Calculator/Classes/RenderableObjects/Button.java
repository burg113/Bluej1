package Classes.RenderableObjects;

import Classes.Renderable;

//implement check if clicked

public class Button extends Text{

    @Override
    public void render() {
        pencil.bewegeBis(posX,posY);
        pencil.zeichneRechteck(sizeX,sizeY);
        super.render();

    }
}
