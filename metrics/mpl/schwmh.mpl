Ndim_ := 4:
x1_ := u:
x2_ := w:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := 1/2*w^2/m/r(u,w):
g12_ := 1:
g33_ := r(u,w)^2:
g44_ := r(u,w)^2*sin(theta)^2:
constraint_ := [r(u,w) = 2*m+1/4*u*w/m]:
Info_ := `Israel coordinates for the Schwarzschild exterior metric`:
Ref_ := ["Israel, pr, v143, p1016, (1966)"]:
