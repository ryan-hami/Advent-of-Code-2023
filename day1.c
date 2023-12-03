#include <ctype.h>
#include <stdio.h>
#include <string.h>

int digitWordMap(char* word) {
    if (strcmp(word, "one") == 0) return 1;
    if (strcmp(word, "two") == 0) return 2;
    if (strcmp(word, "three") == 0) return 3;
    if (strcmp(word, "four") == 0) return 4;
    if (strcmp(word, "five") == 0) return 5;
    if (strcmp(word, "six") == 0) return 6;
    if (strcmp(word, "seven") == 0) return 7;
    if (strcmp(word, "eight") == 0) return 8;
    if (strcmp(word, "nine") == 0) return 9;
    return 0;
}

int extract(char str[]) {
    int i = 0, first = 0, last = 0;
    
    for (i = 0; i < strlen(str); ++i) {
        if (isdigit(str[i])) {
            first = str[i] - '0';
            break;
        }
    }

    for (i = strlen(str) - 1; i >= 0; --i) {
        if (isdigit(str[i])) {
            last = str[i] - '0';
            break;
        }
    }

    return first * 10 + last;
}

int main(int argc, char** argv) {
    /*int result = 0;

    for (--argc ; argc > 0; --argc) {
        result += extract(argv[argc]);
    }

    printf("%d", result);*/

    printf("%d", digitWordMap(argv[1]));
    return 0;
}