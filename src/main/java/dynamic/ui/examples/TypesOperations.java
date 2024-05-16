package dynamic.ui.examples;

public interface TypesOperations {

  String TYPES = """
      var getType := func(value) is
        if value is empty then
          return "empty"
        end
        if value is int then
          return "int"
        end
        if value is real then
          return "real"
        end
        if value is bool then
          return "bool"
        end
        if value is string then
          return "string"
        end
        if value is {} then
          return "tuple"
        end
        if value is [] then
          return "array"
        end
        if value is func then
          return "func"
        end
      end

      var value
      print value, "is", getType(value)
      
      value := 1
      print value, "is", getType(value)
      
      value := 1.0
      print value, "is", getType(value)
      
      value := true
      print value, "is", getType(value)
      
      value := "string"
      print value, "is", getType(value)
      
      value := {a := 1, 2, c := 3}
      print value, "is", getType(value)
      
      value := ["a", 1, 2, "c", 3]
      print value, "is", getType(value)

      value := getType
      print value, "is", getType(value)
      """;

}
