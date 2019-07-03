Ndim_ := 4:
x1_ := t:
x2_ := z:
x3_ := x:
x4_ := y:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
bd11_ := exp(2*nu(z)):
bd12_ := 1/F(z)*(exp(2*nu(z))*z*F(z))^(1/2):
bd21_ := 1/2:
bd22_ := -1/2/exp(2*nu(z))*(exp(2*nu(z))*z*F(z))^(1/2)/F(z):
bd33_ := -1/2*I*2^(1/2)*z:
bd34_ := -1/2*2^(1/2)*z:
bd43_ := 1/2*I*2^(1/2)*z:
bd44_ := -1/2*2^(1/2)*z:
constraint_ := [diff(p(z),z) = 1/2*(1-p*z^3/F(z))/z*(mu(z)+p)]:
Info_ := `Plane symmetric static perfect fluid, x0 set to 1`:

