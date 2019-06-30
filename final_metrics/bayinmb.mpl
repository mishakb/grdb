Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
g11_ := -A*C1^(-a)*e^(-a*C0*r^2):
g22_ := B*C1^b*e^(b*C0*r^2):
g33_ := B*C1^b*e^(b*C0*r^2)*r^2:
g44_ := B*C1^b*e^(b*C0*r^2)*r^2*sin(theta)^2:
constraint_ := [a^2 = b*(b-2*a)]:
Info_ := `Bayin s spherically symmetric static perfect fluid solution VI`:
Ref_ := ["Bayin, prd, v18, pp2745-2751, (1978)"]:
