#include <stdio.h>
#include <string.h>

#define MAXLINE 500

main(argc,argv)

int argc;
char *argv[];

{
	FILE *fp1, *fp2, *fopen() ;

	if (argc != 2) 
	{
	printf("need 1 file names\n");
	exit(1);
	} else 
       	{
		if ((fp1 = fopen(*++argv,"r")) == NULL )
		{
		printf (" Can t open %s\n",*argv);
		exit(1);

		} else 
	
		{
			if ((fp2 = fopen("GRTensorMetricsInput2.sql","a+")) ==NULL)
			{
			printf (" Can t open %s\n","GRTensorMetricsInput2.sql");
			exit(1);
			} else
			{
		  	convertfile (fp1,fp2) ; 
			fclose (fp1);
		  	fclose (fp2);    
			exit(0) ;
			}
		}
	}

}

convertfile(fp1,fp2) 

FILE  *fp1, *fp2 ;
{

char line1[MAXLINE*10]  ;

char  *lp1 ;
char  Temp [MAXLINE*10]="";

char  Temp2[MAXLINE]="";

char SQL1[500]="INSERT INTO metrics (metricid,metricdimension,metricname,x1_ ,x2_ ,x3_ ,x4_ ,g11_,g12_,g13_,g14_,g21_,g22_,g23_,g24_,g31_,g32_,g33_,g34_,g41_,g42_,g43_,g44_,metricinfo,metricconstraints,sig_,complex_,metricreference,kshm_reference,skea_reference,hawking_ellis_reference,b11_,b12_,b13_,b14_,b21_,b22_,b23_,b24_,b31_,b32_,b33_,b34_,b41_,b42_,b43_,b44_,bd11_,bd12_,bd13_,bd14_,bd21_,bd22_,bd23_,bd24_,bd31_,bd32_,bd33_,bd34_,bd41_,bd42_,bd43_,bd44_) VALUES  (";


int i ;
int MetricId=3 ;

lp1 = fgets(line1,MAXLINE*10,fp1);

while (lp1 != NULL)  

{
	strcpy(Temp,SQL1);
	MetricId++;
 	sprintf(Temp2,"%d",MetricId); 
 	strcat(Temp,Temp2);
 	strcat(Temp,lp1);
	
	fputs(Temp,fp2);
	puts(Temp);
	lp1 = fgets(line1,MAXLINE*10,fp1);
}
}
