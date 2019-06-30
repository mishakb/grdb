Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -A*(1+C*r^2)^5:
g22_ := 1/((1-C*r^2*(309+54*C*r^2+8*C^2*r^4)/112+K*C*r^2/(1+6*C*r^2)^(1/3))/(1+C*r^2)^3):
g33_ := r^2:
g44_ := r^2*sin(theta)^2:
constraint_ := [ ]:
Info_ := `Durgapal s static spherically symmetric static perfect fluid with n=5`:
Ref_ := ["Durgapal, jpa, v15, pp2637-2644, (1982)"]:
