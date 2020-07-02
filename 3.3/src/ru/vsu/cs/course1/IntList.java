package ru.vsu.cs.course1;

import java.util.ArrayList;
import java.util.List;

public class IntList {
    private List<Integer> list;

    IntList() {
        this.list = new ArrayList<>();
    }

    IntList(int... ints) {
        this();
        addAll(ints);
    }

    public void add(int number) {
        this.list.add(number);
    }

    public void addAll(int... ints) {
        if (ints != null) {
            for (int number : ints) {
                add(number);
            }
        }
    }

    public void makePareNumberSum() {
        List<Integer> resultList = new ArrayList<>();
        for (int index = 1; index < this.list.size(); index += 2) {
            resultList.add(get(index - 1) + get(index));
        }
        if (this.list.size() % 2 != 0) {
            resultList.add(get(length() - 1));
        }
        this.list = resultList;
    }

    public int get(int index) {
        return this.list.get(index);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    public int[] toArray() {
        int[] array = new int[0];
        if (!this.list.isEmpty()) {
            array = new int[this.list.size()];
            int count = 0;
            for (int number : list) {
                array[count++] = number;
            }
        }
        return array;
    }

    public int length() {
        return this.list.size();
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}

