package dynamic.interpret;

public interface Executable {

  void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame);

}
