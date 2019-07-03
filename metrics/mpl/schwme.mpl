Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
g11_ := diff(R(r,t),r)^2/(1+f(r)):
g22_ := R(r,t)^2:
g33_ := R(r,t)^2*sin(theta)^2:
g44_ := -1:
sig_ := 2:
complex_ := {}:
constraint_ := [diff(diff(R(r,t),r),t) = (-2*m*diff(R(r,t),r)/R(r,t)^2+
diff(f(r),r))/(2*sqrt(2*m/R(r,t)+f(r))), diff(R(r,t),t) = sqrt(2*m/R(r,t)+f(r)),
diff(diff(R(r,t),t),t) = -m/R(r,t)^2, diff(diff(diff(R(r,t),t),r),t) = 
2*m*diff(R(r,t),r)/R(r,t)^3]:
Info_ := `Schwarzschild exterior metric in Lemaitre  Novikov coordinates`: 
Ref_ := ["Lemaitre, assbia, v53, p51, (1933)","Novikov, za, v40, p772 (1963)"]:
Archive1_ := `(13.25) p158`: 
Archive2_ := `SchwarzschildLemaitre.dia`:
