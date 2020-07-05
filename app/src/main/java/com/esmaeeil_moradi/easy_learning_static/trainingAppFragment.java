package com.esmaeeil_moradi.easy_learning_static;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.esmaeeil_moradi.easy_learning_static.analysisOfBeam.AnalysisOfBeamActivity;
import com.esmaeeil_moradi.easy_learning_static.converter.ConverterActivity;
import com.esmaeeil_moradi.easy_learning_static.equilibrium.Equilibrium2DActivity;

public class trainingAppFragment extends ListFragment {
//    public trainingAppFragment() {
//    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.contentsTraining)
        );
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);


    }

    //create Click Listener for ListFragment
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.e("Essi", String.valueOf(id));
        switch ((int) id) {
            case 0:
                Log.e("Essi", "Id is valid IS 0");
                Intent intentConverter = new Intent(getActivity(),ConverterActivity.class);
                startActivity(intentConverter );

                break;
            case 1:
                Log.e("Essi", "Id is valid IS 1");
                Intent intentEquilibrium = new Intent(getActivity(),Equilibrium2DActivity.class);
                startActivity(intentEquilibrium);
                break;
            case 2:
                Intent intentAnalysisOfBeam = new Intent(getActivity(),AnalysisOfBeamActivity.class);
                startActivity(intentAnalysisOfBeam);
                Log.e("Essi", "Id is valid IS 2");
                break;
            case 3:
                Log.e("Essi", "Id is valid IS 3");
                break;
            case 4:
                Log.e("Essi", "Id is valid IS 4");
                break;
            case 5:
                Log.e("Essi", "Id is valid IS 5");
                break;
            case 6:
                Log.e("Essi", "Id is valid IS 6");
                break;
            case 7:
                Log.e("Essi", "Id is valid IS 7");
                break;
            case 8:
                Log.e("Essi", "Id is valid IS 8");
                break;
            case 9:
                Log.e("Essi", "Id is valid IS 9");
                break;

        }


        super.onListItemClick(l, v, position, id);
    }


}
