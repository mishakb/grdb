Ndim_ := 4:
x1_ := x:
x2_ := y:
x3_ := z:
x4_ := t:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
b11_ := 1:
b14_ := 1/4/r(x,y,z)^2*(2*r(x,y,z)+m)^3/(2*r(x,y,z)-m):
b21_ := -8*r(x,y,z)^4/(2*r(x,y,z)+m)^4:
b24_ := 2/(2*r(x,y,z)+m)/(2*r(x,y,z)-m)*r(x,y,z)^2:
b32_ := 2*I*2^(1/2)/(2*r(x,y,z)+m)^2*r(x,y,z)^2:
b33_ := 2*2^(1/2)/(2*r(x,y,z)+m)^2*r(x,y,z)^2:
b42_ := -2*I*2^(1/2)/(2*r(x,y,z)+m)^2*r(x,y,z)^2:
b43_ := 2*2^(1/2)/(2*r(x,y,z)+m)^2*r(x,y,z)^2:
constraint_ := [r(x,y,z) = (x^2+y^2+z^2)^(1/2)]:
Info_ := `Contravariant NP tetrad for the Schwarzschild exterior metric in isotropic coordinates`:
Ref_:=[ ]:
Archive1_:=`(13.22) p158`: 
Archive2_:=`SchwarzschildIsotrop.rsh`:

