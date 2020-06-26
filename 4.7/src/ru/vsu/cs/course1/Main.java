package ru.vsu.cs.course1;

import java.util.Arrays;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class BarChart_AWT extends ApplicationFrame {
    static int co = 0;
    static int ch = 0;
    static int count = 0;
    static int coB = 0;
    static int chB=0;

    public BarChart_AWT( String applicationTitle , String chartTitle ) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Сортировка",
                "Количество проверок",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }
    public static int binarySearch(int []a, int item, int low, int high)
    { if (high <= low)
        return (item > a[low])? (low + 1): low;
        int mid = (low + high)/2;
        if(item == a[mid])
            return mid+1;
        if(item > a[mid])
            return binarySearch(a, item, mid+1, high);
        return binarySearch(a, item, low, mid-1);
    }

    public static void insertionSort(int[] a, int n)
    {
        int i, loc, j, selected;
        for (i = 1; i < n; i++)
        {
            j = i - 1;
            selected = a[i];
            loc = binarySearch(a, selected, 0, j);
// System.out.println(j+" "+loc);
            while (j >= loc)
            { a[j+1] = a[j];
                j--;
                coB++;

            }

            chB++;
            a[j+1] = selected;

        }
        System.out.println(Arrays.toString(a));
        System.out.println("Сравнений: " + coB + " ; Замен: " + chB);
    }

    public static void sort(int[] array)
    {
        int i, j, newValue;
        for (i = 1; i < array.length; i++)
        {
            newValue = array[i];
            j = i;
            while (j > 0 && array[j - 1] > newValue)
            {
                co++;
                array[j] = array[j - 1];
                j--;
            }
            ch++;
            array[j] = newValue;
        }

        System.out.println(Arrays.toString(array));
        System.out.println("Сравнений: " + co + " ; Замен: " + ch);
    }

    private CategoryDataset createDataset( ) {

        final String s = "Проверки";

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        dataset.addValue( co , "Сортировка вставками" , s );


        dataset.addValue( coB , "Бинарные вставки" , s );





        return dataset;
    }

    public static void main( String[ ] args ) {
        int []arr = new int[] {56, 12, 0,90,74, 62,11,70,56, 9, 5, 8, 6, 1, 3, 7, 4, 2, 1, 1, 2, 6, 3, 8, 5, 78, 55, 23, 89 };
        sort(arr);
        insertionSort(arr,arr.length);

        BarChart_AWT chart = new BarChart_AWT("Количество проверок в сортировках",
                "Сортировка вставками и бинарными вставками");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
