Ndim_ := 4:
x1_ := x:
x2_ := t:
x3_ := y:
x4_ := z:
sig_ := 2:
complex_ := {}:
g11_ := -A(t)^2:
g22_ := 1:
g33_ := B(t)^2:
g44_ := B(t)^2*Sigma(y)^2:
constraint_ := [diff(Sigma(y),y$2) = -k*Sigma(y)]:
Info_ := `LRS metric of Ellis: case 1a, epsilon=1`:
Ref_ := ["Ellis, jmp, v8, p1171, (1967)", "Stewart & Ellis, jmp, v9, p1072, (1968)"]:
Archive1_ := `(11.3) p127`:
