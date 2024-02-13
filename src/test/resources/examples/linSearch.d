var linSearch := func(arr, key) is
    for i in 0..len(arr) loop
        if arr[i] = key then
            return i
        end
    end
    return false
end

var ind := linSearch([1, 2, 3, 4, 5, 6], 7)