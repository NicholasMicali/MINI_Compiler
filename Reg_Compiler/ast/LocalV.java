package ast;

public class LocalV {
    
  public String result;
  public String op;
  public String left;
  public String right;


  public LocalV(String result, String op, String left, String right)
  {
    this.result = result;
    this.op = op;
    this.left = left;
    this.right = right;
  }

  public LocalV(String result)
  {
    this.result = result;
    this.op = "var";
    this.left = "null";
    this.right = "null";
  }

}