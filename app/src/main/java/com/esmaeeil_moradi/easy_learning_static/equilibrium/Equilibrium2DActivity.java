package com.esmaeeil_moradi.easy_learning_static.equilibrium;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.esmaeeil_moradi.easy_learning_static.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class Equilibrium2DActivity extends AppCompatActivity {

    LineChart MP_LINE_CHART;
    EditText SIZE_VECTOR;
    EditText ANGLE_VECTOR;
    Button BTN_DRAW;
    Button BTN_TOTAL;
    Button BTN_CLEAR;
    TextView txtTotalX;
    TextView txtTotalY;
    final ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    final ArrayList<ILineDataSet> total = new ArrayList<>();
    final ArrayList<Float> totalX = new ArrayList<>();
    final ArrayList<Float> totalY = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equi_ilibrium2_d);


        //add tollBar
        tollBar();

        //find View
        SIZE_VECTOR = findViewById(R.id.edt_size_vector);
        ANGLE_VECTOR = findViewById(R.id.edt_angle_vector);
        BTN_DRAW = findViewById(R.id.btnDraw);
        BTN_TOTAL = findViewById(R.id.btnTotal);
        BTN_CLEAR = findViewById(R.id.btnClear);
        MP_LINE_CHART = findViewById(R.id.chart1);
        txtTotalX = findViewById(R.id.txtTotalX);
        txtTotalY = findViewById(R.id.txtTotalY);

        //Clean Text in EditText SIZE_VECTOR
        SIZE_VECTOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SIZE_VECTOR.getText().clear(); //or you can use editText.setText("");

            }
        });


        //Clean Text in EditText ANGLE_VECTOR
        ANGLE_VECTOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ANGLE_VECTOR.getText().clear();
            }
        });


//        btnDraw.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        float LENGTH = Float.parseFloat(SIZE_VECTOR.getText().toString());
//                        double ANGLE = Double.parseDouble(ANGLE_VECTOR.getText().toString());
//
//
//                        Log.e("Essi", "length: " + String.valueOf(LENGTH));
//                        Log.e("Essi", "angle Degree: " + String.valueOf(ANGLE));
//                        Double Radians_ANGLE = Math.toRadians(ANGLE);
//                        Log.e("Essi", "angle Radians: " + String.valueOf(Radians_ANGLE));
//                        double sinAngle = Math.sin(Radians_ANGLE);
//                        double cosAngle = Math.cos(Radians_ANGLE);
//
//                        Log.e("Essi", "Sin angle: " + String.valueOf(sinAngle));
//                        Log.e("Essi", "Cos angle: " + String.valueOf(cosAngle));
//
//                        float x = (float) (LENGTH * (cosAngle));
//                        float y = (float) (LENGTH * (sinAngle));
//                        Log.e("Essi", "X : " + String.valueOf(x));
//                        Log.e("Essi", "Y : " + String.valueOf(y));
//
//
//
//                        LineDataSet lineDataSet1 = new LineDataSet(dataValues(
//                                //Float.parseFloat((SIZE_VECTOR.getText().toString())),
//                                //Float.parseFloat(ANGLE_VECTOR.getText().toString())
//                                x, y), "DataSet1");
//                        Log.e("Essi", "X: " + String.valueOf(x) + "***");
//                        Log.e("Essi", "Y: " + String.valueOf(y) + "***");
//                        dataSets.add(lineDataSet1);
//                        LineData data = new LineData(dataSets);
//                        MP_LINE_CHART.setData(data);
//                        MP_LINE_CHART.setDrawGridBackground(true);
//                        MP_LINE_CHART.setDrawBorders(true);
//                        MP_LINE_CHART.setBorderColor(Color.RED);
//                        lineDataSet1.setLineWidth(4);
//                        lineDataSet1.setColor(Color.RED);
//                        lineDataSet1.setDrawCircles(true);
//                        //lineDataSet1.setCircleHoleRadius(45);
//                        // lineDataSet1.setCircleRadius(45);
//                        lineDataSet1.setDrawHorizontalHighlightIndicator(true);
//                        lineDataSet1.getIconsOffset();
//
//                        MP_LINE_CHART.invalidate();
//
//
//
//
//                    }
//                });


//        BTN_DRAW.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LineDataSet lineDataSet1 = new LineDataSet(dataValues(
//                        //Float.parseFloat((SIZE_VECTOR.getText().toString())),
//                        //Float.parseFloat(ANGLE_VECTOR.getText().toString())
//                        x, y), "DataSet1");
//                dataSets.add(lineDataSet1);
//                LineData data = new LineData(dataSets);
//                MP_LINE_CHART.setData(data);
//                MP_LINE_CHART.setDrawGridBackground(true);
//                MP_LINE_CHART.setDrawBorders(true);
//                MP_LINE_CHART.setBorderColor(Color.RED);
//                lineDataSet1.setLineWidth(4);
//                lineDataSet1.setColor(Color.RED);
//                lineDataSet1.setDrawCircles(true);
//                //lineDataSet1.setCircleHoleRadius(45);
//                // lineDataSet1.setCircleRadius(45);
//                lineDataSet1.setDrawHorizontalHighlightIndicator(true);
//                lineDataSet1.getIconsOffset();
//
//
//                MP_LINE_CHART.invalidate();
//            }
//        });




        /*Draw Center Point for Particle*/
        createCenterPoint();


        BTN_DRAW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                createVector();
                //Log.e("Essi ", "BTN_DRAW --> e = " +);
                //Log.e("Essi ", "BTN_DRAW --> d = " + d);


            }
        });


        BTN_TOTAL.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                total.addAll(dataSets);
                Log.e("Essi", "TOTAL  X --->" + totalX);
                Log.e("Essi", "TOTAL  Y--->" + totalY);
                Log.e("Essi", "TOTAL SIZE X --->" + totalX.size());
                Log.e("Essi", "TOTAL SIZE Y --->" + totalY.size());


                float sumX = 0;
                float sumY = 0;
                for (int i = 0; i < totalX.size(); i++)
                    sumX += totalX.get(i);
                Log.e("Essi", "TOTAL Final SUM  X--->" + sumX);

                for (int j = 0; j < totalY.size(); j++)
                    sumY += totalY.get(j);
                Log.e("Essi", "TOTAL Final SUM  Y--->" + sumY);

                txtTotalX.setText((int) sumX + "");
                txtTotalY.setText((int) sumY + "");



                LineDataSet lineDataSetTotal = new LineDataSet(dataValues(
                        sumX, sumY), "Total");
                dataSets.add(lineDataSetTotal);
                LineData data = new LineData(dataSets);
                MP_LINE_CHART.setData(data);
                MP_LINE_CHART.setDrawGridBackground(true);
                MP_LINE_CHART.setDrawBorders(true);
                MP_LINE_CHART.setBorderColor(Color.GREEN);
                lineDataSetTotal.setLineWidth(4);
                lineDataSetTotal.setColor(Color.GREEN);
                lineDataSetTotal.setDrawCircles(false);
                lineDataSetTotal.setDrawHorizontalHighlightIndicator(true);
                lineDataSetTotal.getIconsOffset();

                MP_LINE_CHART.invalidate();


            }


        });
        BTN_CLEAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSets.clear();
                total.clear();
                totalX.clear();
                totalY.clear();
                MP_LINE_CHART.clear();
                createCenterPoint();

                MP_LINE_CHART.invalidate();


            }
        });

    }


    public ArrayList<Entry> dataValues(float x, float y) {
        ArrayList<Entry> dataValuesEntry = new ArrayList<>();
        dataValuesEntry.add(new Entry(0, 0));
        dataValuesEntry.add(new Entry(x, y));


        return dataValuesEntry;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void createCenterPoint() {
        final ArrayList<ILineDataSet> dataSetsParticle = new ArrayList<>();
        LineDataSet circlePoint = new LineDataSet(dataValues(0, 0), "Particle");
        dataSetsParticle.add(circlePoint);
        LineData dataParticle = new LineData(dataSetsParticle);
        MP_LINE_CHART.setData(dataParticle);
        circlePoint.setCircleRadius(20);
    }


    private void tollBar() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    private void createVector() {

        Vector vector = new Vector(SIZE_VECTOR.getText().toString(), ANGLE_VECTOR.getText().toString());
        Log.e("Essi ", "SIZE_VECTOR" + SIZE_VECTOR.getText().toString());
        Log.e("Essi ", "ANGLE_VECTOR" + ANGLE_VECTOR.getText().toString());
        Log.e("Essi ", "CreateVectorX" + vector.CreateVectorX());
        Log.e("Essi ", "vector.CreateVectorY" + vector.CreateVectorY());
        Log.e("Essi ", "dataSets.size   -->" + dataSets.size());
        Log.e("Essi ", "dataSets.size   -->" + dataSets);
        Log.e("Essi ", "dataSets.size   -->");
        totalX.add(vector.CreateVectorX());
        totalY.add(vector.CreateVectorY());


        LineDataSet lineDataSet1 = new LineDataSet(dataValues(
                vector.CreateVectorX(), vector.CreateVectorY()), "DataSet1");
        dataSets.add(lineDataSet1);
        LineData data = new LineData(dataSets);
        MP_LINE_CHART.setData(data);
        MP_LINE_CHART.setDrawGridBackground(true);
        MP_LINE_CHART.setDrawBorders(true);
        MP_LINE_CHART.setBorderColor(Color.RED);
        lineDataSet1.setLineWidth(4);
        lineDataSet1.setColor(Color.RED);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setDrawHorizontalHighlightIndicator(true);
        lineDataSet1.getIconsOffset();

        MP_LINE_CHART.invalidate();


    }


}
/*
    private void drawListener() {

        BTN_DRAW.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float LENGTH = Float.parseFloat(SIZE_VECTOR.getText().toString());
                        double ANGLE = Double.parseDouble(ANGLE_VECTOR.getText().toString());


                        Log.e("Essi", "length: " + String.valueOf(LENGTH));
                        Log.e("Essi", "angle Degree: " + String.valueOf(ANGLE));
                        Double Radians_ANGLE = Math.toRadians(ANGLE);
                        Log.e("Essi", "angle Radians: " + String.valueOf(Radians_ANGLE));
                        double sinAngle = Math.sin(Radians_ANGLE);
                        double cosAngle = Math.cos(Radians_ANGLE);

                        Log.e("Essi", "Sin angle: " + String.valueOf(sinAngle));
                        Log.e("Essi", "Cos angle: " + String.valueOf(cosAngle));

                        float x = (float) (LENGTH * (cosAngle));
                        float y = (float) (LENGTH * (sinAngle));
                        Log.e("Essi", "X : " + String.valueOf(x));
                        Log.e("Essi", "Y : " + String.valueOf(y));


                        LineDataSet lineDataSet1 = new LineDataSet(dataValues(
                                //Float.parseFloat((SIZE_VECTOR.getText().toString())),
                                //Float.parseFloat(ANGLE_VECTOR.getText().toString())
                                x, y), "DataSet1");
                        Log.e("Essi", "X: " + String.valueOf(x) + "***");
                        Log.e("Essi", "Y: " + String.valueOf(y) + "***");
                        dataSets.add(lineDataSet1);
                        LineData data = new LineData(dataSets);
                        MP_LINE_CHART.setData(data);
                        MP_LINE_CHART.setDrawGridBackground(true);
                        MP_LINE_CHART.setDrawBorders(true);
                        MP_LINE_CHART.setBorderColor(Color.RED);
                        lineDataSet1.setLineWidth(4);
                        lineDataSet1.setColor(Color.RED);
                        lineDataSet1.setDrawCircles(true);
                        //lineDataSet1.setCircleHoleRadius(45);
                        // lineDataSet1.setCircleRadius(45);
                        lineDataSet1.setDrawHorizontalHighlightIndicator(true);
                        lineDataSet1.getIconsOffset();

                        MP_LINE_CHART.invalidate();
                        //MyResult result = something(x,y);
                        //System.out.println(result.getFirst() + result.getSecond());

                    }

                });
    }
  */