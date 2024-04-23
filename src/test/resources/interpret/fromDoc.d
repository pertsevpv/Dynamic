var t := []; // empty array declaration
print t
t[10] := 25;
print t
t[100] := func(x)=>x+1;
print t
t[1000] := {a:=1,b:=2.7};
print t

var c

t := {a:=1, b:=2, c};
print t
t := t + {d:=3}; // now t is {a=1, b=2, c, d=3}
print t

var x := t.b; // now x is 2
print x

var y1 := t.0 // now y1 is 1
print y1
var y2 := t.2 // now y2 has the value of c
print y2
