#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main() {
	printf("你是傻逼吗？1 表示是,0 表示不是:");
	int choice = 0;
	//scanf 输入   %d后不能加\n
	scanf("%d", &choice);
	if (choice == 1) {
		printf("你没救了，等死吧！\n");

	} else{
		printf("不，你就是。\n");
	}

	system("pause");
	return 0;
}