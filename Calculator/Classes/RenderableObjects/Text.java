package Classes.RenderableObjects;

import Classes.Renderable;
import sum.kern.Buntstift;

//sizeX & size Y not used
// maybe bounds of textbox?

public class Text extends Renderable {

    private String text;
    private int writingSize = 20;

    public Text(){
        this("",0,0);
    }

    public Text(String text) {
        this(text,0,0);
    }

    public Text(String text, double posX,double posY ){
        super(posX,posY);
        this.text=text;

    }

    @Override
    public void render() {

        if(sizeX == 0 && sizeY == 0) {  // writes the text at the given position (position = top left corner of text)
            pencil.bewegeBis(posX, posY + writingSize);
            pencil.setzeSchriftGroesse(writingSize);
            pencil.schreibeText(text);
        }else{//roughly centers the text in the middle of the given box dimensions
            pencil.bewegeBis(posX + sizeX / 2 - writingSize * text.length() / 4.2, posY + sizeY / 2 + writingSize / 3);
            pencil.setzeSchriftGroesse(writingSize);
            pencil.schreibeText(text);
        }
    }

    public void setSize(int size) {
        pencil.setzeSchriftGroesse(size);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWritingSize() {
        return writingSize;
    }

    public void setWritingSize(int writingSize) {
        this.writingSize = writingSize;
    }
}
