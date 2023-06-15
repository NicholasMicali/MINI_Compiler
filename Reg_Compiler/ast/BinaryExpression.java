package ast;

import java.util.List;
import java.util.HashMap;


public class BinaryExpression
   extends AbstractExpression
{
   private final Operator operator;
   private final Expression left;
   private final Expression right;

   private BinaryExpression(int lineNum, Operator operator,
      Expression left, Expression right)
   {
      super(lineNum);
      this.operator = operator;
      this.left = left;
      this.right = right;
   }

   public static BinaryExpression create(int lineNum, String opStr,
      Expression left, Expression right)
   {
      switch (opStr)
      {
         case TIMES_OPERATOR:
            return new BinaryExpression(lineNum, Operator.TIMES, left, right);
         case DIVIDE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.DIVIDE, left, right);
         case PLUS_OPERATOR:
            return new BinaryExpression(lineNum, Operator.PLUS, left, right);
         case MINUS_OPERATOR:
            return new BinaryExpression(lineNum, Operator.MINUS, left, right);
         case LT_OPERATOR:
            return new BinaryExpression(lineNum, Operator.LT, left, right);
         case LE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.LE, left, right);
         case GT_OPERATOR:
            return new BinaryExpression(lineNum, Operator.GT, left, right);
         case GE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.GE, left, right);
         case EQ_OPERATOR:
            return new BinaryExpression(lineNum, Operator.EQ, left, right);
         case NE_OPERATOR:
            return new BinaryExpression(lineNum, Operator.NE, left, right);
         case AND_OPERATOR:
            return new BinaryExpression(lineNum, Operator.AND, left, right);
         case OR_OPERATOR:
            return new BinaryExpression(lineNum, Operator.OR, left, right);
         default:
            throw new IllegalArgumentException();
      }
   }

   private static final String TIMES_OPERATOR = "*";
   private static final String DIVIDE_OPERATOR = "/";
   private static final String PLUS_OPERATOR = "+";
   private static final String MINUS_OPERATOR = "-";
   private static final String LT_OPERATOR = "<";
   private static final String LE_OPERATOR = "<=";
   private static final String GT_OPERATOR = ">";
   private static final String GE_OPERATOR = ">=";
   private static final String EQ_OPERATOR = "==";
   private static final String NE_OPERATOR = "!=";
   private static final String AND_OPERATOR = "&&";
   private static final String OR_OPERATOR = "||";

   public static enum Operator
   {
      TIMES, DIVIDE, PLUS, MINUS, LT, GT, LE, GE, EQ, NE, AND, OR
   }

   public static String opType(Operator op)
   {
      if (op == Operator.TIMES){
         return "mul";
      }
      else if (op == Operator.DIVIDE){
         return "sdiv";
      }
      else if (op == Operator.PLUS){
         return "add";
      }
      else if (op == Operator.MINUS){
         return "sub";
      }
      else if (op == Operator.LT){
         return "slt";
      }
      else if (op == Operator.GT){
         return "sgt";
      }
      else if (op == Operator.LE){
         return "sle";
      }
      else if (op == Operator.GE){
         return "sge";
      }
      else if (op == Operator.EQ){
         return "eq";
      }
      else if (op == Operator.NE){
         return "ne";
      }
      else if (op == Operator.AND){
         return "and";
      }
      else if (op == Operator.OR){
         return "or";
      }
      return "idk";
   }


   public String typeCheck(HashMap<String, HashMap<String, Type>> typeTable, HashMap<String, Type> symbolTable, HashMap<String, Type> localTable)
   {
      String leftType = left.typeCheck(typeTable, symbolTable, localTable);
      String rightType = right.typeCheck(typeTable, symbolTable, localTable);
      //System.out.println(leftType);
      if ((operator == Operator.PLUS) || (operator == Operator.MINUS) || (operator == Operator.TIMES) || (operator == Operator.DIVIDE))
      {
         if ((leftType == "int") && (rightType == "int"))
         {
            return "int";
         }
         else {
            System.out.println("Error: binary numeric expression contains non int at line: " + super.lineNum);
            return "int";
         }
      }
      if ((operator == Operator.LT) || (operator == Operator.LE) || (operator == Operator.GT) || (operator == Operator.GE))
      {
         if ((leftType == "int") && (rightType == "int"))
         {
            return "bool";
         }
         else {
            System.out.println("Error: binary numeric expression contains non int at line: " + super.lineNum);
            return "bool";
         }
      }
      else if ((operator == Operator.AND) || (operator == Operator.OR))
      {
         if ((leftType == "bool") && (rightType == "bool"))
         {
            return "bool";
         }
         else {
            System.out.println("Error: binary numeric expression contains non boolean at line: " + super.lineNum);
            return "bool";
         }
      }
      else if ((operator == Operator.EQ) || (operator == Operator.NE)){
         if ((leftType.equals(rightType)) || ((leftType == "null") && (rightType != "int") && (rightType != "bool")) || 
                                        ((rightType == "null") && (leftType != "int") && (leftType != "bool")))
         {
            return "bool";
         }
         else {
            System.out.println("Error: equivalence expression contains non matching types at line: " + super.lineNum);
            System.out.println(leftType + " " + rightType);
            return "bool";
         }
      }
      else {
         System.out.println("wrong binary expression");
         return "null";
      }
   }

   public VT llvm(List<Instruction> instructions, RegisterC counter, HashMap<String, List<Declaration>> structList, HashMap<String, VT> varMap, BasicBlock curr)
   {
      VT leftVT = left.llvm(instructions, counter, structList, varMap, curr);
      VT rightVT = right.llvm(instructions, counter, structList, varMap, curr);
      String leftReg = leftVT.Reg;
      String rightReg = rightVT.Reg;
      String result = counter.newReg();
      String tResult;
      if ((operator == Operator.PLUS) || (operator == Operator.MINUS) || (operator == Operator.TIMES) || (operator == Operator.DIVIDE))
      {
         instructions.add(new ArithmeticInstruction(result, opType(operator), "i64", leftReg, rightReg));
      }
      else if ((operator == Operator.AND) || (operator == Operator.OR))
      {
         instructions.add(new BitInstruction(result, "trunc", "i64", leftReg, "i1"));
         String truncRResult = counter.newReg();
         instructions.add(new BitInstruction(truncRResult, "trunc", "i64", rightReg, "i1"));
         String truncResult = counter.newReg();
         instructions.add(new BooleanInstruction(truncResult, opType(operator), "i1", result, truncRResult));
         tResult = counter.newReg();
         instructions.add(new BitInstruction(tResult, "zext", "i1", truncResult, "i64"));
         return new VT(tResult, "i64");
      }
      else 
      {
         String ty = leftVT.ty;
         if (ty.equals("null"))
         {
            ty = rightVT.ty;
            if (ty.equals("null"))
            {
               ty = "i64";
            }
         }
         

         instructions.add(new ComparisonInstruction(result, opType(operator), ty, leftReg, rightReg));
         String iResult = counter.newReg();
         instructions.add(new BitInstruction(iResult, "zext", "i1", result, "i64"));
         return new VT(iResult, "i64");
      }
      return new VT(result, "i64");
   }

   public String getID()
   {
      return "not good";
   }

   public String pointerOrNum(HashMap<String, String> structVarMap)
   {
      String l = left.pointerOrNum(structVarMap);
      if (l.equals("null"))
      {
         l = right.pointerOrNum(structVarMap);
         if (l.equals("null"))
         {
            l = "164";
         }
      }
      return l;

   }
}
