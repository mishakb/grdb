Ndim_ := 4:
x1_ := r:
x2_ := theta:
x3_ := phi:
x4_ := t:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
bd11_ := -1:
bd14_ := r:
bd21_ := 1/2:
bd24_ := 1/2*r:
bd32_ := -1/2*I*r*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2)*(1+alpha*exp(2*t)+beta*exp(-2*t)):
bd33_ := -1/2*r*sin(theta)*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2)*(1+alpha*exp(2*t)+beta*exp(-2*t)):
bd42_ := 1/2*I*r*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2)*(1+alpha*exp(2*t)+beta*exp(-2*t)):
bd43_ := -1/2*r*sin(theta)*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2)*(1+alpha*exp(2*t)+beta*exp(-2*t)):
constraint_ := [alpha = 1/4/beta]:
Info_ := `Covariant NP tetrad for Minkowski space with constraint`:
Ref_:=["Lake, grg, v15, p357, (1983)"]:

