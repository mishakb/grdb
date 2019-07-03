Ndim_ := 4:
x1_ := x:
x2_ := y:
x3_ := z:
x4_ := t:
sig_ := 2:
complex_ := {}:
g11_ := lambda^2/(x^2+y^2+z^2):
g22_ := lambda^2/(x^2+y^2+z^2):
g33_ := lambda^2/(x^2+y^2+z^2):
g44_ := -P(x,y,z,t)^2:
constraint_ := [P(x,y,z,t) = a(t)*cos(ln((x^2+y^2+z^2)^(1/2)/lambda))+b(t)*sin(ln((x^2+y^2+z^2)^(1/2)/lambda))]:
Info_ := `The Nariai vacuum metric`:
Ref_ := ["Nariai, srtu, v35, p62 (1951)"]:

