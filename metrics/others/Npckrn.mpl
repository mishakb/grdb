Ndim_ :=    4   :
x1_   :=   u   :
x2_   :=   v   :
x3_   :=   theta   :
x4_   :=   phi   :
eta12_   :=   1   :
eta34_   :=   -1   :
bd11_   :=   -2*m*(-2*m+r(u,v))*2^(1/2)/u/v/r(u,v)/((2*m-r(u,v))/u/v/r(u,v))^(1/2)   :
bd22_   :=   -2*m*(-2*m+r(u,v))*2^(1/2)/u/v/r(u,v)/((2*m-r(u,v))/u/v/r(u,v))^(1/2)   :
bd33_   :=   -1/2*r(u,v)*2^(1/2)   :
bd34_   :=   -1/2*I*r(u,v)*sin(theta)*2^(1/2)   :
bd43_   :=   -1/2*r(u,v)*2^(1/2)   :
bd44_   :=   1/2*I*r(u,v)*sin(theta)*2^(1/2)   :
constraint_ :=   [diff(r(u,v),u) = -2*m*(2*m-r(u,v))/r(u,v)/u, diff(r(u,v),v) = -2*m*(2*m-r(u,v))/r(u,v)/v]   :
Info_ := `            Null form of Kruskal metric            `: 

