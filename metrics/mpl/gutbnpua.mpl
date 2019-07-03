Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
b11_ := 1:
b12_ := r*(1-k*r^2)^(1/2):
b21_ := 1/2/r^2:
b22_ := 1/2*(-1+k*r^2)/r/(1-k*r^2)^(1/2):
b33_ := 1/2*I*2^(1/2)/r/f(t)^(1/2):
b34_ := 1/2*2^(1/2)/r/sin(theta)/f(t)^(1/2):
b43_ := -1/2*I*2^(1/2)/r/f(t)^(1/2):
b44_ := 1/2*2^(1/2)/r/sin(theta)/f(t)^(1/2):
constraint_ := [f(t) = 1/2+1/2*G*exp(2*t)+1/2*H*exp(-2*t)]:
Info_ := `Contravariant NP tetrad for Gutman Bespal ko space `:
Ref_:=["Gutman, sspgt, p201, (1967)","Wesson, jmp, v19, p2283, (1978)","Lake, grg, v15, p357, (1983)"]:
Archive1_:=`(14.67) p173`: 
Archive2_:=`GutmanBespalko.dia `:

