package dynamic.interpret;

import dynamic.exception.DynaRuntimeError;
import dynamic.interpret.obj.DynaObject;

public class Memory {

  private static final int MEM_SIZE = 1 << 16;

  public DynaObject[] memory;
  public int memoryPtr = 0;

  public Memory() {
    memory = new DynaObject[MEM_SIZE];
  }

  public int alloc(DynaObject object) {
    if (memoryPtr >= memory.length) throw new DynaRuntimeError();
    int memoryAddress = memoryPtr++;
    object.memoryAddress = memoryAddress;
    memory[memoryAddress] = object;

//    if (object instanceof DynaTuple tuple) {
//      for (var t : tuple.tuple) alloc(t.second);
//    }
//    if (object instanceof DynaArray array) {
//      for (var a: array.array.values()) alloc(a);
//    }

    return memoryAddress;
  }

  public void write(int address, DynaObject object) {
    if (address >= memoryPtr) throw new DynaRuntimeError();
    object.memoryAddress = address;
    memory[address] = object;
  }

  public DynaObject get(int address) {
    return memory[address];
  }
}
