package Classes.RenderableObjects;

import Classes.Renderable;
import sum.kern.Maus;

import java.awt.*;

//implement check if clicked

public class Button extends Text{

    private Color hoverColor = Color.gray;
    private Color clickColor = Color.orange;

    private Maus mouse;

    public Button() {
        super();
    }

    public Button(String text, double posX, double posY,int sizeX,int sizeY,Maus mouse) {
        super(text, posX, posY);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.mouse = mouse;
    }

    public Button(double posX, double posY,int sizeX,int sizeY,Maus mouse) {
        super("", posX, posY);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.mouse = mouse;
    }

    @Override
    public void render() {

        pencil.bewegeBis(posX,posY);

        if(clicked()){
            fill(clickColor);
        }else if(hovered()){
            fill(hoverColor);
        }

        pencil.zeichneRechteck(sizeX,sizeY);

        super.render();

    }

    private void fill(Color color){
        pencil.setzeFuellMuster(1);
        pencil.setzeFarbe(color);
        pencil.zeichneRechteck(sizeX,sizeY);
        pencil.setzeFuellMuster(0);
        pencil.setzeFarbe(this.color);
    }


    public boolean clicked() {
        return hovered() && mouse.istGedrueckt();
    }

    public boolean hovered(){
        return mouse.hPosition() > posX && mouse.hPosition() < posX + sizeX
                && mouse.vPosition() > posY && mouse.vPosition() < posY + sizeY;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    public Color getClickColor() {
        return clickColor;
    }

    public void setClickColor(Color clickColor) {
        this.clickColor = clickColor;
    }

    public Maus getMouse() {
        return mouse;
    }

    public void setMouse(Maus mouse) {
        this.mouse = mouse;
    }
}
