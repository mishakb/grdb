Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -(-a^2+sin(theta)^2*a^2-Q^2-r^2+2*M*r)/(-a^2+sin(theta)^2*a^2-r^2):
g14_ := (2*M*r-Q^2)*a*sin(theta)^2/(-a^2+sin(theta)^2*a^2-r^2):
g22_ := (-a^2+sin(theta)^2*a^2-r^2)/(-r^2+2*M*r-a^2-Q^2):
g33_ := a^2-sin(theta)^2*a^2+r^2:
g44_ := -(-a^4*sin(theta)^2+a^4+2*r^2*a^2-a^2*sin(theta)^2*Q^2-a^2*sin(theta)^2*r^2+2*a^2*sin(theta)^2*M*r+r^4)*sin(theta)^2/(-a^2+sin(theta)^2*a^2-r^2): 
constraint_ := [ ]:
Info_ := `The Kerr Newman metric in Boyer Lindquist coordinates`:
Ref_ := ["Newman, jmp, v6, p918, (1965)"]:
Archive1_ := `(19.19) p213`:  

