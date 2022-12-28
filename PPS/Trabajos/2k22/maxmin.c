
#include <stdio.h>


int main(int argc, char *argv[] ){
    if(argc != 2){
        return -1;
    }
    FILE *g;
    g = fopen(argv[1],"r");
    if(g = NULL){
        return -1;
    }
    float max, min,num;
    max= 0;
    min = 0;
    num = 0;

    if(fscanf( "%f",&num)==1){

        max = num;
        min = num;
    }
    printf("%10.2f",num);

    while(fscanf( "%f",&num)==1){
        if(num > max){
            max = num;
        }
        if(num <min){
            min = num;
        }
    }
    printf("%10.2f %10.2f",&max,&min);
    return 0;
}
