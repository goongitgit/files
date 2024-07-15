// Copyright 2023 Zohaib Javed
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void checkargs(int argc, char ** argv);
void readfile(int code, int startindex, int argc, char ** argv);
int fileexists(const char * filename);

int main(int argc, char ** argv) {
  checkargs(argc, argv);
}

void checkargs(int argc, char ** argv) {
  int passtoreadfile[2];
  // [0] - option chosen
  // [1] - index at which to start reading args as filenames
  int i;
  for (i = 1; i < argc; i++) {
    if (strcmp(argv[i], "-l") != 0 &&
      strcmp(argv[i], "-w") != 0 &&
      strcmp(argv[i], "-c") != 0) {
      break;
    }
  }
  if (i == 1 && argc > 1) {
    passtoreadfile[0] = 3;
    passtoreadfile[1] = 1;
  } else if (i == 1 && argc == 1) {
    fprintf(stderr, "Usage: ./wordcount requires an input file.\n");
    exit(1);
  } else if (i == argc) {
    fprintf(stderr, "Usage: ./wordcount requires an input file.\n");
    exit(1);
  } else {
    passtoreadfile[1] = i;
    if (strcmp(argv[1], "-l") == 0) {
      passtoreadfile[0] = 0;
    } else if (strcmp(argv[1], "-w") == 0) {
      passtoreadfile[0] = 1;
    } else if (strcmp(argv[1], "-c") == 0) {
      passtoreadfile[0] = 2;
    }
  }
  if (!((i == 1 && argc == 1) || (i == argc))) {
    readfile(passtoreadfile[0], passtoreadfile[1], argc, argv);
  }
}

void readfile(int code, int startindex, int argc, char ** argv) {
  int lines = 0;
  int totlines = 0;
  int words = 0;
  int chars = 0;
  for (int i = startindex; i < argc; i++) {
    if (fileexists(argv[i]) == 1) {
      FILE * fp;
      char str[500];

      fp = fopen(argv[i], "r");
      if (fp == NULL) {
        fprintf(stderr, "There was an error opening the file.\n");
        exit(EXIT_FAILURE);
      }
      while (!feof(fp)) {
        if (fgets(str, 500, fp) != NULL) {
          lines++;
          totlines++;
          chars = chars + strlen(str);
          for (int k = 0; k < strlen(str); k++) {
            if (str[k] != ' ' && str[k + 1] == ' ') {
              words++;
            } else if (str[k] != ' ' && str[k + 1] == '\n') {
              words++;
            }
          }
        }
      }
      fclose(fp);
      if (code == 0) {
        printf("%d \n", lines);
      } else if (code == 1) {
        printf("%d \n", words);
      } else if (code == 2) {
        printf("%d \n", chars);
      } else if (code == 3) {
        printf(" %d %d %d %s\n", lines, words, chars, argv[i]);
      }
    } else {
      fprintf(stderr, "%s will not open.  Skipping.\n", argv[i]);
    }
    lines = 0;
    words = 0;
    chars = 0;
  }
  if (code == 3) {
    printf("Total Lines = %d\n", totlines);
  }
}

int fileexists(const char * filename) {
  FILE * file;
  if ((file = fopen(filename, "r"))) {
    fclose(file);
    return 1;
  }
  return 0;
}
