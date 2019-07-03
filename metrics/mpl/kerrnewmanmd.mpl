Ndim_ := 4:
x1_ := u:
x2_ := r:
x3_ := theta :
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -(-a^2+a^2*sin(theta)^2-r^2-Q^2+2*m*r)/(-r^2-a^2+a^2*sin(theta)^2):
g12_ := -1:
g14_ := a*sin(theta)^2*(-Q^2+2*m*r)/(-r^2-a^2+a^2*sin(theta)^2):
g24_ := a*sin(theta)^2:
g33_ := r^2+a^2-a^2*sin(theta)^2:
g44_ := -sin(theta)^2*(2*a^2*m*r*sin(theta)^2+a^4-a^4*sin(theta)^2+2*r^2*a^2-r^2*a^2*sin(theta)^2-a^2*Q^2*sin(theta)^2+r^4)/(-r^2-a^2+a^2*sin(theta)^2):
constraint_ := [ ]:
Info_ := `Outgoing Eddington Finkelstein form of Kerr Newman (e.g. MTW Box 33.2)`: 

