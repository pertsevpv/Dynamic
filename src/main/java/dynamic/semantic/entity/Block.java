package dynamic.semantic.entity;

import dynamic.exception.ValidationException;
import dynamic.interpret.Executable;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.lit.BoolConst;
import dynamic.semantic.entity.statement.*;

import java.util.ArrayList;
import java.util.List;

public class Block implements Validatable, Printable, Optimizable<Block>, Executable {

  public List<Statement> block;

  public Block(List<Statement> block) {
    this.block = block;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    boolean hasReturn = false;
    for (var stat: block) {
      stat.validate(context);
      if (hasReturn) {
        System.out.println(String.format("%s statement %s is unreachable\n", stat.span, stat));
        stat.isReachable = false;
      }
      if (stat instanceof Return) hasReturn = true;
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    for (var stat: block) {
      stat.print(depth + 1, sb);
      sb.append("\n");
    }
  }

  @Override
  public Block optimize() {
    List<Statement> newBlock = new ArrayList<>();
    for (var stat: block) {
      if (!stat.isReachable) continue;
      if (stat instanceof DeclarationList list) {
        optimizeDeclList(list, newBlock);
      } else if (stat instanceof If iff) {
        optimizeIf(iff, newBlock);
      } else {
        var optimized = stat.optimize();
        if (optimized != null) newBlock.add(optimized);
      }
    }
    return new Block(newBlock);
  }

  private static void optimizeDeclList(DeclarationList list, List<Statement> newBlock) {
    for (var decl: list.declarations) {
      var optimized = decl.optimize();
      if (optimized != null) newBlock.add(optimized);
    }
  }

  private static void optimizeIf(If iff, List<Statement> newBlock) {
    var optimizedCond = iff.cond.optimize();
    if (iff.cond instanceof BoolConst boolConst) {
      if (boolConst.value) {
        newBlock.addAll(iff.ifBlock.block);
      } else {
        if (iff.elseBlock == null) return;
        newBlock.addAll(iff.elseBlock.block);
      }
    }
    if (iff.elseBlock == null) newBlock.add(new If(optimizedCond, iff.ifBlock.optimize(), iff.span));
    else newBlock.add(new If(optimizedCond, iff.ifBlock.optimize(), iff.elseBlock.optimize(), iff.span));
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    for (Statement statement : block) {
      statement.execute(memory, valueStack, stackFrame);
      if (statement instanceof Return || stackFrame.returned) return;
    }
  }
}
