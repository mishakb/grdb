Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
bd24_ := 1/2/diff(R(r,t),r)*(1+f(r))^(1/2):
bd32_ := -1/2*I*2^(1/2)*R(r,t):
bd33_ := -1/2*2^(1/2)*R(r,t)*sin(theta):
bd42_ := 1/2*I*2^(1/2)*R(r,t):
bd43_ := -1/2*2^(1/2)*R(r,t)*sin(theta):
constraint_ := [diff(diff(diff(R(r,t),r),t),t) = 2*M(r)*diff(R(r,t),r)/R(r,t)^3-diff(M(r),r)/R(r,t)^2, diff(diff(R(r,t),r),t) = 1/2*(2*diff(M(r),r)/R(r,t)-2*M(r)*diff(R(r,t),r)/R(r,t)^2+diff(f(r),r))/diff(R(r,t),t), diff(diff(R(r,t),t),t) = -M(r)/R(r,t)^2, diff(R(r,t),t)^2 = 2*M(r)/R(r,t)+f(r)]:
Info_ := `Covariant NP tetrad for the Lemaitre Tolman dust solution with constraints by C.W.Hellaby`:
Ref_:= ["Lemaitre, assbia, v53, p51, (1933)","Tolman, pnas, v20, p169, (1934)","Datt, zp, v108, p314, (1938)","Bondi, mnras, v107, p410, (1947)"]:
Archive1_:=`(13.39) p160`:
