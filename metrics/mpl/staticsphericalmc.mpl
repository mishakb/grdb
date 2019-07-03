Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g11_ := -exp(2*nu(r)):
g22_ := exp(2*lambda(r)):
g33_ := r^2:
g44_ := r^2*sin(theta)^2:
constraint_ := [diff(nu(r),r$2) = -diff(nu(r),r)^2+diff(nu(r),r)*diff(lambda(r),r)+(diff(nu(r),r)+diff(lambda(r),r))/r+(1-e^(2*lambda(r)))/r^2]:
Info_ := `Static, spherically symmetric metric. Isotropic pressure (perfect fluid) condition added. Schwarzschild coordinates.`:
Archive1_ := `(14.1) + (14.4) p163`:
