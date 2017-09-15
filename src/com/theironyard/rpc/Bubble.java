package com.theironyard.rpc;

public class Bubble {
    int[] bubbleArrInt = new int[]{1,2,3};
    int n = bubbleArrInt.length;

    public void bubbleSortInt () {
        for (int i = 0; i < n-1; i++ ) {
            for (int j = 0; j < n-i-1; i++) {
                if (bubbleArrInt[j] > bubbleArrInt[j-1]) {
                    int temp = bubbleArrInt[j];
                    bubbleArrInt[j] = bubbleArrInt[j-1];
                    bubbleArrInt[j-1] = temp;
                }
            }
        }
    }

    String[] bubbleArrString = new String[]{"Hailee", "Joe", "Larry"};
    int m = bubbleArrString.length;

    public void bubbleString () {
        for (int i = 0; i < m-1; i++ ) {
            for (int j = 0; j < m-i-1; i++) {
                if (bubbleArrString[j].compareTo(bubbleArrString[j + 1]) > 0) {
                    String temp = bubbleArrString[j];
                    bubbleArrString[j] = bubbleArrString[j-1];
                    bubbleArrString[j-1] = temp;
                }
            }
        }
    }
}
