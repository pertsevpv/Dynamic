package dynamic.ui.examples;

public interface InputOutput {

  String PRINTING = """
      print 1, 2, 3
      print 1.0, 2.0, 3.0000000001
      print true, false
      print "Hello, World!"
      print {a := 1, 2, c := 3}
      print [1, 2, 3, 4, 5]
      print func(a, b, c) => a + b + c
      """;

  String READING = """
      print "Reading"
      print "Enter int:", readInt
      print "Enter real:", readReal
      print "Enter string:", readString
      """;

  String READ_ARRAY = """
       var arr := []
       var len := readInt
            
       for i in 0..len loop
         arr[i] := readInt
       end
       print arr
      """;
}
