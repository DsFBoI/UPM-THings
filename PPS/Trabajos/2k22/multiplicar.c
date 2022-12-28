#include <stdio.h>
#include <stdlib.h>
#define DIM 64

int main()
{
	int m,n,p;
	int matrizres[DIM][DIM];
	int matriz1[DIM][DIM];	
	int matriz2[DIM][DIM];
	/*inicializamos las vaiables de los bucles*/
	int i,j,z;
	/*obtenemos los valores de m,n,p*/
	scanf("%d %d %d",&m,&n,&p);


	
	for(i = 0; i<m; i++){
		/*almacenamos los valores de la matriz mxn*/
		for(j = 0; j<n;j++){
			scanf("%d",&matriz1[i][j]);
		}
	}
	
	for(i = 0; i<n; i++){
		/*almacenamos los valores de la matriz nxp*/
		for(j = 0; j<p;j++){
			
			scanf("%d",&matriz2[i][j]);
		}
	}
	
	for(i = 0; i<p; i++){
		for(j = 0; j<m; j++){
			int suma = 0;
			for(z = 0; z<n ; z++){
				/*almacenamos en suma las operaciones para el primer digito*/
				suma += matriz1[j][z] * matriz2[z][i];
 			
			}
			/*almacenamos en la casilla correspondiente de la matriz el valor anterior*/
			matrizres[j][i] = suma;
			
		}
		
	}
	

	/*imprimimos la matriz resultante*/
	for(i = 0; i<m; i++){
		
		for(j = 0; j<p;j++){
			if(j != p-1){
				
			printf("%d ",matrizres[i][j]);
			}
			else{
			printf("%d",matrizres[i][j]);
			}
		}
		printf("\n");
	}
	
	
	
	return 0;
}
