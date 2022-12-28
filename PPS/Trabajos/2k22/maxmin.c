#include <stdio.h>

int main(int argc, char **argv)
{
	FILE *g;
	g = fopen(argv[1],"r");
	
	if(argc !=2){
		return (-1);
	}
	
	
		if(g !=NULL){
			
			float min,max,aux;
			
			if(fscanf(g, "%f",&max) == 0){
				max = 0;
				min = 0;
			printf("%10.2f%10.2f\n",max, min);
			return 0;
			}
			min = max;
			 
			while(fscanf(g, "%f",&aux)==1){
				if(max > aux && min > aux){
					min = aux;
				}
				if(aux>max){
					max = aux;
				}
				
			}
			printf("%10.2f%10.2f\n",max, min);
		
		}
		else{
			return (-1);
		}
			
	
	
	return 0;
}
