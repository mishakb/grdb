Ndim_ := 4:
x1_   := u:
x2_   := v:
x3_   := w:
x4_   := x:
sig_ := 2:
complex_ := {}:
g11_ := (N(u,v,w,x)-L(u,v,w,x))*(N(u,v,w,x)+L(u,v,w,x)):
g12_ := P(u,v,w,x)*N(u,v,w,x)-M(u,v,w,x)*L(u,v,w,x):
g22_ := (P(u,v,w,x)-M(u,v,w,x))*(P(u,v,w,x)+M(u,v,w,x)):
g33_ := R(w,x)^2:
g44_ := S(w,x)^2:
constraint_ := [ ]:
Info_ := `Modified Debever McLenaghan Tariq metric`:
Ref_ := ["Debever, grg, v10, p853, (1979)"]: