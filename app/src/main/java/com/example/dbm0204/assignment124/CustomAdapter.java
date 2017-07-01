package com.example.dbm0204.assignment124;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dbm0204 on 7/1/17.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<Person> arrayList;
    Context context;

    public CustomAdapter(ArrayList<Person> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context=context;
    }
    @Override
    public int getCount(){
        return arrayList.size();
    }
    @Override
    public Object getItem(int position){
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position){
        return (long)position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(context).inflate(R.layout.list_raw,null);
        //Setting TextViews with their IDs in the layout file.
        TextView name_tv=(TextView)convertView.findViewById(R.id.name_tv);
        TextView phone_tv=(TextView)convertView.findViewById(R.id.phone_tv);
        TextView dob_tv=(TextView)convertView.findViewById(R.id.dob_tv);

        //Setting text to the TextViews.
        name_tv.setText(arrayList.get(position).getName());
        phone_tv.setText(arrayList.get(position).getPhoneNumber());
        dob_tv.setText(arrayList.get(position).getDateBirth());
        return convertView;    //returning View.
    }
}
