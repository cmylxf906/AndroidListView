实验三：Android ListView的用法

代码如下：
Animal.java
package com.example.pro3;

public class Animal {
    private String  name;
    private  int imageId;
    public Animal(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}



AnimalAdapter.java


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



MainAactivity.java

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


activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</LinearLayout>



anmimal_item.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/animal_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:paddingTop="30dp"
        android:textSize="30dp"
        />

    <ImageView
        android:id="@+id/animal_view"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="280dp"
        android:layout_marginTop="-60dp"/>

</LinearLayout>

