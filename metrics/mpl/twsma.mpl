Ndim_ := 4:
x1_ := t:
x2_ := z:
x3_ := x:
x4_ := y:
sig_ := 2:
complex_ := {}:
g11_ := -exp(2*nu(z)):
g22_ := z/(p0/5*(6-z^5)^3):
g33_ := z^2:
g44_ := z^2:
constraint_ := [diff(nu(z), z) = -(1-5*z^5/(6-z^5))/2/z, F(z) = p0/5*(216-108*z^5+18*z^10-z^15)]:
Info_ := `Plane symmetric static perfect fluid, x0 set to 1`:
Ref_ := ["Teixeira & Wolk & Som", "Taub, L O Raifertaigh (Ed.) Clarendon Press Oxford p133 (1972)", "NovotnyHorsky74, TeixeiraWolkSomPlane"]:
Archive1_ := `(13.44) p161`:
