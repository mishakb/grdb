grdef(`A{a b d}:=C{a c b d ; ^c}`);
grdef(`B{a b}:=A{a b d ; ^d}+R{^c ^d}*C{a c b d}/2`);
grcalc(B(up,dn));
*grdisplay(_);
