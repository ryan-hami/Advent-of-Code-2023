#include <ctype.h>
#include <stdio.h>
#include <string.h>

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
    int result = 0;

    for (--argc ; argc > 0; --argc) {
        result += extract(argv[argc]);
    }

    printf("%d", result);
    return 0;
}