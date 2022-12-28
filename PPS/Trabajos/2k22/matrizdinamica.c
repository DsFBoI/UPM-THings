#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
	
	
	long int** matriz;
	int i = argc,j;
	long int p,m;
	m = atoi(argv[1]);
	p = atoi(argv[2]);


	
	matriz = (long int **)malloc (m * sizeof(long int *));
	if (matriz == NULL){
			exit(71);
	}
	for(i = 0 ; i< m ; i++){
	matriz[i] =(long int *) malloc (p * sizeof(long int));
	if (matriz[i] == NULL){
			exit(71);
	}
	}
	
	
	

		
	for(i = 0;i<p;i++){
	matriz[0][i] = 1;
	
	}
	
	for(i = 0;i<m;i++){
	matriz[i][0] = 1;
	
	}
	
	
	for(i = 1;i<m;i++){
		for(j = 1;j<p;j++){
			matriz[i][j] = matriz[i][j-1]+matriz[i-1][j];
			
		}
	}
	
	for(i = 0; i<m; i++){
		
		for(j = 0; j<p;j++){
			if(j != p-1){
				
			printf("%li\t",matriz[i][j]);
			}
			else{
			printf("%li\n",matriz[i][j]);
			}
		}

	}
	
	
	return 0;
}
