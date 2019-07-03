Ndim_ := 4:
x1_ := r:
x2_ := u:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g12_ := -exp(2*Q(r,u,theta)):
g22_ := -exp(2*Q(r,u,theta)+2*gamma(r,u,theta))*(V(r,u,theta)*exp(-2*gamma(r,u,theta))-exp(-2*Q(r,u,theta))*U(r,u,theta)^
2*r^3)/r:
g23_ := -U(r,u,theta)*r^2*exp(2*gamma(r,u,theta)):
g33_ := r^2*exp(2*gamma(r,u,theta)):
g44_ := r^2*exp(-2*gamma(r,u,theta))*sin(theta)^2:
constraint_ := [ ]:
Info_ := `The Bondi metric.`: 
Ref_:= ["Bondi, prsla, v269, p21, (1962)"]:

