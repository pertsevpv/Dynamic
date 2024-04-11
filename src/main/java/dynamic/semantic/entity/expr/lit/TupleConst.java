package dynamic.semantic.entity.expr.lit;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Optimizable;
import dynamic.semantic.entity.Printable;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TupleConst extends Const<List<TupleConst.TupleElem>> {

  public TupleConst(List<TupleElem> tuple, Span span) {
    super(tuple, Type.TUPLE, span);
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    Set<String> definedLabels = new HashSet<>();
    for (var e: value) {
      e.value.validate(context);
      if (e.id != null) {
        if (definedLabels.contains(e.id.name)) throw new ValidationException(span, "Tuple %s have duplicated label %s".formatted(this, e.id.name));
        definedLabels.add(e.id.name);
      }
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("{");
    if (!value.isEmpty()) {
      value.get(0).print(depth, sb);
      for (int i = 1; i < value.size(); i++)
        value.get(i).print(depth, sb.append(", "));
    }
    sb.append("}");
  }

  @Override
  public Expr optimize() {
    return new TupleConst(value.stream().map(Optimizable::optimize).toList(), span);
  }

  public static class TupleElem implements Printable, Optimizable<TupleElem> {
    public Id id;
    public Expr value;

    public TupleElem(Expr value) {
      this(null, value);
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

    @Override
    public void print(int depth, StringBuilder sb) {
      if (id != null) sb.append(id).append(" := ");
      value.print(depth, sb);
    }

    @Override
    public TupleElem optimize() {
      return new TupleElem(id, value.optimize());
    }
  }
}
