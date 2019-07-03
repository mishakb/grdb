#Explanation of Simplification
#=============================
#To put it simply, nothing is more important.
#
#To start, if the spacetime has constraints, and you do not apply them,
#you are not working in the spacetime of your choice.
#
#We have found that the global simplification strategy is of central importance 
#for the computer algebra calculation of curvature in spacetime. Summarized here 
#are some general rules of simplification appropriate to GRTensorII running under 
#MapleV. Although the general philosophy described here is more widely applicable, 
#our comments are specific to GRTensorII under MapleV.
#
#i) There should be some default simplification procedure applied to every step of 
#a calculation. Failure to do this can make a simple calculation intractable. The 
#Maple routine normal is a good starting point for the default. If the calculation 
#involves exponentials ( e.g. the Bondi metric ) the routine expand may be more 
#appropriate. Only if very general functions are involved is it appropriate to 
#consider no defaultsimplification. In general cases this may be the optimal choice.
#
#ii) For both coordinate and tetrad calculations the removal of trigonometric and 
#like functions via elementary coordinate transformations will improve performance.
#
#iii) Simplification of the metric tensor or tetrad components before further 
#calculation will improve performance.
#
#iv) Precalculation and further simplification of the spin coefficients ( and their 
#complex conjugates ) will improve performance only in more complicated cases. The 
#same holds for the Christoffel symbols in the coordinate approach.
#
#v) For further simplification after an object has been calculated, the Maple routine 
#simplify is seldom a good first choice. The routine expand followed by factor is often 
#more appropriate. If the situation is sufficiently general ( e.g. the Debever-McLenaghan
#-Tariq metric ) there will be no further simplification if normal has been used as default.
#
#vi) If complicated functions are involved, it can be advantageous to substitute the 
#explicit forms of the functions after a more general calculation is completed.
#
#vii) When a calculation is proceeding slowly, it should be halted, the simplification 
#strategy altered, and the worksheet reexecuted.
#
#For most situations these general rules will give adequate performance, and reduce the 
#calculation of curvature for even complex spacetimes to an essentially trivial exercise. 
#Usually, it is the answer that is of interest and not the fact that the simplification 
#strategy is optimal. When optimal simplification strategies are the prime concern the
#problem is more involved because of the large number of simplification procedures available
#and the size of the resultant parameter space to be explored.


