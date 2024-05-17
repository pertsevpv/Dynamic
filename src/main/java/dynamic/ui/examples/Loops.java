package dynamic.ui.examples;

public interface Loops {

  String WHILE = """
      var p := 817321
      var i := 0
      
      print p
      while p /= 1 loop
          p := p / 2
          i := i + 1
          print p
      end
      
      print "iterations: ", i
      """;

  String FOR = """
      var arr := []
      
      for i in 0..11 loop
          arr[i] := []
          for j in 0..i+1
              arr[i][j] := {i, j}
           end
          print arr[i]
      end
      
      print arr
      """;

  String FOR_EACH = """
      var arr := [0, 1, 2, 3, 4]
      
      arr[10] := 10
      arr[100] := "100"
      arr[1000] := {thousand := 1000}
      
      print arr
      
      for index, value in arr loop
          print "arr[" + index + "] := " + value
      end
      
      var tuple := {a := "a", 100, str := "string", arr := [1, 3, 4], true}
      
      print tuple
      
      for label, value in tuple loop
          print "tuple." + label + ":= " + value
      end
      """;
}
