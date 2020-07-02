package ru.vsu.cs.course1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MatrixOperation
{
    public static void DeletEeuql (ArrayList<Integer> array){
        for (int i = 0; i<array.size()-1; i++)
            for (int j = i+1; j<array.size();j++)
                if (array.get(i)== array.get(j))
                    array.remove(j);
    }
    public static void Input(ArrayList<Integer> array,String input) throws IOException {
        String line = "";
        FileInputStream inputStream = new FileInputStream(input);
        DataInputStream in = new DataInputStream(inputStream);
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        line = bf.readLine();
        String[] numbers = line.split(" ");
        for (int i = 0; i < numbers.length; i++)
            array.add(Integer.parseInt(numbers[i]));
    }

    public static void Output (ArrayList<Integer> array){
        for (int i =0; i<array.size(); i++)
            System.out.print(array.get(i)+" ");
    }


}