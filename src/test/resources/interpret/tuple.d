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
    return person
end

var ivan := newPerson("Petrov", "Peter", 1999)
var peter := newPerson("Ivanov", "Ivan", 1984)

print ivan
print ivan.toString()

print peter
print peter.toString()

peter.age := 41
print peter.toString()