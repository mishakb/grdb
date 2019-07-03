Ndim_ := 4:
x1_ := x:
x2_ := y:
x3_ := z:
x4_ := t:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
bd11_ := -1/16*(2*r(x,y,z)+m)^4/r(x,y,z)^4:
bd14_ := 1/4*(2*r(x,y,z)+m)/r(x,y,z)^2*(2*r(x,y,z)-m):
bd21_ := 1/2:
bd24_ := 2*(2*r(x,y,z)-m)*r(x,y,z)^2/(2*r(x,y,z)+m)^3:
bd32_ := -1/8*I*(2*r(x,y,z)+m)^2/r(x,y,z)^2*2^(1/2):
bd33_ := -1/8*2^(1/2)*(2*r(x,y,z)+m)^2/r(x,y,z)^2:
bd42_ := 1/8*I*(2*r(x,y,z)+m)^2/r(x,y,z)^2*2^(1/2):
bd43_ := -1/8*2^(1/2)*(2*r(x,y,z)+m)^2/r(x,y,z)^2:
constraint_ := [r(x,y,z) = (x^2+y^2+z^2)^(1/2)]:
Info_ := `Covariant NP tetrad for the Schwarzschild exterior metric in isotropic coordinates`:
Ref_:=[ ]:
Archive1_:=`(13.22) p158`: 
Archive2_:=`SchwarzschildIsotrop.rsh`:

