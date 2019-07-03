Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ :=2:
complex_ := {}:
g11_ := diff(R(r,t),r)^2/(1+f(r)):
g22_ := R(r,t)^2:
g33_ := R(r,t)^2*sin(theta)^2:
g44_ := -1:
constraint_ := [diff(R(r,t),r,t,t) = 2*M(r)*diff(R(r,t),r)/R(r,t)^3-diff(M(r),r)/R(r,t)^2, diff(R(r,t),r,t) = (2*diff(M(r),r)/R(r,t)-2*M(r)*diff(R(r,t),r)/R(r,t)^2+diff(f(r),r))/(2*diff(R(r,t),t)), diff(R(r,t),t,t) = -M(r)/R(r,t)^2, diff(R(r,t),t)^2 = 2*M(r)/R(r,t)+f(r)]:
Info_ := `The Lemaitre Tolman dust solution with constraints by C.W.Hellaby`:
Ref_ := ["Lemaitre, assbia, v53, p51, (1933)","Tolman, pnas, v20, p169, (1934)","Datt, zp, v108, p314, (1938)","Bondi, mnras, v107, p410, (1947)"]:
Archive1_ := `(13.39) p160`:

