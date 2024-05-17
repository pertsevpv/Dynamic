package dynamic.ui.examples;

public interface Tuple {

  String PERSON = """
      var currentAge := 2024
            
      var newPerson := func(
          firstName,
          lastName,
          birthAge
      ) is
          var person := {
              fullName := firstName + " " + lastName,
              age := currentAge - birthAge
          }
          person := person + {toString := func() => person.fullName + ", " + person.age}
          person := person + {plusAge := func(age) is person.age := person.age + age; end}
          return person
      end
            
      var peter := newPerson("Petrov", "Peter", 1999)
      var ivan := newPerson("Ivanov", "Ivan", 1984)
            
      print ivan
      print ivan.toString()
            
      print peter
      print peter.toString()
            
      peter.plusAge(10)
      print peter.toString()
      """;

}
