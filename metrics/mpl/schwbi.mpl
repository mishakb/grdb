Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
eta11_ := -1:
eta22_ := 1:
eta33_ := 1:
eta44_ := 1:
bd11_ := 1/epsilon/c^(1/2):
bd21_ := (1/epsilon^2/c-1+2*m/r)^(1/2):
bd22_ := epsilon*c^(1/2):
bd33_ := r:
bd44_ := r*sin(theta):
constraint_ :=   [epsilon^2 = 1, epsilon^4 = 1, epsilon^6=1, epsilon^8=1]:
Info_ := `epsilon=+/-1, 0<=c<=1,c=0->Eddington-Finkelstein form of the Schwarzschild exterior covariant basis`:
Ref_ := ["gr-qc/9407005","gr-qc/0001069"]:
