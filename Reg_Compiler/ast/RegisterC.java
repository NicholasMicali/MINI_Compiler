package ast;

public class RegisterC {
    
    private int counter;

    public RegisterC()
    {
        this.counter = -1;
    }

    public String newReg()
    {
        counter += 1;
        return "%r" + counter;
    }

    public String newVal()
    {
        counter += 1;
        return "" + counter;
    }

    public void decrementReg(int c)
    {
        counter = counter - c;
    }

}
