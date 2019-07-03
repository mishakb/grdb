Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -(1-2*m/r):
g12_ := epsilon*sqrt(1-c+2*m*c/r):
g22_ := c:
g33_ := r^2:
g44_ := r^2*sin(theta)^2:
constraint_ := [epsilon^2 = 1, epsilon^4 = 1, epsilon^6=1, epsilon^8=1]:
Info_ := `epsilon=+/-1, 0<=c<=1,c=0->Eddington-Finkelstein form of the Schwarzschild exterior metric`:
Ref_ := ["gr-qc/9407005","gr-qc/0001069"]:
