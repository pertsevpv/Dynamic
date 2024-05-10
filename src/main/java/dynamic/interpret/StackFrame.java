package dynamic.interpret;

import dynamic.interpret.obj.DynaObject;

public class StackFrame {

  public StackFrame parent;
  public Scope scope;
  public int returnAddress;
  public boolean returned = false;

  public StackFrame(StackFrame parent, int returnAddress) {
    this.parent = parent;
    this.scope = new Scope(null);
    this.returnAddress = returnAddress;
  }

  public void put(String varName, int memoryAddress) {
    scope.put(varName, memoryAddress);
  }

  public void rewrite(String varName, int memoryAddress) {
    scope.rewrite(varName, memoryAddress);
  }

  public int getAddress(String str) {
    return scope.getAddress(str);
  }

  public void sendResult(Memory memory, DynaObject obj) {
    memory.write(returnAddress, obj);
    returned = true;
  }

  public void enterScope() {
    scope = new Scope(scope);
  }

  public void exitScope() {
    scope = scope.parent;
  }
}
