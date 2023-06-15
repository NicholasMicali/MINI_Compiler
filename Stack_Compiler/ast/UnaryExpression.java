package ast;

import java.util.List;
import java.util.HashMap;

public class UnaryExpression
   extends AbstractExpression
{
   private final Operator operator;
   private final Expression operand;

   private UnaryExpression(int lineNum, Operator operator, Expression operand)
   {
      super(lineNum);
      this.operator = operator;
      this.operand = operand;
   }

   public static UnaryExpression create(int lineNum, String opStr,
      Expression operand)
   {
      if (opStr.equals(NOT_OPERATOR))
      {
         return new UnaryExpression(lineNum, Operator.NOT, operand);
      }
      else if (opStr.equals(MINUS_OPERATOR))
      {
         return new UnaryExpression(lineNum, Operator.MINUS, operand);
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }

   private static final String NOT_OPERATOR = "!";
   private static final String MINUS_OPERATOR = "-";

   public static enum Operator
   {
      NOT, MINUS
   }

   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      String op = operand.typeCheck(typeTable, symbolTable, localTable);
      if ((operator == Operator.NOT) && (op == "bool"))
      {
         return "bool";
      }
      else if ((operator == Operator.MINUS) && (op == "int"))
      {
         return "int";
      }
      else 
      {
         System.out.println("Error: operator does not match the type of the operand");
         return null;
      }
   }

   public String llvm(List<Instruction> instructions, RegisterC counter, List<String> params, HashMap<String, List<Declaration>> structList, HashMap<String, String> structVarMap, List<String> globs)
   {
      String Reg = operand.llvm(instructions, counter, params, structList, structVarMap, globs);
      String result = counter.newReg();
      if ((operator == Operator.NOT))
      {
         //instructions.add(new BooleanInstruction(result, "and", "i64", opVT.Reg, "0"));
         instructions.add(new ComparisonInstruction(result, "eq", "i64", Reg, "0"));
         String iResult = counter.newReg();
         instructions.add(new BitInstruction(iResult, "zext", "i1", result, "i64"));
         result = iResult;
      }
      else 
      {
         //String result = counter.newReg();
         instructions.add(new ArithmeticInstruction(result, "sub", "i64", "0", Reg));
      }
      return result;
   }

   public String getID()
   {
      return "i64";
   }
   public String pointerOrNum(HashMap<String, String> structVarMap)
   {
      return "i64";
   }
   
}
