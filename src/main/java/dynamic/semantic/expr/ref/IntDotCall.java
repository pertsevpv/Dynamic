package dynamic.semantic.expr.ref;

public class IntDotCall extends Reference {
  public Reference ref;
  public int label;

  public IntDotCall(Reference ref, int label) {
    super(ref.span);
    this.ref = ref;
    this.label = label;
  }
}
