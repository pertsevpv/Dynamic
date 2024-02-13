var sort := func(arr) is
    for i in 0..arr.length loop
        for j in i + 1 .. arr.length loop
            if arr[j] < arr[i] then
                var tmp := arr[i]
                arr[i] := arr[j]
                arr[j] := tmp
            end
        end
    end
end
