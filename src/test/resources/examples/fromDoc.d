var t := []; // empty array declaration
t[10] := 25;
t[100] := func(x)=>x+1;
t[1000] := {a:=1,b:=2.7};

var t := {a:=1, b:=2, c};
t := t + {d:=3}; // now t is {a=1, b=2, c, d=3}

var x := t.b; // now x is 2

var y1 := t.1 // now y1 is 1
var y2 := t.3 // now y2 has the value of c
