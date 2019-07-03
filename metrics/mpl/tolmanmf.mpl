Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -B^2*r^(2*b)*(2/(a-b)/(a+2*b-1)-(2*m/r)^(a+2*b-1)-(r/R)^(a-b)):
g22_ := 1/(2/(a-b)/(a+2*b-1)-(2*m/r)^(a+2*b-1)-(r/R)^(a-b)):
g33_ := r^2:
g44_ := (r*sin(theta))^2:
constraint_ := [(a+b)*(a-1)-2*b-2 = 0]:
Info_ := `Tolman s type VIII static spherically symmetric perfect fluid solution`:
Ref_ := ["Tolman, pr, v55, pp363-373, (1939)"]:
