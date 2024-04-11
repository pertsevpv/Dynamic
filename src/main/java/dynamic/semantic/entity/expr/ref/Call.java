package dynamic.semantic.entity.expr.ref;

public abstract class Call extends Reference {

  public Reference ref;

  public Call(Reference ref) {
    super(ref.span);
    this.ref = ref;
  }
}
