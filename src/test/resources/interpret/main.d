var map := func(f, arr) is
  for i, v in arr loop
    arr[i] := f(v)
  end
  return arr
end

var compose1 := func(f) is
  return func(a) is
    var res := a
    for fi in f loop
      res := fi(res)
    end
    return res
  end
end

var fold := func(f, arr, init) is
  var res := init
  for a in arr loop
    res := f(res, a)
  end
  return res
end

var consRev := func(xs, x) is
  x := [x]
  for v in xs loop
    x[x.length] := v
  end
  return x
end

var cons := func(x, xs) is
  xs[xs.length] := x
  return xs
end

var filter := func(f, arr) is
  var res := []
  for a in arr loop
    if f(a) then
      res := cons(a, res)
    end
  end
  return res
end

var concat := func(x, y) is
  var res := []
  for v in x loop
    res[res.length] := v
  end
  for v in y loop
      res[res.length] := v
  end
  return res
end

var max := func(a, b) is
  if a > b then
    return a
  else
    return b
  end
end

var reverse := func(list) => fold(consRev, list, [])

var plus := func(list) => fold(func(a, b) => a + b, list, 0)
var minus := func(list) => fold(func(a, b) => a - b, list, 0)
var times := func(list) => fold(func(a, b) => a * b, list, 1)

var maxList := func(list) => fold(max, list, 0)

var flatten := func(list) => fold(concat, list, [])
var flattenRev := func(list) => fold(compose1([reverse, concat]), list, [])

var filterEven := func(list) => filter(func(n) => n % 2 = 0, list)

print map(func(a) => a % 2 = 0, [1, 2, 3, 4, 5, 6, 7])

print reverse([1, 2, 3, 4, 5])
print plus([1, 2, 3, 4, 5])
print minus([1, 2, 3, 4, 5])
print times([1, 2, 3, 4, 5])
print maxList([1, 2, 3, 4, 5, 4, 3, 2, 1])
print flatten([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10]])
print flattenRev([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10]])
print filterEven(flatten([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10]]))

