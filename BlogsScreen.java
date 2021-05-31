package com.example.texttospeech;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BlogsScreen extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"A Castle Full Of Bacals","A Change Of Seasons","A Day In The Life","A Door Into Summer","A Great Day for Freedom","A House Divided"};
    String mDescription[] = {"Deep Purple","Dream Theatre","The Beasters","Joe Satriani","Pink Floyd","Metallica"};
    int images[] = {R.drawable.ic_baseline_play_circle_filled_24,R.drawable.ic_baseline_play_circle_filled_24,R.drawable.ic_baseline_play_circle_filled_24,R.drawable.ic_baseline_play_circle_filled_24,R.drawable.ic_baseline_play_circle_filled_24,R.drawable.ic_baseline_play_circle_filled_24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlistscreen);

        listView = findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImages[];

        MyAdapter (Context c,String title[],String description[],int images[]) {
            super(c,R.layout.row,R.id.textView1,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImages = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images =row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }

}