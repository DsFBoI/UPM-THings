#include <stdio.h>
#include <stdlib.h>

#define DIM 80

int main(int argc, char *argv[])
{
        printf("%d",argc);
                if(argc != 2 || argv[1] == NULL ){
                        return 1;
                }
                char caracter;
                int n = atoi(argv[1]);
                int j = 0;



                while(( caracter = getchar()) != EOF  ) {

                        if(j == DIM){
                                j=0;
                                printf("\n");

                        }

                        if (caracter == 32){
                                for(int i = 0; i < n ; i++){

                                        if(j == DIM){
                                                j=0;
                                                printf("\n");

                                        }
                                        printf(" ");
                                        j++;
                                }
                        }
                        printf("%c",caracter);
                        j++;
                }


        return 0;
}
