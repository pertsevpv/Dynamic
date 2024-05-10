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
    if (!object.isNotAllocated()) throw new DynaRuntimeError();
    if (memoryPtr >= memory.length) throw new DynaRuntimeError();
    int memoryAddress = memoryPtr++;
    object.memoryAddress = memoryAddress;
    memory[memoryAddress] = object;
    return memoryAddress;
  }

  public void write(int address, DynaObject object) {
    if (address >= memoryPtr) throw new DynaRuntimeError();
    object.memoryAddress = address;
    memory[address] = object;
  }

  public DynaObject get(int address) {
    if (address < 0) {
      throw new DynaRuntimeError();
    }
    return memory[address];
  }
}
