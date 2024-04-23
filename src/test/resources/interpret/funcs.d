var fmap := func(f, arr) is
    for i in 0 .. arr.length loop
        arr[i] := f(arr[i])
    end
end

var compose := func(f, value) is
    var res := value
    for i in 0 .. f.length loop
        res := f[i](res)
    end
    return res
end

var fn := func(f, n) is
    return func(a) is
        for i in 0 .. n loop
            a := f(a)
        end
        return a
    end
end

var value := [1, 2, 3, 4, 5]
var f := func(a) => [a]
fmap(f, value)
print value

value := {}
value := compose([
    func(a) => a + {l := 10},
    func(a) => a.l,
    func(a) => a + " = 10",
    func(a) => a.length
], value)
print value

var inc := func(a) => a + 1
value := 0

print fn(fn(inc, 2), 100)(value)