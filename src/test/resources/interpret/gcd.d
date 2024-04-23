var gcd := func(a, b) is
    if b = 0 then
        return a
    else
        return gcd(b, a % b)
    end
end

print gcd(27, 18)