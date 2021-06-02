package Classes.RenderableObjects;

import Classes.Renderable;

public class Textfield extends Text {

    @Override
    public void render() {
        pencil.bewegeBis(posX,posY);
        pencil.zeichneRechteck(sizeX,sizeY);
        super.render();

    }
}
