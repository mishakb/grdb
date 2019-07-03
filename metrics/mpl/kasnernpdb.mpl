Ndim_ := 4:
x1_ := t:
x2_ := x:
x3_ := y:
x4_ := z:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
bd11_ := 1:
bd12_ := (t^(2*k1))^(1/2):
bd21_ := 1/2:
bd22_ := -1/2*(t^(2*k1))^(1/2):
bd33_ := -1/2*I*2^(1/2)/(t^k2)*t^(2*k2):
bd34_ := -1/2*2^(1/2)/(t^k3)*t^(2*k3):
bd43_ := 1/2*I*2^(1/2)/(t^k2)*t^(2*k2):
bd44_ := -1/2*2^(1/2)/(t^k3)*t^(2*k3):
constraint_ := [k2^2 = k1+k2-k1*k2-k1^2, k3 = 1-k1-k2]:
Info_ := `Kasner power-law vacuum solution`:

