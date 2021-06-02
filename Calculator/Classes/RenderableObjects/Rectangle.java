package Classes.RenderableObjects;

import Classes.Renderable;

public class Rectangle extends Renderable {

    public Rectangle(){
        super();
    }

    public Rectangle(double posX,double posY){
        super(posX,posY);
    }

    public Rectangle(double posX,double posY,double sizeX,double sizeY){
        super(posX,posY,sizeX,sizeY);
    }

    @Override
    public void render() {
        pencil.bewegeBis(posX,posY);
        pencil.zeichneRechteck(sizeX,sizeY);
    }
}
