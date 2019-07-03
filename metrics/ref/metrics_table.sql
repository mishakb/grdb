drop index if exists metricid_index;
drop index if exists metricname_index;
drop table if exists metrics;
create table metrics (
metricid int NOT NULL,
metricname text NOT NULL,
metricinfo text,
metricreference text,
metricdimension int ,
metricinputtype text ,
x1_ text,
x2_ text,
x3_ text,
x4_ text,
sig_ text,
complex_ text,
metriclineelement text,
g11_ text,
g12_ text,
g13_ text,
g14_ text,
g21_ text,
g22_ text,
g23_ text,
g24_ text,
g31_ text,
g32_ text,
g33_ text,
g34_ text,
g41_ text,
g42_ text,
g43_ text,
g44_ text,
metrictype text,
metricconstraints text,
b11_ text,
b12_ text,
b13_ text,
b14_ text,
b21_ text,
b22_ text,
b23_ text,
b24_ text,
b31_ text,
b32_ text,
b33_ text,
b34_ text,
b41_ text,
b42_ text,
b43_ text,
b44_ text,
bd11_ text,
bd12_ text,
bd13_ text,
bd14_ text,
bd21_ text,
bd22_ text,
bd23_ text,
bd24_ text,
bd31_ text,
bd32_ text,
bd33_ text,
bd34_ text,
bd41_ text,
bd42_ text,
bd43_ text,
bd44_ text,
tetradtype text,
eta11_ text,
eta12_ text,
eta13_ text,
eta14_ text,
eta21_ text,
eta22_ text,
eta23_ text,
eta24_ text,
eta31_ text,
eta32_ text,
eta33_ text,
eta34_ text,
eta41_ text,
eta42_ text,
eta43_ text,
eta44_ text,
basemetrictype text,
energymomentumtype text,
killingvector1_ text,
killingvector2_ text,
killingvector3_ text,
killingvector4_ text,
petrovtype text,
petrovreport text,
segretype text,
lambdatype text,
isotropytype text,
isotropyinfo text,
isometrytype text,
kshm_reference text,
skea_reference text,
hawking_ellis_reference text,
metriclineelementhtml text
);
create unique index metricid_index on metrics(metricid);
create unique index metricname_index on metrics(metricname);