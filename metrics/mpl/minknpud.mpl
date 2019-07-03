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
b14_ := 1/r:
b21_ := -1/2:
b24_ := 1/2/r:
b32_ := I/r*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2):
b33_ := 1/r/sin(theta)*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2):
b42_ := -I/r*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2):
b43_ := 1/r/sin(theta)*exp(t)/(exp(t)^2+alpha*exp(t)^4+beta)^(1/2):
constraint_ := [alpha = 1/4/beta]:
Info_ := `Contravariant NP tetrad for Minkowski space with constraint`:
Ref_:=["Lake, grg, v15, p357, (1983)"]:

