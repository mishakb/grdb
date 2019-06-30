Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ := 2:
complex_ := {}:
g11_ := diff(R(r,t),r)^2/(1+f(r)):
g22_ := R(r,t)^2:
g33_ := R(r,t)^2*sin(theta)^2:
g44_ := -1:
constraint_ := [diff(diff(R(r,t),r),t) = (2*diff(m(r),r)/R(r,t)-2*m(r)*diff(R(r,t),r)/R(r,t)^2+diff(f(r),r))/(2*sqrt(2*m(r)/R(r,t)+f(r))), diff(R(r,t),t) = sqrt(2*m(r)/R(r,t)+f(r)),diff(diff(R(r,t),t),t) = -m(r)/R(r,t)^2, diff(diff(diff(R(r,t),t),r),t) = -diff(m(r),r)/R(r,t)^2+2*m(r)*diff(R(r,t),r)/R(r,t)^3]:
Info_ := `The Lemaitre Tolman dust solution`:
Ref_ := ["Lemaitre, assbia, v53, p51, (1933)","Tolman, pnas, v20, p169, (1934)","Datt, zp, v108, p314, (1938)","Bondi, mnras, v107, p410, (1947)"]:
Archive1_ := `(13.39) p160`: 
