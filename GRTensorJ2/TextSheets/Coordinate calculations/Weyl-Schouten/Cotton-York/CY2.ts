grdef(`CY{^a ^b}:=2*LevC{^a^c^d}*(R{^b c ;d}-kdelta{^b c}*R{^f f ;d}/4)`):
grdef(`CY2:=CY{^a b}*CY{a ^b}`):
grcalc(CY2):
*grdisplay(_);



