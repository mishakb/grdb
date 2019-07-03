grdef(`WS{a [ b c ] }:=R{a b ; c}-R{a c ; b}-(g{a b}*R{^e e; c}-g{a c}*R{^f f ; b})/4`); 
grcalc(WS(dn,dn,dn));
*grdisplay(_);
