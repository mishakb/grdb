/****************************************************************
*
* GRDB : MetricRecord.java
*
*
* Note: GRDB1 is the development and test area.
*       GRDB2 is the operational and running package.
*
*
* (C) 1999-2003 Mustapha Ishak and Kayll Lake
*
*
* File Created By: Mustapha Ishak
*           Date : May, 1999
*           
*
* Purpose: invoking the calculator.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2;

/**
 * This class encapsulates the data for a Metric record
 *
 */
public class MetricRecord
{

// here import the database structure from the file grdbstructure
//
        int	metricid = 0 ; 
	String	metricname = "" ;
	String	metricinfo = "" ;
	String	metricreference = "" ;
	int	metricdimension = 0 ; 
	String	metricinputtype = "" ;
	String	x1_ = "" ;
	String	x2_ = "" ;
	String	x3_ = "" ;
	String	x4_ = "" ;
	
	String	sig_ = "" ;
	String	complex_ = "" ;

	String	metriclineelement = "" ;

	String	g11_	= "" ;
	String	g12_	= "" ;
	String	g13_	= "" ;
	String	g14_	= "" ;
	String	g21_	= "" ;
	String	g22_	= "" ;
	String	g23_	= "" ;
	String	g24_	= "" ;
	String	g31_	= "" ;
	String	g32_	= "" ;
	String	g33_	= "" ;
	String	g34_	= "" ;
	String	g41_	= "" ;
	String	g42_	= "" ;
	String	g43_	= "" ;
	String	g44_	= "" ;

	String	metrictype = "" ;
	String	metricconstraints = "" ;

	String	b11_	= "" ;
	String	b12_	= "" ;
	String	b13_	= "" ;
	String	b14_	= "" ;
	String	b21_	= "" ;
	String	b22_	= "" ;
	String	b23_	= "" ;
	String	b24_	= "" ;
	String	b31_	= "" ;
	String	b32_	= "" ;
	String	b33_	= "" ;
	String	b34_	= "" ;
	String	b41_	= "" ;
	String	b42_	= "" ;
	String	b43_	= "" ;
	String	b44_	= "" ;

	String	bd11_	= "" ;
	String	bd12_	= "" ;
	String	bd13_	= "" ;
	String	bd14_	= "" ;
	String	bd21_	= "" ;
	String	bd22_	= "" ;
	String	bd23_	= "" ;
	String	bd24_	= "" ;
	String	bd31_	= "" ;
	String	bd32_	= "" ;
	String	bd33_	= "" ;
	String	bd34_	= "" ;
	String	bd41_	= "" ;
	String	bd42_	= "" ;
	String	bd43_	= "" ;
	String	bd44_	= "" ;

	String	tetradtype	 = "" ;

	String	eta11_= "" ;
	String	eta12_= "" ;
	String	eta13_= "" ;
	String	eta14_= "" ;
	String	eta21_= "" ;
	String	eta22_= "" ;
	String	eta23_= "" ;
	String	eta24_= "" ;
	String	eta31_= "" ;
	String	eta32_= "" ;
	String	eta33_= "" ;
	String	eta34_= "" ;
	String	eta41_= "" ;
	String	eta42_= "" ;
	String	eta43_= "" ;
	String	eta44_= "" ;

	String	basemetrictype = "" ;

	String	energymomentumtype = "" ;

	String	killingvector1_ = "" ;
	String	killingvector2_ = "" ;
	String	killingvector3_ = "" ;
	String	killingvector4_ = "" ;

	String	petrovtype 	= "" ;
	String	petrovreport 	= "" ;

	String	segretype 	= "" ;

	String	lambdatype 	= "" ;

	String	isotropytype 	= "" ;
	String	isotropyinfo 	= "" ;

	String	isometrytype 	= "" ;

	String	kshm_reference 	= "" ;
	String	skea_reference 	= "" ;
	String	hawking_ellis_reference = "" ;

	String	metriclineelementhtml 	= "" ;
	
// end structure

    public MetricRecord ()    {   }

    public MetricRecord (
        int	metricid ,
	String	metricname,
	String	metricinfo,
	String	metricreference,
	int	metricdimension,
	String	metricinputtype,
	String	x1_,
	String	x2_,
	String	x3_,
	String	x4_,
	String	metriclineelement,
	String	g11_,
	String	g12_,
	String	g13_,
	String	g14_,
	String	g21_,
	String	g22_,
	String	g23_,
	String	g24_,
	String	g31_,
	String	g32_,
	String	g33_,
	String	g34_,
	String	g41_,
	String	g42_,
	String	g43_,
	String	g44_,
	String	metrictype,
	String	metricconstraints,

	String	tetrad11_,
	String	tetrad12_,
	String	tetrad13_,
	String	tetrad14_,
	String	tetrad21_,
	String	tetrad22_,
	String	tetrad23_,
	String	tetrad24_,
	String	tetrad31_,
	String	tetrad32_,
	String	tetrad33_,
	String	tetrad34_,
	String	tetrad41_,
	String	tetrad42_,
	String	tetrad43_,
	String	tetrad44_,
	String	tetradtype,
	String	eta11_	,
	String	eta12_	,
	String	eta13_	,
	String	eta14_	,
	String	eta21_	,
	String	eta22_	,
	String	eta23_	,
	String	eta24_	,
	String	eta31_	,
	String	eta32_	,
	String	eta33_	,
	String	eta34_	,
	String	eta41_	,
	String	eta42_	,
	String	eta43_	,
	String	eta44_	,
	String	basemetrictype ,

	String	t11_	,
	String	t12_	,
	String	t13_	,
	String	t14_	,
	String	t21_	,
	String	t22_	,
	String	t23_	,
	String	t24_	,
	String	t31_	,
	String	t32_	,
	String	t33_	,
	String	t34_	,
	String	t41_	,
	String	t42_	,
	String	t43_	,
	String	t44_	,
	String	energymomentumtype ,

	String	killingvector1_ ,
	String	killingvector2_ ,
	String	killingvector3_ ,
	String	killingvector4_ ,

	String	petrovtype ,
	String	petrovreport ,

	String	segretype ,

	String	lambdatype ,

	String	isotropytype ,
	String	isotropyinfo ,

	String	isometrytype ,
	String	kshm_reference,
	String	metriclineelementhtml 	)
    {
        this.metricid = metricid ; 
	this.metricname = metricname ;
	this.metricinfo = metricinfo ;
	this.metricreference = metricreference ;
	this.metricdimension = metricdimension ; 
	this.metricinputtype = metricinputtype ;
	this.x1_ = x1_ ;
	this.x2_ = x2_ ;
	this.x3_ = x3_ ;
	this.x4_ = x4_ ;

	this.sig_ = sig_ ;
	this.complex_ = complex_ ;

	this.metriclineelement = metriclineelement ;

	this.g11_	= g11_ ;
	this.g12_	= g12_ ;
	this.g13_	= g13_ ;
	this.g14_	= g14_ ;
	this.g21_	= g21_ ;
	this.g22_	= g22_ ;
	this.g23_	= g23_ ;
	this.g24_	= g24_ ;
	this.g31_	= g31_ ;
	this.g32_	= g32_ ;
	this.g33_	= g33_ ;
	this.g34_	= g34_ ;
	this.g41_	= g41_ ;
	this.g42_	= g42_ ;
	this.g43_	= g43_ ;
	this.g44_	= g44_ ;

	this.metrictype = metrictype ;
	this.metricconstraints = metricconstraints ;

	this.b11_	= b11_ ;
	this.b12_	= b12_ ;
	this.b13_	= b13_ ;
	this.b14_	= b14_ ;
	this.b21_	= b21_ ;
	this.b22_	= b22_ ;
	this.b23_	= b23_ ;
	this.b24_	= b24_ ;
	this.b31_	= b31_ ;
	this.b32_	= b32_ ;
	this.b33_	= b33_ ;
	this.b34_	= b34_ ;
	this.b41_	= b41_ ;
	this.b42_	= b42_ ;
	this.b43_	= b43_ ;
	this.b44_	= b44_ ;

	this.bd11_	= bd11_ ;
	this.bd12_	= bd12_ ;
	this.bd13_	= bd13_ ;
	this.bd14_	= bd14_ ;
	this.bd21_	= bd21_ ;
	this.bd22_	= bd22_ ;
	this.bd23_	= bd23_ ;
	this.bd24_	= bd24_ ;
	this.bd31_	= bd31_ ;
	this.bd32_	= bd32_ ;
	this.bd33_	= bd33_ ;
	this.bd34_	= bd34_ ;
	this.bd41_	= bd41_ ;
	this.bd42_	= bd42_ ;
	this.bd43_	= bd43_ ;
	this.bd44_	= bd44_ ;

	this.tetradtype	 = tetradtype ;
	this.eta11_		= eta11_ ;
	this.eta12_		= eta12_ ;
	this.eta13_		= eta13_ ;
	this.eta14_		= eta14_ ;
	this.eta21_		= eta21_ ;
	this.eta22_		= eta22_ ;
	this.eta23_		= eta23_ ;
	this.eta24_		= eta24_ ;
	this.eta31_		= eta31_ ;
	this.eta32_		= eta32_ ;
	this.eta33_		= eta33_ ;
	this.eta34_		= eta34_ ;
	this.eta41_		= eta41_ ;
	this.eta42_		= eta42_ ;
	this.eta43_		= eta43_ ;
	this.eta44_		= eta44_ ;
	this.basemetrictype = basemetrictype ;

	this.energymomentumtype = energymomentumtype ;

	this.killingvector1_ 	= killingvector1_ ;
	this.killingvector2_ 	= killingvector2_ ;
	this.killingvector3_ 	= killingvector3_ ;
	this.killingvector4_ 	= killingvector4_ ;

	this.petrovtype 	= petrovtype ;
	this.petrovreport 	= petrovreport ;

	this.segretype 	= segretype ;

	this.lambdatype 	= lambdatype ;

	this.isotropytype 	= isotropytype ;
	this.isotropyinfo 	= isotropyinfo ;

	this.isometrytype 	= isometrytype ;

	this.kshm_reference 	= kshm_reference ;
	this.skea_reference 	= kshm_reference ;
	this.hawking_ellis_reference 	= kshm_reference ;

	this.metriclineelementhtml 	= metriclineelementhtml ;
    }

        public  int	getmetricid () 	{ return (metricid  ) ; }
	public	String	getmetricname () 	{ return (metricname  ) ; }
	public	String	getmetricinfo () 	{ return (metricinfo  ) ; }
	public	String	getmetricreference () 	{ return (metricreference) ; }
	public	int	getmetricdimension () 	{ return (metricdimension ) ; }
	public	String	getmetricinputtype () 	{ return (metricinputtype  ) ; }
	public	String	getx1_ () 	{ return (x1_  ) ; }
	public	String	getx2_ () 	{ return (x2_  ) ; }
	public	String	getx3_ () 	{ return (x3_  ) ; }
	public	String	getx4_ () 	{ return (x4_  ) ; }
	public	String	getsig_ () { return (sig_); }
	public	String	getcomplex_ () { return (complex_); }

	public	String	getmetriclineelement () { return (metriclineelement); }

	public	String	getg11_	() 	{ return (g11_  ) ; }
	public	String	getg12_	() 	{ return (g12_  ) ; }
	public	String	getg13_	() 	{ return (g13_  ) ; }
	public	String	getg14_	() 	{ return (g14_  ) ; }
	public	String	getg21_	() 	{ return (g21_  ) ; }
	public	String	getg22_	() 	{ return (g22_  ) ; }
	public	String	getg23_	() 	{ return (g23_  ) ; }
	public	String	getg24_	() 	{ return (g24_  ) ; }
	public	String	getg31_	() 	{ return (g31_  ) ; }
	public	String	getg32_	() 	{ return (g32_  ) ; }
	public	String	getg33_	() 	{ return (g33_  ) ; }
	public	String	getg34_	() 	{ return (g34_  ) ; }
	public	String	getg41_	() 	{ return (g41_  ) ; }
	public	String	getg42_	() 	{ return (g42_  ) ; }
	public	String	getg43_	() 	{ return (g43_  ) ; }
	public	String	getg44_	() 	{ return (g44_  ) ; }

	public	String	getmetrictype () 	{ return (metrictype  ) ; }
	public	String	getmetricconstraints () { return (metricconstraints) ; }

	public	String	getb11_	() 	{ return (b11_  ) ; }
	public	String	getb12_	() 	{ return (b12_  ) ; }
	public	String	getb13_	() 	{ return (b13_  ) ; }
	public	String	getb14_	() 	{ return (b14_  ) ; }
	public	String	getb21_	() 	{ return (b21_  ) ; }
	public	String	getb22_	() 	{ return (b22_  ) ; }
	public	String	getb23_	() 	{ return (b23_  ) ; }
	public	String	getb24_	() 	{ return (b24_  ) ; }
	public	String	getb31_	() 	{ return (b31_  ) ; }
	public	String	getb32_	() 	{ return (b32_  ) ; }
	public	String	getb33_	() 	{ return (b33_  ) ; }
	public	String	getb34_	() 	{ return (b34_  ) ; }
	public	String	getb41_	() 	{ return (b41_  ) ; }
	public	String	getb42_	() 	{ return (b42_  ) ; }
	public	String	getb43_	() 	{ return (b43_  ) ; }
	public	String	getb44_	() 	{ return (b44_  ) ; }

	public	String	getbd11_	() 	{ return (bd11_  ) ; }
	public	String	getbd12_	() 	{ return (bd12_  ) ; }
	public	String	getbd13_	() 	{ return (bd13_  ) ; }
	public	String	getbd14_	() 	{ return (bd14_  ) ; }
	public	String	getbd21_	() 	{ return (bd21_  ) ; }
	public	String	getbd22_	() 	{ return (bd22_  ) ; }
	public	String	getbd23_	() 	{ return (bd23_  ) ; }
	public	String	getbd24_	() 	{ return (bd24_  ) ; }
	public	String	getbd31_	() 	{ return (bd31_  ) ; }
	public	String	getbd32_	() 	{ return (bd32_  ) ; }
	public	String	getbd33_	() 	{ return (bd33_  ) ; }
	public	String	getbd34_	() 	{ return (bd34_  ) ; }
	public	String	getbd41_	() 	{ return (bd41_  ) ; }
	public	String	getbd42_	() 	{ return (bd42_  ) ; }
	public	String	getbd43_	() 	{ return (bd43_  ) ; }
	public	String	getbd44_	() 	{ return (bd44_  ) ; }

	public	String	gettetradtype	 () 	{ return (tetradtype  ) ; }

	public	String	geteta11_	() 	{ return (eta11_  ) ; }
	public	String	geteta12_	() 	{ return (eta12_  ) ; }
	public	String	geteta13_	() 	{ return (eta13_  ) ; }
	public	String	geteta14_	() 	{ return (eta14_  ) ; }
	public	String	geteta21_	() 	{ return (eta21_  ) ; }
	public	String	geteta22_	() 	{ return (eta22_  ) ; }
	public	String	geteta23_	() 	{ return (eta23_  ) ; }
	public	String	geteta24_	() 	{ return (eta24_  ) ; }
	public	String	geteta31_	() 	{ return (eta31_  ) ; }
	public	String	geteta32_	() 	{ return (eta32_  ) ; }
	public	String	geteta33_	() 	{ return (eta33_  ) ; }
	public	String	geteta34_	() 	{ return (eta34_  ) ; }
	public	String	geteta41_	() 	{ return (eta41_  ) ; }
	public	String	geteta42_	() 	{ return (eta42_  ) ; }
	public	String	geteta43_	() 	{ return (eta43_  ) ; }
	public	String	geteta44_	() 	{ return (eta44_  ) ; }

	public	String	getbasemetrictype () { return (basemetrictype) ; }

	public	String	getenergymomentumtype () {return (energymomentumtype);}

	public	String	getkillingvector1_() 	{ return (killingvector1_ ) ; }
	public	String	getkillingvector2_() 	{ return (killingvector2_ ) ; }
	public	String	getkillingvector3_() 	{ return (killingvector3_ ) ; }
	public	String	getkillingvector4_() 	{ return (killingvector4_ ) ; }

	public	String	getpetrovtype 	()	{ return (petrovtype) ; }
	public	String	getpetrovreport ()	{ return (petrovreport);}

	public	String	getsegretype 	() 	{ return (segretype  ) ; }

	public	String	getlambdatype 	() 	{ return (lambdatype  ) ; }

	public	String	getisotropytype () 	{ return (isotropytype) ; }
	public	String	getisotropyinfo () 	{ return (isotropyinfo  ) ; }

	public	String	getisometrytype () 	{ return (isometrytype  ) ; }

	public	String	getkshm_reference () 	{ return (kshm_reference  ) ; }
	public	String	getskea_reference () 	{ return (skea_reference  ) ; }
	public	String	gethawking_ellis_reference () 	{ return (hawking_ellis_reference  ) ; }

	public	String	getmetriclineelementhtml () 	{ return (metriclineelementhtml  ) ; }


	public void setmetricid (int metricid )
	{ this.metricid = metricid ; }

	public void setmetricname (String metricname )
	{ this.metricname=  metricname ; }

	public void setmetricinfo (String metricinfo )
	{ this.metricinfo = metricinfo ; }
	
	public void setmetricreference (String metricreference )
	{ this.metricreference=  metricreference ; }

	public void setmetricdimension (int metricdimension )
	{ this.metricdimension =  metricdimension ; }

	public void setmetricinputtype (String metricinputtype )
	{ this.metricinputtype =  metricinputtype ; }

	public void setx1_ (String x1_ )
	{ this.x1_ =  x1_ ; }

	public void setx2_ (String x2_ )
	{ this.x2_  = x2_ ; }

	public void setx3_ (String x3_ )
	{ this.x3_ =  x3_ ; }

	public void setx4_ (String x4_ )
	{ this.x4_ =  x4_ ; }


	public void setsig_ (String sig_ )
	{ this.sig_ = sig_ ; }

	public void setcomplex_ (String complex_ )
	{ this.complex_ = complex_ ; }

	public void setmetriclineelement (String metriclineelement )
	{ this.metriclineelement = metriclineelement ; }

	public void setg11_	(String g11_	)
	{ this.g11_ = 	g11_	; }
	public void setg12_	(String g12_	)
	{ this.g12_ = 	g12_	; }
	public void setg13_	(String g13_	)
	{ this.g13_ = 	g13_	; }
	public void setg14_	(String g14_	)
	{ this.g14_ = 	g14_	; }
	public void setg21_	(String g21_	)
	{ this.g21_ = 	g21_	; }
	public void setg22_	(String g22_	)
	{ this.g22_ = 	g22_	; }
	public void setg23_	(String g23_	)
	{ this.g23_ = 	g23_	; }
	public void setg24_	(String g24_	)
	{ this.g24_ = 	g24_	; }
	public void setg31_	(String g31_	)
	{ this.g31_ = 	g31_	; }
	public void setg32_	(String g32_	)
	{ this.g32_ = 	g32_	; }
	public void setg33_	(String g33_	)
	{ this.g33_ = 	g33_	; }
	public void setg34_	(String g34_	)
	{ this.g34_ = 	g34_	; }
	public void setg41_	(String g41_	)
	{ this.g41_ = 	g41_	; }
	public void setg42_	(String g42_	)
	{ this.g42_ = 	g42_	; }
	public void setg43_	(String g43_	)
	{ this.g43_ = 	g43_	; }
	public void setg44_	(String g44_	)
	{ this.g44_ = 	g44_	; }

	public void setmetrictype (String metrictype )
	{ this.metrictype =  metrictype ; }

	public void setmetricconstraints (String metricconstraints )
	{ this.metricconstraints =  metricconstraints ; }

	public void setb11_	(String b11_	)
	{ this.b11_ = 	b11_	; }
	public void setb12_	(String b12_	)
	{ this.b12_ = 	b12_	; }
	public void setb13_	(String b13_	)
	{ this.b13_ = 	b13_	; }
	public void setb14_	(String b14_	)
	{ this.b14_ = 	b14_	; }
	public void setb21_	(String b21_	)
	{ this.b21_ = 	b21_	; }
	public void setb22_	(String b22_	)
	{ this.b22_ = 	b22_	; }
	public void setb23_	(String b23_	)
	{ this.b23_ = 	b23_	; }
	public void setb24_	(String b24_	)
	{ this.b24_ = 	b24_	; }
	public void setb31_	(String b31_	)
	{ this.b31_ = 	b31_	; }
	public void setb32_	(String b32_	)
	{ this.b32_ = 	b32_	; }
	public void setb33_	(String b33_	)
	{ this.b33_ = 	b33_	; }
	public void setb34_	(String b34_	)
	{ this.b34_ = 	b34_	; }
	public void setb41_	(String b41_	)
	{ this.b41_ = 	b41_	; }
	public void setb42_	(String b42_	)
	{ this.b42_ = 	b42_	; }
	public void setb43_	(String b43_	)
	{ this.b43_ = 	b43_	; }
	public void setb44_	(String b44_	)
	{ this.b44_ = 	b44_	; }

	public void setbd11_	(String bd11_	)
	{ this.bd11_ = 	bd11_	; }
	public void setbd12_	(String bd12_	)
	{ this.bd12_ = 	bd12_	; }
	public void setbd13_	(String bd13_	)
	{ this.bd13_ = 	bd13_	; }
	public void setbd14_	(String bd14_	)
	{ this.bd14_ = 	bd14_	; }
	public void setbd21_	(String bd21_	)
	{ this.bd21_ = 	bd21_	; }
	public void setbd22_	(String bd22_	)
	{ this.bd22_ = 	bd22_	; }
	public void setbd23_	(String bd23_	)
	{ this.bd23_ = 	bd23_	; }
	public void setbd24_	(String bd24_	)
	{ this.bd24_ = 	bd24_	; }
	public void setbd31_	(String bd31_	)
	{ this.bd31_ = 	bd31_	; }
	public void setbd32_	(String bd32_	)
	{ this.bd32_ = 	bd32_	; }
	public void setbd33_	(String bd33_	)
	{ this.bd33_ = 	bd33_	; }
	public void setbd34_	(String bd34_	)
	{ this.bd34_ = 	bd34_	; }
	public void setbd41_	(String bd41_	)
	{ this.bd41_ = 	bd41_	; }
	public void setbd42_	(String bd42_	)
	{ this.bd42_ = 	bd42_	; }
	public void setbd43_	(String bd43_	)
	{ this.bd43_ = 	bd43_	; }
	public void setbd44_	(String bd44_	)
	{ this.bd44_ = 	bd44_	; }

	public void settetradtype	(String tetradtype	)
	{ this.tetradtype = 	tetradtype	; }

	public void seteta11_	(String eta11_	)
	{ this.eta11_ = 	eta11_	; }
	public void seteta12_	(String eta12_	)
	{ this.eta12_ = 	eta12_	; }
	public void seteta13_	(String eta13_	)
	{ this.eta13_ = 	eta13_	; }
	public void seteta14_	(String eta14_	)
	{ this.eta14_ = 	eta14_	; }
	public void seteta21_	(String eta21_	)
	{ this.eta21_ = 	eta21_	; }
	public void seteta22_	(String eta22_	)
	{ this.eta22_ = 	eta22_	; }
	public void seteta23_	(String eta23_	)
	{ this.eta23_ = 	eta23_	; }
	public void seteta24_	(String eta24_	)
	{ this.eta24_ = 	eta24_	; }
	public void seteta31_	(String eta31_	)
	{ this.eta31_ = 	eta31_	; }
	public void seteta32_	(String eta32_	)
	{ this.eta32_ = 	eta32_	; }
	public void seteta33_	(String eta33_	)
	{ this.eta33_ = 	eta33_	; }
	public void seteta34_	(String eta34_	)
	{ this.eta34_ = 	eta34_	; }
	public void seteta41_	(String eta41_	)
	{ this.eta41_ = 	eta41_	; }
	public void seteta42_	(String eta42_	)
	{ this.eta42_ = 	eta42_	; }
	public void seteta43_	(String eta43_	)
	{ this.eta43_ = 	eta43_	; }
	public void seteta44_	(String eta44_	)
	{ this.eta44_ = 	eta44_	; }

	public void setbasemetrictype (String basemetrictype )
	{ this.basemetrictype  = basemetrictype ; }

	public void setenergymomentumtype (String energymomentumtype )
	{ this.energymomentumtype  = energymomentumtype ; }

	public void setkillingvector1_ 	(String killingvector1_ 	)
	{ this.killingvector1_  = 	killingvector1_ 	; }
	public void setkillingvector2_ 	(String killingvector2_ 	)
	{ this.killingvector2_  = 	killingvector2_ 	; }
	public void setkillingvector3_ 	(String killingvector3_ 	)
	{ this.killingvector3_  = 	killingvector3_ 	; }
	public void setkillingvector4_ 	(String killingvector4_ 	)
	{ this.killingvector4_  = 	killingvector4_ 	; }

	public void setpetrovtype 	(String petrovtype 	)
	{ this.petrovtype  = 	petrovtype 	; }

	public void setpetrovreport 	(String petrovreport 	)
	{ this.petrovreport  = 	petrovreport 	; }

	public void setsegretype 	(String segretype 	)
	{ this.segretype  = 	segretype 	; }

	public void setlambdatype 	(String lambdatype 	)
	{ this.lambdatype  = 	lambdatype 	; }

	public void setisotropytype 	(String isotropytype 	)
	{ this.isotropytype  = 	isotropytype 	; }

	public void setisotropyinfo 	(String isotropyinfo 	)
	{ this.isotropyinfo  = 	isotropyinfo 	; }

	public void setisometrytype 	(String isometrytype 	)
	{ this.isometrytype  = 	isometrytype ; }

	public void setkshm_reference 	(String kshm_reference 	)
	{ this.kshm_reference  = 	kshm_reference 	; }

	public void setskea_reference 	(String skea_reference 	)
	{ this.skea_reference  = 	skea_reference 	; }

	public void sethawking_ellis_reference 	(String hawking_ellis_reference 	)
	{ this.hawking_ellis_reference  = 	hawking_ellis_reference 	; }
	public void setmetriclineelementhtml 	(String metriclineelementhtml 	)
	{ this.metriclineelementhtml  = 	metriclineelementhtml 	; }

}

