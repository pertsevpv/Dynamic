var pow := func(base, power) is
    var result := 1
    while power > 0 loop
        if even(power) then
            power = power / 2
            base = base * base
        else
            power = power - 1
            result = result * base
        end
    end
    return result
end

var a := pow(2, 0)
var b := pow(2, 1)
var c := pow(2, 128)
var c := pow(5, 32)