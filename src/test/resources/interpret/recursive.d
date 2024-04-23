var fac := func(n) is
    if not(n is int) then
        return -1
    end
    if n = 0 then
        return 1
    end
    return n * fac(n - 1)
end

print fac(1000)

var fibCache := []

var fib := func(n) is
    if n < 1 then
        return 1
    else
        if not (fibCache[n] is empty) then
            return fibCache[n]
        end
    end
    var result := fib(n - 1) + fib(n - 2)
    fibCache[n] := result
    return fib(n - 1) + fib(n - 2)
end

print fib(1000)