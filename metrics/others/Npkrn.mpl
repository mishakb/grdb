Ndim_ :=    4   :
x1_   :=   u   :
x2_   :=   v   :
x3_   :=   theta   :
x4_   :=   phi   :
eta12_   :=   1   :
eta34_   :=   -1   :
b12_   :=   1/4*2^(1/2)/m/(-(-2*m+r(u,v))/u/v/r(u,v))^(1/2)   :
b21_   :=   1/4*2^(1/2)/m/(-(-2*m+r(u,v))/u/v/r(u,v))^(1/2)   :
b33_   :=   1/2/r(u,v)*2^(1/2)   :
b34_   :=   1/2*I/r(u,v)/sin(theta)*2^(1/2)   :
b43_   :=   1/2/r(u,v)*2^(1/2)   :
b44_   :=   -1/2*I/r(u,v)/sin(theta)*2^(1/2)   :
constraint_ :=   [diff(r(u,v),u) = -2*m*(2*m-r(u,v))/r(u,v)/u, diff(r(u,v),v) = -2*m*(2*m-r(u,v))/r(u,v)/v]   :
Info_ := `        Null form of Kruskal metric        `: 

