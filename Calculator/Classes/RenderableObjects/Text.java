package Classes.RenderableObjects;

import Classes.Renderable;
import sum.kern.Buntstift;

//sizeX & size Y not used
// maybe bounds of textbox?

public class Text extends Renderable {

    private String text;
    private int writingSize;

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
        pencil.bewegeBis(posX,posY);
        pencil.setzeSchriftGroesse(writingSize);
        pencil.schreibeText(text);
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
