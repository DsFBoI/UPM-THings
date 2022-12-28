/*
 * maxmin.c
 * 
 * Copyright 2022 vagrant <vagrant@vagrant-VirtualBox>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

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
