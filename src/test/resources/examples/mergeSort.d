var subArray := func(a, from, to) is
    var result := []
    var ind := 0
    for j in from .. to loop
      result[ind] := a[j]
      ind := ind + 1
    end
    ind := 1
    return result
end

var merge := func(a) is
    if a.len = 1 then
        return a
    end
    var l := merge(subArray(a, 0, a.len / 2)),
        r := merge(subArray(a, a.len / 2, a.len)),
        i := 0,
        j := 0,
        k := 0,
        c := []

   while i < l.len and j < r.len loop
        if l[i] <= r[j] then
            c[k] := l[i]
            i := i + 1
        else
            c[k] := r[j]
            j := j + 1
        end
        k := k + 1
   end
   while i < l.len loop
        c[k] := l[i]
        i := i + 1
        k := k + 1
   end
   while j < r.len loop
        c[k] := r[j]
        j := j + 1
        k := k + 1
   end
   return c
end
