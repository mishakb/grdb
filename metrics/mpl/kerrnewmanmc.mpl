Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := u:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -1/(r^2+u^2)*(-r^2+2*M*r-u^2-Q^2):
g14_ := (2*M*r-Q^2)*(a-u)*(a+u)/a/(r^2+u^2):
g22_ := (r^2+u^2)/(-r^2+2*M*r-a^2-Q^2):
g33_ := -(r^2+u^2)/(a+u)/(a-u):
g44_ := -(r^4+u^2*r^2+r^2*a^2-2*u^2*M*r+2*r*M*a^2-Q^2*a^2+u^2*a^2+u^2*Q^2)*(a-u)*(a+u)/(r^2+u^2)/a^2:
constraint_ := [u=a*cos(theta)]:
Info_ := `The Kerr Newman metric in Boyer Lindquist coordinates (u=a*cos(theta))`:
Ref_ := ["Newman, jmp, v6, p918, (1965)"]:
Archive1_ := `(19.19) p213`: 

