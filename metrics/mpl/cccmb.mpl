Ndim_ := 4:
x1_ := t:
x2_ := x:
x3_ := y:
x4_ := z:
sig_ := 2:
complex_ := {}:
g11_ := -B^2*Sigma2(z)^2:
g22_ := A^2:
g33_ := A^2*Sigma1(x)^2:
g44_ := B^2:
constraint_ := [diff(Sigma1(x),x,x) = k1*Sigma1(x), diff(Sigma2(z),z,z) = -k1*B^2/A^2*Sigma2(z)]:
Info_ := `Special conformally flat, Lambda=0 case of cross-product of two spaces with constant curvature`:
Archive1_ := `(10.8) p118`:
