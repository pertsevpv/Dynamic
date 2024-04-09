package dynamic.semantic.entity.expr.lit;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (definedLabels.contains(e.id.name)) throw new ValidationException("Tuple %s have dublicated label %s".formatted(this, e.id.name));
        definedLabels.add(e.id.name);
      }
    }
    this.type = Type.TUPLE;
  }

  public static class TupleElem {
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
  }
}
