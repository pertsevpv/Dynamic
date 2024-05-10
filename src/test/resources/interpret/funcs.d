var fmap := func(f, arr) is
    for i in 0 .. arr.length loop
        arr[i] := f(arr[i])
    end
end

var compose := func(f) is
    return func(a) is
        var res := a
        for i in 0 .. f.length loop
            res := f[i](res)
        end
        return res
    end
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
var f := func(a) => {[a]}
fmap(f, value)
print value

value := {}
value := compose([
    func(a) => a + {l := 10},
    func(a) => a.l,
    func(a) => a + " = 10"
])(value)
print value

var inc := func(a) => a + 1
var mul2 := func(a) => a * 2
value := 16

print fn(fn(inc, 2), 4)(value)
