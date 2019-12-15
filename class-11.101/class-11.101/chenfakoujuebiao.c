#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<Windows.h>

int main() {
	int i = 0;
	int j = 0;
	for (i = 1; i < 9; i++) {
		for (j = 1; j <= i; j++) {
			printf("%d*%d=%d ", j, i, i*j);8
		}
		printf("\n");
	}
	system("pause");
	return 0;
}