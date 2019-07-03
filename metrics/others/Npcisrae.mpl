Ndim_ :=    4   :
x1_   :=   u   :
x2_   :=   w   :
x3_   :=   theta   :
x4_   :=   phi   :
eta12_   :=   1   :
eta34_   :=   -1   :
bd11_   :=   1/2*w/(m*r(u,w))^(1/2)   :
bd21_   :=   1/2*w/(m*r(u,w))^(1/2)   :
bd22_   :=   2*(m*r(u,w))^(1/2)/w   :
bd33_   :=   -1/2*I*r(u,w)*2^(1/2)   :
bd34_   :=   1/2*r(u,w)*sin(theta)*2^(1/2)   :
bd43_   :=   -1/2*I*r(u,w)*2^(1/2)   :
bd44_   :=   -1/2*r(u,w)*sin(theta)*2^(1/2)   :
constraint_ :=   [r(u,w) = 2*m+1/4*u*w/m]   :
Info_ := `        Israel coordinates (Phys. Rev. 143,1016)        `: 

