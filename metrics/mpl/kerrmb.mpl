Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -(-a^2+sin(theta)^2*a^2-r^2+2*M*r)/(-a^2+sin(theta)^2*a^2-r^2):
g14_ := 2*M*r*a*sin(theta)^2/(-a^2+sin(theta)^2*a^2-r^2):
g22_ := (-a^2+sin(theta)^2*a^2-r^2)/(-r^2+2*M*r-a^2):
g33_ := a^2-sin(theta)^2*a^2+r^2:
g44_ := -(-a^4*sin(theta)^2+a^4+2*r^2*a^2-a^2*sin(theta)^2*r^2+2*a^2*sin(theta)^2*M*r+r^4)*sin(theta)^2/(-a^2+sin(theta)^2*a^2-r^2):
constraint_ := [ ]:
Info_ := `The Kerr metric in Boyer Lindquist coordinates`:
Ref_ := ["Boyer, jmp, v8, p265, (1967)"]:
Archive1_ := `(18.25) p205`: 
