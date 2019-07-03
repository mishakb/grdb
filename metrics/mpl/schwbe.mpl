Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ := 2:
complex_ := {}:
eta11_ := 1:
eta22_ := 1:
eta33_ := 1:
eta44_ := -1:
bd11_ := diff(R(r,t),r)/(1+f(r))^(1/2):
bd22_ := R(r,t):
bd33_ := R(r,t)*sin(theta):
bd44_ := -1:
constraint_ := [diff(diff(R(r,t),r),t) = (-2*m*diff(R(r,t),r)/R(r,t)^2+
diff(f(r),r))/(2*sqrt(2*m/R(r,t)+f(r))), diff(R(r,t),t) = sqrt(2*m/R(r,t)+f(r)),
diff(diff(R(r,t),t),t) = -m/R(r,t)^2, diff(diff(diff(R(r,t),t),r),t) = 2*m*diff(R(r,t),r)/R(r,t)^3]:
Info_ := `Schwarzschild exterior metric in Lemaitre  Novikov covariant basis`: 
Ref_ := ["Lemaitre, assbia, v53, p51, (1933)","Novikov, za, v40, p772 (1963)"]:
Archive1_ := `(13.25) p158`:
