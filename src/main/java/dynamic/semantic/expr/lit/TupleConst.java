package dynamic.semantic.expr.lit;

import dynamic.semantic.Id;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.expr.Expr;

import java.util.List;

public class TupleConst extends Const<List<TupleConst.TupleElem>> {

  public TupleConst(List<TupleElem> tuple, Span span) {
    super(tuple, Type.TUPLE, span);
  }

  public static class TupleElem {
    public Id id;
    public Expr value;

    public TupleElem(Expr value) {
      this(null , value);
    }

    public TupleElem(Id id, Expr value) {
      this.id = id;
      this.value = value;
    }

    @Override
    public String toString() {
      if (id == null) return value.toString();
      else return "%s := %s".formatted(id, value);
    }
  }
}
