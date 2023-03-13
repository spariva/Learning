package mineSeeker.src;

public class Cell {
    private boolean bomb = false;
    private boolean visible = false;
    private Integer value = 0;

    public Cell(){
    }

    public boolean getBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        if(visible){
        String cad = (bomb) ? "*" : ""+value;
        return cad;
    }else{
        return "+";
    }
    }

}
