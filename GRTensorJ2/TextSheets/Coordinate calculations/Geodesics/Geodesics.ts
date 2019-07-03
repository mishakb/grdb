grOptionCoordNames:=false:
grdef(`X{^a}`); grdef(`u{^a}`); grdef(`U{^a}`); grdef(`G{^a}`);
initzero(X(up)); initzero(u(up)); initzero(U(up)); initzero(G(up));
grundefine(X(up)); grundefine(u(up)); grundefine(U(up)); grundefine(G(up));
grdef(`X{^a}:=[x1(lambda),x2(lambda),x3(lambda),x4(lambda)]`);
grdef(`u{^a}:=[diff(x1(lambda),lambda),diff(x2(lambda),lambda),diff(x3(lambda),lambda),diff(x4(lambda),lambda)]`);
grdef(`(U{^a}:=[diff(diff(x1(lambda),lambda),lambda),diff(diff(x2(lambda),lambda),lambda),diff(diff(x3(lambda),lambda),lambda),diff(diff(x4(lambda),lambda),lambda)]`);
grdef(`G{^a}:=U{^a}+Chr{b c ^a}*u{^b}*u{^c}`);
grcalc(G(up));
*grdisplay(coordinates,G(up));




