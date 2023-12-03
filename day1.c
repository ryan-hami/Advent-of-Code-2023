#include <ctype.h>
#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "l1t3r4l";
    int i = 0;

    /* i am ignoring this working because i am convinced it is meaningless */
    /* warning: ISO C90 does not support the '%llu' ms_printf format */
    printf("the len is %llu", strlen(str));

    /* int i = 0; INSANE WHY CAN'T I DECLARE A VARIABLE HERE */
    for (/* WHY CAN'T I DELCARE A VARIABLE HERE */ i = 0; i < strlen(str); ++i) {
        printf("%d", i);
    }
    return 0;
}