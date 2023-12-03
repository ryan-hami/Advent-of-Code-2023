#include <ctype.h>
#include <stdio.h>
#include <string.h>

int main() {
    char result[3] = "  \0";
    char str[] = "l1t3r4l";
    int i = 0;

    for (i = 0; i < strlen(str); ++i) {
        if (isdigit(str[i])) {
            result[0] = str[i];
            break;
        }
    }

    for (i = strlen(str) - 1; i >= 0; --i) {
        if (isdigit(str[i])) {
            result[1] = str[i];
            break;
        }
    }

    printf("%s", result);
    return 0;
}