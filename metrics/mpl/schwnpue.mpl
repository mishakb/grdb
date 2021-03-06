Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
b11_ := 1:
b14_ := diff(R(r,t),r)/(1+f(r))^(1/2):
b21_ := -1/2/diff(R(r,t),r)^2*(1+f(r)):
b24_ := 1/2/diff(R(r,t),r)*(1+f(r))^(1/2):
b32_ := 1/2*I*2^(1/2)/R(r,t):
b33_ := 1/2*2^(1/2)/R(r,t)/sin(theta):
b42_ := -1/2*I*2^(1/2)/R(r,t):
b43_ := 1/2*2^(1/2)/R(r,t)/sin(theta):
constraint_ := [diff(diff(R(r,t),r),t) = 1/2*(-2*m*diff(R(r,t),r)/R(r,t)^2+diff(f(r),r))/(2*m/R(r,t)+f(r))^(1/2), diff(R(r,t),t) = (2*m/R(r,t)+f(r))^(1/2), diff(diff(R(r,t),t),t) = -m/R(r,t)^2, diff(diff(diff(R(r,t),r),t),t) = 2*m*diff(R(r,t),r)/R(r,t)^3]:
Info_ := `Contravariant NP tetrad for the Schwarzschild exterior metric in Lemaitre Novikov coordinates`:
Ref_:=["Lemaitre, assbia, v53, p51, (1933)","Novikov, za, v40, p772 (1963)"]:
Archive1_:=`(13.25) p158`:
Archive2_:=`SchwarzschildLemaitre.dia`:
