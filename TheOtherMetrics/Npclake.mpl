Ndim_ :=    4   :
x1_   :=   t   :
x2_   :=   r   :
x3_   :=   theta   :
x4_   :=   phi   :
eta12_   :=   1   :
eta34_   :=   -1   :
bd11_   :=   1/2*2^(1/2)*(r-2*m)*(r/(r-2*m))^(1/2)/r   :
bd12_   :=   -1/2*((r/(r-2*m))^(1/2)*r-2*(r/(r-2*m))^(1/2)*m+epsilon*(-(-r+c*r-2*m*c)/r)^(1/2)*r*((r-2*m)/r)^(1/2))*2^(1/2)/
(r-2*m)   :
bd21_   :=   1/2*2^(1/2)*(r-2*m)*(r/(r-2*m))^(1/2)/r   :
bd22_   :=   -1/2*(-(r/(r-2*m))^(1/2)*r+2*(r/(r-2*m))^(1/2)*m+epsilon*(-(-r+c*r-2*m*c)/r)^(1/2)*r*((r-2*m)/r)^(1/2))*2^(1/2)
/(r-2*m)   :
bd33_   :=   -1/2*r*2^(1/2)   :
bd34_   :=   -1/2*I*r*sin(theta)*2^(1/2)   :
bd43_   :=   -1/2*r*2^(1/2)   :
bd44_   :=   1/2*I*r*sin(theta)*2^(1/2)   :
constraint_ :=   [epsilon^2 = 1, epsilon^4 = 1, epsilon^6 = 1, epsilon^8 = 1]   :
Info_ := `        epsilon=+/-1, 0<=c<=1,c=0->Eddington-Finkelstein        `: 

