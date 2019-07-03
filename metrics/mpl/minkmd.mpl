Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ := 2:
complex_ := {}:
g11_ := 1:
g22_ := 1/2*r^2*(1+alpha*exp(2*t)+beta*exp(-2*t)):
g33_ := 1/2*r^2*sin(theta)^2*(1+alpha*exp(2*t)+beta*exp(-2*t)):
g44_ := -r^2:
constraint_ := [alpha=1/(4*beta)]:
Info_ := `Minkowski space with constraint`:
Ref_ := ["Lake, grg, v15, p357, (1983)"]:
