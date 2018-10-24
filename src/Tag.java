public class Tag {
    int index;
    char symbol ;

    public Tag(int index, char symbol) {
        this.index = index;
        this.symbol = symbol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "< "+getIndex()+" , "+getSymbol()+" >";
    }
}
