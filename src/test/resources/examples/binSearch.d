var binSearch := func(arr, key) is
    var l := -1, r:= arr.len
    while l < r - 1 loop
        var m := (l + r) / 2
        if arr[m] < key then
            l := m
        else r := m
        end
    end
    return r
end

var ind := binSearch([1, 2, 3, 4, 5, 6], 7)