package mineSeeker.src;
//dead code, finals, buvle foriforj para el patrón 8
public class Cell {
    private boolean bomb = false;
    private boolean isVisible = false;
    private Integer value;

    public Cell(){
   
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
