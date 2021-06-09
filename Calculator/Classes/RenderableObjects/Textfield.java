package Classes.RenderableObjects;

import Classes.Renderable;
import sum.kern.Maus;
import sum.kern.Tastatur;

import java.awt.*;

public class Textfield extends Button {

    private Tastatur keyBoard;
    private boolean inFocus;

    public Textfield(double posX, double posY, int sizeX, int sizeY, Maus mouse,Tastatur keyBoard) {
        super(posX, posY,sizeX,sizeY,mouse);
        this.keyBoard=keyBoard;

        setHoverColor(Color.white);
        setClickColor(Color.gray);
    }

    @Override
    public void render() {
        super.render();
    }

    public void update(){
        while (keyBoard.wurdeGedrueckt()) {
            if (inFocus) {
                if(keyBoard.zeichen() == 'Ǽ'){
                    if(getText().length()>0) setText(getText().substring(0,getText().length()-1));
                }else {
                    setText(getText() + keyBoard.zeichen());
                }
            }
            keyBoard.weiter();
        }

        if(!inFocus){
            inFocus = clicked();
        }

        if(inFocus && getMouse().istGedrueckt() && !clicked()){
            inFocus = false;
        }


    }

}
