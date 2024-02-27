var gcd := func(a, b) is
    if a = 0 then
        return a
    else
        return gcd(b, mod(a, b))
    end
end
