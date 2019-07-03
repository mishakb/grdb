Ndim_ := 4:
x1_ := u:
x2_ := v:
x3_ := theta:
x4_ := phi:
sig_ := 2:
complex_ := {}:
g12_ := -8*m^2*(2*m-r(u,v))/(u*v*r(u,v)):
g33_ := r(u,v)^2:
g44_ := r(u,v)^2*sin(theta)^2:
constraint_ := [diff(r(u,v),u) = -2*m*(2*m-r(u,v))/(r(u,v)*u), diff(r(u,v),v) = -2*m*(2*m-r(u,v))/(r(u,v)*v)]:
Info_ := `Null form of Kruskal Szekeres metric`: 
Ref_ := ["Kruskal, pr, v119, p1743, (1960)", "Szekeres, pmd, v7, p285, (1960)"]:
Archive1_ :=`(13.24) p158`:
