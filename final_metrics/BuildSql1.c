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
			if ((fp2 = fopen("GRTensorMetricsInput1.sql","a+")) ==NULL)
			{
			printf (" Can t open %s\n","GRTensorMetricsInput1.sql");
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

char SQL1[300]="INSERT INTO metrics (metricid,metricdimension,metricname,x1_ ,x2_ ,x3_ ,x4_ ,g11_,g12_,g13_,g14_,g21_,g22_,g23_,g24_,g31_,g32_,g33_,g34_,g41_,g42_,g43_,g44_,metricinfo,metricconstraints,metricinputtype ) VALUES  (";


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
