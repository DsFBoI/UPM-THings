#include <stdio.h>
#include <stdlib.h>
#include "parser.h"
#include <string.h>


int parser(FILE* arch){
        char** nombre;
        char** atributos;
        int i, j = 0,z,length=0;
        char *palabra;

        char car;
        palabra = (char* )malloc(sizeof(char) * MaxLinea);
        if(palabra == NULL){
                fprintf(stderr,"ERROR");
                return -1;
        }

        atributos = (char**) malloc(sizeof(char*) * MaxCampos*MaxLinea);
        if(atributos == NULL){
                fprintf(stderr,"ERROR");
                return -1;
        }
        for(i = 0;i<MaxCampos;i++){

                atributos[i] =(char* )malloc(sizeof(char) * MaxLinea);
                if(atributos[i] == NULL){
                        fprintf(stderr,"ERROR");
                        return -1;
                }
        }

        nombre = (char**) malloc(sizeof(char*) * MaxCampos *MaxLinea);
        if(nombre == NULL){
                fprintf(stderr,"ERROR");
                return -1;
        }
        for(i = 0;i<MaxCampos;i++){
                nombre[i] =(char* )malloc(sizeof(char) * MaxLinea);
                if(nombre[i] == NULL){
                        fprintf(stderr,"ERROR");
                        return -1;
                }
        }

                i=0;

                while(fscanf(arch,"%c",&car)==1) {

                        if (car == ',' ){

                                atributos[j] = palabra;
                                palabra = (char* )malloc(sizeof(char) * MaxLinea);

                                if(palabra == NULL){

                                        fprintf(stderr,"ERROR");
                                        return -1;
                                }

                                length= length + i + 1;
                                i = 0;
                                j++;

                        }
                        else if(car =='\n'){

                                atributos[j] = palabra;
                                j++;
                                length= length + i + 1;
                                palabra = (char* )malloc(sizeof(char) * MaxLinea);

                                if(palabra == NULL){
                                        fprintf(stderr,"ERROR");
                                        return -1;
                                }

                                break;
                        }
                        else{
                                palabra[i] = car;
                                i++;
                        }


                }






        if(j+1>MaxCampos){
                fprintf(stderr,"ERROR");
                return -1;
        }
        if(length > MaxLinea){
                fprintf(stderr,"ERROR");
                return -1;
        }
        z = j;
        j = 0;
        i=0;
        length = 0;

        while(fscanf(arch,"%c",&car) ==1){

                        if(car == ','){

                                nombre[j] = palabra;
                                palabra = (char* )malloc(sizeof(char) * MaxLinea);

                                if(palabra == NULL){

                                        fprintf(stderr,"ERROR");
                                        return -1;

                                }

                                length = i + 1 + length;
                                i=0;
                                j++;


                        }else if(car == '\n'){

                                nombre[j] = palabra;
                                palabra = (char* )malloc(sizeof(char) * MaxLinea);

                                if(palabra == NULL){
                                        fprintf(stderr,"ERROR");
                                        return -1;

                                }
                                if(length>2048){
                                        fprintf(stderr,"ERROR");
                                        return -1;

                                }
                                for(i = 0; i<z-1; i++){
                                        printf("%s: %s; ",atributos[i],nombre[i]);

                                        if(i+1==z-1){
                                                printf("%s: %s\n",atributos[i+1],nombre[i+1]);

                                        }

                                }
                                j=0;
                                i= 0;
                                length =0;
                                palabra = (char* )malloc(sizeof(char) * MaxLinea);

                                if(palabra == NULL){
                                        fprintf(stderr,"ERROR");
                                        return -1;

                                }
                        }else{
                                palabra[i] = car;
                                i++;

                        }




        }
        free(palabra);
        free(nombre);
        free(atributos);



        return 0;
}
