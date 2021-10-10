package com.example.pro3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {
    private  int resourceId;
    public  AnimalAdapter(Context context,
                          int textViewResourceId,
                          List<Animal> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View coverView, ViewGroup parent){
        Animal animal = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView animalImage = (ImageView) view.findViewById(R.id.animal_view);
        TextView animalNmae = (TextView) view.findViewById(R.id.animal_name);
        animalImage.setImageResource(animal.getImageId());
        animalNmae.setText(animal.getName());
        return view;
    }
}
