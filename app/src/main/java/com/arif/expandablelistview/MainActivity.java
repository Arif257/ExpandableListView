package com.arif.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewId);
        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);


    }
    public void prepareListData(){
        String[] headerString = getResources().getStringArray(R.array.abbreviation_list_header);
        String[] childString = getResources().getStringArray(R.array.abbreviations_list_child);
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i=0; i<headerString.length; i++){
            //adding header data
            listDataHeader.add(headerString[i]);
            List<String> child = new ArrayList<>();
            child.add(childString[i]);
            listDataChild.put(listDataHeader.get(i),child);

        }
    }

}