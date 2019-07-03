Ndim_ :=    4   :
x1_   :=   u   :
x2_   :=   w   :
x3_   :=   theta   :
x4_   :=   phi   :
eta12_   :=   1   :
eta34_   :=   -1   :
b12_   :=   1/2*w/(m*r(u,w))^(1/2)   :
b21_   :=   2*(m*r(u,w))^(1/2)/w   :
b22_   :=   -1/2*w/(m*r(u,w))^(1/2)   :
b33_   :=   -1/2*I/r(u,w)*2^(1/2)   :
b34_   :=   1/2/r(u,w)/sin(theta)*2^(1/2)   :
b43_   :=   -1/2*I/r(u,w)*2^(1/2)   :
b44_   :=   -1/2/r(u,w)/sin(theta)*2^(1/2)   :
constraint_ :=   [r(u,w) = 2*m+1/4*u*w/m]   :
sig_:=-2:
Info_ := `    Israel coordinates (Phys. Rev. 143,1016)    `: 

