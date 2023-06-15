package ast;

public class LabelCounter {
    
    private int counter;

    public LabelCounter()
    {
        this.counter = -1;
    }

    public String newLabel()
    {
        counter += 1;
        return "LU" + counter;
    }
}