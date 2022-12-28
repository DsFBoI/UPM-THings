#include <stdio.h>
#define DIM 1000

int main()
{
	/*inicializamos tanto un contador como una variable i 
	que sera la variable que cambie a lo largo del bucle
	luego una string que almacenara las palabra finales entre intervalos
	y por ultimo un almacen de los valores para luego devolverlos de manera inversa*/
	int i = 0;
	char j[80];
	int contador = 0;
	int almacen[DIM];
	
	while(scanf("%d",&almacen[i]) == 1 && contador<1000 ){
		/*cogemos el primer digito y comprobamos que sea un int*/
		i++;
		contador++;
		
		while(scanf("%d",&almacen[i]) == 1 && contador<1000){
			/*cogemos el siguiente digito si al igual que el primer 
			bucle pero este es el que almacena al comtario del 
			anterior que es para comprobar que despues ni habra 
			ninguna palbra o un espacio en blanco des pues de la serie de digitos*/
			i++;
			contador++;	
		}
		while(i>0){
			/*bucle que devuelve todos los digitos almacenados y restaura i = 0*/
			i--;
			if(i!=0){
			printf("%d ",almacen[i]);
			}
			else{
				printf("%d",almacen[0]);
			}
			
		}
		i = 0;
		printf("\n");
		/*lectura de la palabra */
		scanf("%s",j);
		
		
	}

	return 0;
}
