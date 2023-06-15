package ast;

import java.util.List;

public abstract class AbstractExpression
   implements Expression
{
   public final int lineNum;

   public AbstractExpression(int lineNum)
   {
      this.lineNum = lineNum;
   }
}
