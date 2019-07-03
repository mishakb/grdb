Ndim_ := 4:
x1_ := t:
x2_ := z:
x3_ := x:
x4_ := y:
sig_ := 2:
complex_ := {}:
g11_ := -exp(2*nu(z)):
g22_ := z/F(z):
g33_ := z^2:
g44_ := z^2:
constraint_ := [diff(p(z), z) = (1-p*z^3/F(z))/2/z*(mu(z)+p)]:
Info_ := `Plane symmetric static perfect fluid, x0 set to 1`:
Ref_ := ["Taub, L O Raifertaigh (Ed.) Clarendon Press Oxford p133 (1972)", "NovotnyHorsky74, TeixeiraWolkSomPlane"]:
Archive1_ := `(13.44) p161`:
