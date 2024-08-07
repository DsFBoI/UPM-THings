/*-
  * main.c
  * Minishell C source
  * Shows how to use "obtain_order" input interface function.
  *
  * Copyright (c) 1993-2002-2019, Francisco Rosales <frosal@fi.upm.es>
  * Todos los derechos reservados.
  *
  * Publicado bajo Licencia de Proyecto Educativo Práctico
  * <http://laurel.datsi.fi.upm.es/~ssoo/LICENCIA/LPEP>
  *
  * Queda prohibida la difusión total o parcial por cualquier
  * medio del material entregado al alumno para la realización
  * de este proyecto o de cualquier material derivado de este,
  * incluyendo la solución particular que desarrolle el alumno.
  *
  * DO NOT MODIFY ANYTHING OVER THIS LINE
  * THIS FILE IS TO BE MODIFIED
  */


#include <stddef.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>
#include <sys/times.h>
#include <pwd.h>
#include <glob.h>

extern int obtain_order(); /* See parser.y for description */

int main(void)
{
    char ***argvv = NULL;
    int argvc = 0;
    char **argv = NULL;

    char *filev[3] = {NULL, NULL, NULL};
    int bg;
    int ret;
    int pid;

    int NPH;
    int status;
    char dire[256];

    setbuf(stdout, NULL); /* Unbuffered */
    setbuf(stdin, NULL);
    signal(SIGINT, SIG_IGN);
    signal(SIGQUIT, SIG_IGN);
    while (1){
        fprintf(stderr, "%s", "msh> "); /* Prompt */
        ret = obtain_order(&argvv, filev, &bg);
        if (ret == 0)
             break; /* EOF */
        if (ret == -1)
             continue;    /* Syntax error */
         argvc = ret - 1; /* Line */
        if (argvc == 0)
             continue; /* Empty line */


        int fd[argvc][2];
        NPH = argvc;

        for (int i = 0; i < NPH; i++){
             pipe(fd[i]);
         }
        if(strcmp(argvv[0][0],"exit")==0){
                        exit(0);
        }else if(strcmp(argvv[0][0],"cd")==0){
            if(argvv[0][1] == NULL){
                chdir(getenv("HOME"));
                printf("%s\n",getenv("HOME"));
            }else{

                int dir = chdir(argvv[0][1]);
                getcwd(dire, sizeof(dire));

                if(dir == -1 || dire == NULL || argvv[0][2] != NULL){
                    fprintf(stderr,"ERROR\n");
                }
                if (filev[1] != NULL){
                    int op = open(filev[1], O_RDWR | O_CREAT | O_TRUNC, 0666);
                    if (op == -1){
                        fprintf(stderr, "Error. Fallo al abrir el fichero de reddireccion de salida\n");
                        exit(1);
                    }
                    int saved = dup(1);
                    dup2(op, 1);
                    close(op);
                    printf("%s\n",dire);
                    dup2(saved,1);
                    close(saved);
                }else{
                    printf("%s\n",dire);
                }




            }
            }else if(strcmp(argvv[0][0],"umask")==0){
                long mask;
                char *ptr;
                if(argvv[0][1] != NULL){
                    mask = strtol(argvv[0][1],&ptr,8);
                    if(argvv[0][2]1= ){
                        fprintf(stderr, "Error\n");
                    }else if(mask != 0){
                        mask = umask(mask);
                    }
                }else{
                    mask = umask(0);
                }

                if (filev[1] != NULL){
                    int op = open(filev[1], O_RDWR | O_CREAT | O_TRUNC, 0666);
                        if (op == -1){
                            fprintf(stderr, "Error. Fallo al abrir el fichero de reddireccion de salida\n");
                            exit(1);
                        }
                        int saved = dup(1);
                        dup2(op, 1);
                        close(op);
                        printf("%lo\n",mask);
                        dup2(saved,1);
                        close(saved);


                }else{
                    printf("%lo\n",mask);
                }
                }else{




                for (argvc = 0; (argv = argvv[argvc]); argvc++){
                    pid = fork();
                    switch (pid){
                    case -1:
                        fprintf(stderr, "ERROR");
                        exit(1);
                    case 0:
                        if(!bg){
                            signal(SIGINT, SIG_DFL);
                            signal(SIGQUIT, SIG_DFL);
                        }

                     if (argvc == 0 && NPH > 1){
                         close(fd[argvc][0]);
                         dup2(fd[argvc][1], 1);
                         close(fd[argvc][1]);
                    }

                    else if (argvc == NPH - 1 && NPH > 1){
                        dup2(fd[argvc - 1][0], 0);
                    }

                    else if (argvc!= NPH-1 && NPH > 1){
                         dup2(fd[argvc - 1][0], 0);
                         dup2(fd[argvc][1], 1);
                         close(fd[argvc][1]);
                         close(fd[argvc][0]);
                    }

                    for (int i = 0; i < NPH; i++){
                        if (i != argvc){
                            close(fd[i][0]);
                            close(fd[i][1]);
                        }
                    }

//-------------------------------------------------------------------------------------------------------
                     // Redireccion de entrada

                    if (filev[0] != NULL && argvc == 0){
                        int op = open(filev[0], O_RDONLY);
                        if (op == -1){
                            fprintf(stderr, "Error. Fallo al abrir el fichero de entrada\n");
                            exit(1);
                        }
                        dup2(op, 0);
                        close(op);
                    }
//-------------------------------------------------------------------------------------------------------
                     // Redireccion de Salida
                    if (filev[1] != NULL && argvc == NPH-1 ){
                        int op = open(filev[1], O_RDWR | O_CREAT |O_TRUNC, 0666);
                        if (op == -1){
                            fprintf(stderr, "Error. Fallo al abrir el fichero de reddireccion de salida\n");
                            exit(1);
                        }
                        dup2(op, 1);
                        close(op);
                    }
//-------------------------------------------------------------------------------------------------------
                     // Redireccion de error
                    if (filev[2] != NULL){
                        int op = open(filev[2], O_RDWR | O_CREAT |O_TRUNC, 0666);
                        if (op == -1){
                            fprintf(stderr, "Error. Fallo al abrir el fichero de redireccion de error\n");
                            exit(1);
                        }
                        dup2(op, 2);
                        close(op);
                    }


//-------------------------------------------------------------------------------------------------------
                     // ejecucion del mandato

                    execvp(argv[0], argv);
                    exit(0);

                    break;

                default:

                    break;
                }
        }

        for (int i = 0; i < NPH; i++){
            close(fd[i][0]);
            close(fd[i][1]);
        }

        if (!bg){
            while(wait(&status)!=pid);
        }
        else{
            printf("[%d]\n", pid);
        }
    }
    }
    exit(0);
}

