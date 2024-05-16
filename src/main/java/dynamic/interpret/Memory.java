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
    if (!object.isNotAllocated()) throw new DynaRuntimeError("Object %s is already allocated ");
    if (memoryPtr >= memory.length) throw new DynaRuntimeError("Memory overflow");
    int memoryAddress = memoryPtr++;
    object.memoryAddress = memoryAddress;
    memory[memoryAddress] = object;
    return memoryAddress;
  }

  public void write(int address, DynaObject object) {
    if (address < 0 || address > memoryPtr) throw new DynaRuntimeError("Illegal write address");
    object.memoryAddress = address;
    memory[address] = object;
  }

  public DynaObject get(int address) {
    if (address < 0 || address > memoryPtr) throw new DynaRuntimeError("Illegal get address");
    return memory[address];
  }
}
