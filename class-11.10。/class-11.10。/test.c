#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main() {
	printf("����ɵ����1 ��ʾ��,0 ��ʾ����:");
	int choice = 0;
	//scanf ����   %d���ܼ�\n
	scanf("%d", &choice);
	if (choice == 1) {
		printf("��û���ˣ������ɣ�\n");

	} else{
		printf("��������ǡ�\n");
	}

	system("pause");
	return 0;
}