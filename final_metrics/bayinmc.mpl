Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
g11_ := -((A*H^(-a/k)))^2:
g22_ := ((B*H^(b/k)))^2:
g33_ := ((B*H^(b/k))*r)^2:
g44_ := ((B*H^(b/k))*r*sin(theta))^2:
constraint_ := [a^2 = b^2-2*a*b-a*((b^2-2*a*b-a^2)/(a-b))+((b^2-2*a*b-a^2)/(a-b))*b]:
Info_ := `Bayin s spherically symmetric static perfect fluid solution VI`:
Ref_ := ["Bayin, prd, v18, pp2745-2751, (1978)"]:
