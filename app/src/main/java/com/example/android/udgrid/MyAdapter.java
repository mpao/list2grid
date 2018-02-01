package com.example.android.udgrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    private Context context;
    private String[] array;

    public MyAdapter(Context context, String[] array) {
        this.context = context;
        this.array   = array;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.element, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder viewHolder, int position) {
        viewHolder.tv.setText(array[position]);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        private ViewHolder( View itemView ){
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, array[getAdapterPosition()], Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
