var max := func(a, b) is
    if a > b then
        return a
    else
        return b
    end
end

var lcs := func(L, R, emp, concat) is
    var matrix := []
    for i in 0 .. L.length + 1 loop
       matrix[i] := []
       for j in 0 .. L.length + 1 loop
            matrix[i][j] := 0
       end
    end

    for i in 1 .. L.length + 1 loop
        for j in 1 .. R.length + 1 loop
            if L[i - 1] = R[j - 1] then
                matrix[i][j] := 1 + matrix[i - 1][j - 1]
            else
                matrix[i][j] := max(matrix[i - 1][j], matrix[i][j - 1])
            end
        end
    end
    var common := emp,
        i := L.length,
        j := R.length

    while (i > 0) and (j > 0) loop
        if L[i - 1] = R[j - 1] then
            common := concat(L[i - 1], common)
            i := i - 1
            j := j - 1
        else
            if matrix[i - 1][j] > matrix[i][j - 1] then
                i := i - 1
            else
                j := j - 1
            end
        end
    end
    return common
end

var arrConcat := func(a, b) is
    var res := [a]
    var ind := 1
    for i in 0 .. b.length loop
        res[ind] := b[i]
        ind := ind + 1
    end
    return res
end

print lcs("abacaba", "cababaca", "", func(a, b) => a + b)
print lcs([1, 2, 1, 3, 1, 2, 1], [3, 1, 2, 1, 2, 1, 3, 1], "", arrConcat)
