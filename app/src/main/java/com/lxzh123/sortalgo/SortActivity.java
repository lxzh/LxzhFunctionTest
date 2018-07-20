package com.lxzh123.sortalgo;

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
    private TextView tvRstBubbleSort;
    private int[] array;
    private int arrcnt=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sortalgo);
        btnGen=(Button)findViewById(R.id.btnGenRandData);
        btnSort=(Button)findViewById(R.id.btnSort);
        etArrCnt=(EditText)findViewById(R.id.etArrCnt);
        tvOrigArray=(TextView)findViewById(R.id.tvOrigArray);
        tvRstBubbleSort=(TextView)findViewById(R.id.tvRst_BubbleSort);


        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=etArrCnt.getText().toString();
                arrcnt=OptionConverter.toInt(str,20);
                array=genRandData(arrcnt);
                tvOrigArray.setText(Arrays.toString(array));
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] tmpArray=Arrays.copyOf(array,arrcnt);
                long tStart=SystemClock.elapsedRealtime();
                Sorter.BubbleSort(tmpArray,true);
                long tEnd=SystemClock.elapsedRealtime();
                tvRstBubbleSort.setText("冒泡排序用时:"+(tEnd-tStart)+",结果:\n"+Arrays.toString(tmpArray));
            }
        });
    }

    private int[] genRandData(int len){
        int[] arr=new int[len];
        Random rand=new Random();
        int max=len*5;
        for(int i=0;i<len;i++){
            arr[i]=rand.nextInt(max);
        }
        return arr;
    }
}
