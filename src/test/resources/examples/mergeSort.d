var merge := func(a) is
    if len(a) = 1 or len(b) = 0 then
        return a
    end
    var l := merge(subArray(a, 0, len(a) / 2)),
        r := merge(subArray(a, len(a) / 2), len(a)),
        i := 0,
        j := 0,
        k := 0,
        c := []

   while i < len(l) and j < len(r) loop
        if l[i] <= r[j] then
            c[k] := l[i]
            i := i + 1
        else
            c[k] := r[j]
            j := j + 1
        end
        k := k + 1
   end
   while i < len(l) loop
        c[k] := l[i]
        i := i + 1
        k := k + 1
   end
   while j < len(r) loop
        c[k] := r[j]
        j := j + 1
        k := k + 1
   end
   return c
end
