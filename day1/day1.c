#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

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

int evaluate(int i, char* str) {
    int j, val;

    if (isdigit(str[i])) {
        return str[i] - '0';
    }

    for (j = i - 2, val = 0; val == 0 && j >= 0 && j > i - 5; --j) {
        char* substr = calloc(1, &str[i + 1] - &str[j] + 1);
        memcpy(substr, &str[j], &str[i + 1] - &str[j]);
        val = digitWordMap(substr);
        free(substr);
    }

    return val;
}

int getFirst(char* str) {
    int i, val;

    for (i = 0, val = 0; val == 0 && i < strlen(str); ++i) {
        val = evaluate(i, str);
    }

    return val;
}

int getLast(char* str) {
    int i, val;

    for (i = strlen(str) - 1, val = 0; val == 0 && i >= 0; --i) {
        val = evaluate(i, str);
    }

    return val;
}

int extract(char* str) {
    return getFirst(str) * 10 + getLast(str);
}

int main(int argc, char** argv) {
    int result;

    for (--argc, result = 0; argc > 0; --argc) {
        result += extract(argv[argc]);
    }

    printf("%d", result);
    return 0;
/* nice */ }