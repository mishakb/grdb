Ndim_ := 4:
x1_ := x:
x2_ := y:
x3_ := z:
x4_ := t:
eta11_ := 1:
eta22_ := 1:
eta33_ := 1:
eta44_ := -1:
sig_ := 2:
complex_ := {}:
bd11_ := lambda/(x^2+y^2+z^2)^(1/2):
bd22_ := lambda/(x^2+y^2+z^2)^(1/2):
bd33_ := lambda/(x^2+y^2+z^2)^(1/2):
bd44_ := P(x,y,z,t):
constraint_ := [P(x,y,z,t) = a(t)*cos(ln((x^2+y^2+z^2)^(1/2)/lambda))+b(t)*sin(ln((x^2+y^2+z^2)^(1/2)/lambda))]:
Info_ := `The Nariai vacuum covariant basis`:
Ref_ := ["Nariai, srtu, v35, p62 (1951)"]:

