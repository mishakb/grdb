Ndim_ :=    4   :
x1_   :=   u   :
x2_   :=   v   :
x3_   :=   Theta   :
x4_   :=   Phi   :
eta12_   :=   1   :
eta34_   :=   -1   :
bd11_   :=   2*m*(r(u,v)-2*m)*2^(1/2)/((r(u,v)-2*m)*r(u,v)*(u-v)*(u+v))^(1/2)   :
bd12_   :=   -2*m*(r(u,v)-2*m)*2^(1/2)/((r(u,v)-2*m)*r(u,v)*(u-v)*(u+v))^(1/2)   :
bd21_   :=   2*m*(r(u,v)-2*m)*2^(1/2)/((r(u,v)-2*m)*r(u,v)*(u-v)*(u+v))^(1/2)   :
bd22_   :=   2*m*(r(u,v)-2*m)*2^(1/2)/((r(u,v)-2*m)*r(u,v)*(u-v)*(u+v))^(1/2)   :
bd33_   :=   -1/2*I*r(u,v)*2^(1/2)   :
bd34_   :=   1/2*r(u,v)*sin(Theta)*2^(1/2)   :
bd43_   :=   -1/2*I*r(u,v)*2^(1/2)   :
bd44_   :=   -1/2*r(u,v)*sin(Theta)*2^(1/2)   :
constraint_ :=   [diff(r(u,v),u) = 4*u*m/(-u^2+v^2)*(-r(u,v)+2*m)/r(u,v), diff(r(u,v),v) = -4*v*m/(-u^2+v^2)*(-r(u,v)+2*m)/r
(u,v)]   :
Info_:= `Kruskal's original coordinates (Phys. Rev. 119, 1743)`:
