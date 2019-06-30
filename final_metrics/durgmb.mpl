Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -A*(1+C*r^2)^4:
g22_ := 7*(1+C*r^2)^2*(1+5*C*r^2)^(2/5)/((7-10*C*r^2-C^2*r^4)*(1+5*C*r^2)^(2/5)+7*K*C*r^2):
g33_ := r^2:
g44_ := r^2*sin(theta)^2:
constraint_ := [ ]:
Info_ := `Durgapal s static spherically symmetric perfect fluid with n=4`:
Ref_ := ["Durgapal, jpa, v15, pp2637-2644, (1982)"]:
