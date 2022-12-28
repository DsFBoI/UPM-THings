#include <math.h>
#include <stdio.h>
#include <stdlib.h>

int resolver(double a, double b, double c, double* px1, double* px2){
	int caso ;


		
		if(a == 0 && b == 0){
			
			*px1 = 0;
			*px2 = 0;
			caso = 3;
			printf("Caso 3: %f, %f\n",*px1,*px2);
			
		}
		
		
		else if(a == 0){
			
			*px1 =  -c/b;
			*px2 = sqrt(-1);
			caso = 4;
			printf("Caso 4: %f, %f\n",*px1,*px2);
		}
		
		else if((pow(b,2) - 4*a*c) >= 0 ){
			*px1 =  (-b + sqrt( pow(b,2)  -4 * a * c )) /(2 *a);
			*px2 =  (-b - sqrt( pow(b,2) -4 * a * c )) /(2*a);
			caso = 1;
			printf("Caso 1: %f, %f\n",*px1,*px2);
			
			
		
		}else {
			*px1 = -b/(2*a);
			*px2 = fabs(sqrt(fabs( pow(b,2) - 4*a*c))/(2*a));
			
			caso = 2;
			
			printf("Caso 2: %f, %f\n",*px1,*px2);
		}
		

	return caso;
}
