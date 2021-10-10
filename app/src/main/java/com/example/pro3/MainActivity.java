package com.example.pro3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Animal> animalList = new ArrayList<>();
    private String[] data ={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAnimals();
        AnimalAdapter adapter = new AnimalAdapter(MainActivity.this, R.layout.animal_item, animalList);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Animal anlmal = animalList.get(position);
                Toast.makeText(MainActivity.this, anlmal.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void initAnimals(){
        for (int i=0;i<1;i++){
            Animal Lion = new Animal("Lion",R.drawable.lion);
            animalList.add(Lion);
            Animal Tiger = new Animal("Tiger",R.drawable.tiger);
            animalList.add(Tiger);
            Animal Monkey = new Animal("Monkey",R.drawable.monkey);
            animalList.add(Monkey);
            Animal Dog = new Animal("Dog",R.drawable.dog);
            animalList.add(Dog);
            Animal Cat = new Animal("Cat",R.drawable.cat);
            animalList.add(Cat);
            Animal Elephant = new Animal("Elephantt",R.drawable.elephant);
            animalList.add(Elephant);
        }
    }
}
