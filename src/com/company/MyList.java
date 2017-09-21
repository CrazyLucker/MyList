package com.company;


import java.util.Arrays;

public class MyList {
    private int[] list;

    public MyList() {
        list = new int[3];
    }

    public MyList(int capacity) {
        list = new int[capacity];
    }

    public MyList(int[] array){
        list = new int[array.length];
        System.arraycopy(array, 0, list, 0, array.length);
    }

    int size() {
        return list.length;
    }

    int searchByIndex(int index) {
        return list[index];
    }

    int searchByValue(int value) {
        int i = -1;
        if (this.list != null) {
            int low = 0, high = this.list.length, mid;
            while (low < high) {
                mid = (low + high)/2;
                if (value == this.list[mid]) {
                    i = mid;
                    break;
                } else {
                    if (value < this.list[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return i;
    }

    void add(int number) {
        int[] temp = list;
        list = new int[temp.length + 1];
        System.arraycopy(temp, 0, list, 0, temp.length);
        list[list.length - 1] = number;
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = list[i] + number;
        }
    }

    void delete(int number) {
        if (searchByValue(number) != -1) {
            int[] temp = new int[list.length - 1];
            System.arraycopy(list, 0, temp, 0, temp.length);
            list = temp;
            for (int i = 0; i < list.length; i++) {
                list[i] = list[i] - number;
            }
        } else System.out.println("No such value");

    }

    int getMin() {
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (min > list[i]) {
                min = list[i];
            }
        }
        return min;
    }

    int getMax() {
        int max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (max < list[i]) {
                max = list[i];
            }
        }
        return max;
    }

    double average() {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum = list[i] + sum;
        }
        return sum / list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}


