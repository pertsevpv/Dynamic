var subArray := func(a, from, to) is
    var result := []
    var ind := 0
    for j in from .. to loop
      result[ind] := a[j]
      ind := ind + 1
    end
    return result
end

var merge := func(a) is
    if a.length <= 1 then
        return a
    end
    var l := merge(subArray(a, 0, a.length / 2)),
        r := merge(subArray(a, a.length / 2, a.length)),
        i := 0,
        j := 0,
        k := 0,
        c := []

   while i < l.length and j < r.length loop
        if l[i] <= r[j] then
            c[k] := l[i]
            i := i + 1
        else
            c[k] := r[j]
            j := j + 1
        end
        k := k + 1
   end
   while i < l.length loop
        c[k] := l[i]
        i := i + 1
        k := k + 1
   end
   while j < r.length loop
        c[k] := r[j]
        j := j + 1
        k := k + 1
   end
   return c
end

var binSearch := func(arr, key) is
    var l := -1, r:= arr.length
    while l < r - 1 loop
        var m := (l + r) / 2
        if arr[m] < key then
            l := m
        else r := m
        end
    end
    return r
end

var sorted := merge([1, 6, 21, 9, 2])
print sorted
print binSearch(sorted, 3)