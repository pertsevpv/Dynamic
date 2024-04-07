package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.expr.Expr;

import java.util.List;

public class Tuple extends Expr {

  public List<TupleElem> tuple;

  public Tuple(List<TupleElem> tuple, Span span) {
    super(span);
    this.type = Type.TUPLE;
    this.tuple = tuple;
  }

  public static class TupleElem {
    public String label;
    public Expr value;

    public TupleElem(Expr value) {
      this(null , value);
    }

    public TupleElem(String label, Expr value) {
      this.label = label;
      this.value = value;
    }

    @Override
    public String toString() {
      if (label == null) return value.toString();
      else return "%s := %s".formatted(label, value);
    }
  }
}
