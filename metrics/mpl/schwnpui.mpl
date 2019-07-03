Ndim_ := 4:
x1_ := t:
x2_ := r:
x3_ := theta:
x4_ := phi:
sig_ := -2:
complex_ := {}:
eta12_ := 1:
eta34_ := -1:
b11_ := 1:
b12_ := -(epsilon*((r-c*r+2*m*c)/r)^(1/2)*r+(r*(c*r-2*m*c+epsilon^2*r-epsilon^2*c*r+2*epsilon^2*m*c))^(1/2))/c/r:
b21_ := 1/2*c*r/(c*r-2*m*c+epsilon^2*r-epsilon^2*c*r+2*epsilon^2*m*c):
b22_ := -1/2*(epsilon*((r-c*r+2*m*c)/r)^(1/2)*r-(r*(c*r-2*m*c+epsilon^2*r-epsilon^2*c*r+2*epsilon^2*m*c))^(1/2))/(c*r-2*m*c+epsilon^2*r-epsilon^2*c*r+2*epsilon^2*m*c):
b33_ := 1/2*I*2^(1/2)/r:
b34_ := 1/2*2^(1/2)/r/sin(theta):
b43_ := -1/2*I*2^(1/2)/r:
b44_ := 1/2*2^(1/2)/r/sin(theta):
constraint_ := [epsilon^2 = 1, epsilon^4 = 1, epsilon^6 = 1, epsilon^8 = 1]:
Info_ := `Contravariant NP tetrad. epsilon=+/-1, 0<=c<=1,c=0->Eddington-Finkelstein form of the Schwarzschild exterior metric`:
Ref_:=["gr-qc/9407005","gr-qc/0001069"]:
