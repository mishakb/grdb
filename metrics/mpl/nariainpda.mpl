Ndim_ := 4:
x1_ := x:
x2_ := y:
x3_ := z:
x4_ := t:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
bd11_ := -lambda^2/(x^2+y^2+z^2):
bd14_ := lambda*P(x,y,z,t)/(x^2+y^2+z^2)^(1/2):
bd21_ := 1/2:
bd24_ := 1/2/lambda*(x^2+y^2+z^2)^(1/2)*P(x,y,z,t):
bd32_ := -1/2*I*2^(1/2)*lambda/(x^2+y^2+z^2)^(1/2):
bd33_ := -1/2*2^(1/2)*lambda/(x^2+y^2+z^2)^(1/2):
bd42_ := 1/2*I*2^(1/2)*lambda/(x^2+y^2+z^2)^(1/2):
bd43_ := -1/2*2^(1/2)*lambda/(x^2+y^2+z^2)^(1/2):
constraint_ := [P(x,y,z,t) = a(t)*cos(ln((x^2+y^2+z^2)^(1/2)/lambda))+b(t)*sin(ln((x^2+y^2+z^2)^(1/2)/lambda))]:
Info_ := `Covariant NP tetrad for the Nariai vacuum metric`:
Ref_:=["Nariai, srtu, v35, p62 (1951)"]:

