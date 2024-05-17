var pow := func(base, power) is
    var result := 1
    while power > 0 loop
        if power % 2 = 0 then
            power := power / 2
            base := base * base
        else
            power := power - 1
            result := result * base
        end
    end
    return result
end

print pow(10, 128)