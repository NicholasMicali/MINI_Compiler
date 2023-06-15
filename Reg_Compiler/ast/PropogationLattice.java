package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PropogationLattice
{
  public static String PropLattice(String r1, String r2)
  {
    String left = r1;//"top";
    String right = r2;//"top";


    if ((left.equals("top")) && (right.equals("top")))
    {
      return "top";
    }
    else if ((left.equals("bottom")) || (right.equals("bottom")))
    {
      return "bottom";
    }
    else if (left.equals("top"))
    {
      return right;
    }
    else if (right.equals("top"))
    {
      return left;
    }
    else
    {
      return "calc";
    }
  }
}