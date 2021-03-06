package com.lxzh123.funcdemo.algo.sortalgo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lxzh123.funcdemo.R;

import org.apache.log4j.helpers.OptionConverter;

import java.util.Arrays;
import java.util.Random;

public class SortActivity extends Activity {

    private Button btnGen;
    private Button btnSort;
    private EditText etArrCnt;
    private TextView tvOrigArray;
    private TextView tvRstSort;
    private int[] array;
    private int arrcnt = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_sortalgo);
        btnGen = (Button) findViewById(R.id.btnGenRandData);
        btnSort = (Button) findViewById(R.id.btnSort);
        etArrCnt = (EditText) findViewById(R.id.etArrCnt);
        tvOrigArray = (TextView) findViewById(R.id.tvOrigArray);
        tvRstSort = (TextView) findViewById(R.id.tvRst_Sort);

        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = etArrCnt.getText().toString();
                arrcnt = OptionConverter.toInt(str, 20);
                array = genRandData(arrcnt);
                tvOrigArray.setText(Arrays.toString(array));
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] tmpArray = Arrays.copyOf(array, arrcnt);
                StringBuffer buf = new StringBuffer();
                long tStart, tEnd;
                int[] tmp;

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.BubbleSortForward(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("前向冒泡排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.BubbleSortForward(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n前向冒泡排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.BubbleSortForward(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n后向冒泡排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.BubbleSortForward(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n后向冒泡排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.InsertSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n插入排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.InsertSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n插入排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.SelectSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n选择排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.SelectSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n选择排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.ShellSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n希尔排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.ShellSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n希尔排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.HeapSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n堆排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.HeapSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n堆排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.MergeSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n归并排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.MergeSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n归并排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.QuickSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n快速排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.QuickSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n快速排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));


                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.QuickSort1(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n快速排序1用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.QuickSort1(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n快速排序1用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.ThreadSort(tmp, true);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n\n线程排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tmp = tmpArray.clone();
                tStart = SystemClock.elapsedRealtime();
                Sorter.ThreadSort(tmp, false);
                tEnd = SystemClock.elapsedRealtime();
                buf.append("\n线程排序用时:" + (tEnd - tStart) + ",结果:\n" + Arrays.toString(Arrays.copyOf(tmp, 10)));

                tvRstSort.setText(buf.toString());
            }
        });
    }

    private int[] genRandData(int len) {
        int[] arr = new int[len];
        Random rand = new Random();
        int max = len * 5;
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }
}
