package dynamic.ui.examples;

public interface Arrays {

  String BIN_SEARCH = """
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
      
      var arr := [1, 2, 4, 6, 7, 9, 10]
      
      for i in 0..11 loop
          print binSearch(arr, i)
      end
      """;

  String MERGE_SORT = """
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
      
      print merge([1, 6, 21, 9, 2])
      print merge([-1, 6, -21, 9, 2])
      print merge(["banana", "apple", "pear", "pineapple", ""])
      """;

  String INDICES = """
      var arr := [0, 1, 2, 3, 4]
            
      arr[10] := 10
      arr[100] := "100"
      arr[1000] := {thousand := 1000}
            
      print arr
            
      for index, value in arr loop
          print "arr[" + index + "] := " + value
      end
      """;
}
