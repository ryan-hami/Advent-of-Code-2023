#include <ctype.h>
#include <stdio.h>
#include <string.h>

int extract(char str[]) {
    int i = 0, first, last;
    
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

int main() {
    char line1[] = "1abc2";
    char line2[] = "pqr3stu8vwx";
    char line3[] = "a1b2c3d4e5f";
    char line4[] = "treb7uchet";
    int result = extract(line1) + extract(line2) + extract(line3) + extract(line4);

    printf("answer %d", result);

    return 0;
}