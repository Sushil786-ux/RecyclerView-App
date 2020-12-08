package com.example.recyclerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;
    ArrayList<ModelClass>listitem=new ArrayList<ModelClass>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle=findViewById(R.id.recycle);

        listitem.add(new ModelClass("Sushil","1205",R.drawable.ic_launcher_background));
        listitem.add(new ModelClass("Amit","3938",R.drawable.ic_launcher_background));
        listitem.add(new ModelClass("Rakesh","7063",R.drawable.ic_launcher_background));

        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(llm);
        recycleradapter adapter=new recycleradapter(listitem);
        recycle.setAdapter(adapter);
    }

    class recycleradapter extends RecyclerView.Adapter<recycleradapter.MyViewHolder>{
        List<ModelClass>list;

        public recycleradapter(List<ModelClass> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public recycleradapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null);
            recycleradapter.MyViewHolder viewHolder=new recycleradapter.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull recycleradapter.MyViewHolder holder, int position) {
            holder.names.setText(list.get(position).getName());
            holder.ids.setText(list.get(position).getId());

            Picasso.with(getApplicationContext()).load(list.get(position).getImg())
                    .placeholder(listitem.get(position).getImg()).into(holder.imgs);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView names,ids;
            ImageView imgs;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                names=itemView.findViewById(R.id.names);
                ids=itemView.findViewById(R.id.ids);
                imgs=itemView.findViewById(R.id.imgs);
            }
        }
    }
}
