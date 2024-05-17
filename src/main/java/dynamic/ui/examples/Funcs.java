package dynamic.ui.examples;

public interface Funcs {

  String RECURSIVE = """
      var fac := func(n) is
          if n = 0 then
              return 1
          end
          return n * fac(n - 1)
      end
      
      print fac(100)
            
      var fibCache := []
            
      var fib := func(n) is
          if n < 1 then
              return 1
          else
              if not (fibCache[n] is empty) then
                  return fibCache[n]
              end
          end
          var result := fib(n - 1) + fib(n - 2)
          fibCache[n] := result
          return fib(n - 1) + fib(n - 2)
      end
            
      print fib(100)
      """;

  String MAP = """
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
            
      var isEven := compose1([
          func(a) => a % 2,
          func(a) => a = 0
      ])
            
      print map(isEven, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
      """;

  String FOLD = """
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
      
      var consIf := func(p, xs, x) is
          if p(x) then
              xs[xs.length] := x
          end
          return xs
      end
      
      var cons := func(xs, x) => consIf(func(a) => true, xs, x)
      
      var reverse := func(list) => fold(consRev, list, [])
      var filter := func(list, p) => fold(func(xs, x) => consIf(p, xs, x), list, [])
      var concat := func(list1, list2) => fold(cons, list2, list1)
      var flatten := func(list) => fold(concat, list, [])
      
      print reverse([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
      print filter([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], func(a) => a % 2 = 0)
      print concat([0, 1, 2, 3, 4, 5], [6, 7, 8, 9])
      print flatten([[0], [1, 2], [3, 4, 5], [6, 7, 8, 9]])
      """;
}
