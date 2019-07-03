Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -(1-f(r))^2/(1+f(r))^2:
g22_ := (1+f(r))^4:
g33_ := (1+f(r))^4*r^2:
g44_ := (1+f(r))^4*r^2*sin(theta)^2:
constraint_ := [f(r) = a/2/sqrt(1+k*r^2)]:
Info_ := `Buchdahl s polytropic static spherically symmetric perfect fluid. Isotropic co-ordinates.`:
Ref_ := ["Buchdahl, apj, v140, pp1512-1516, (1964)"]:
