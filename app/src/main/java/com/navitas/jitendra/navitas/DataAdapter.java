package com.navitas.jitendra.navitas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jitendra on 2/2/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private final ArrayList<String> emp;

    public DataAdapter(ArrayList<String> emp) {
        this.emp = emp;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.navitas_emp.setText(emp.get(i));
    }

    @Override
    public int getItemCount() {
        return emp.size();
    }

    public void addItem(String emp_name) {
        emp.add(emp_name);
        notifyItemInserted(emp.size());
    }

    public void removeItem(int position) {
        emp.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, emp.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView navitas_emp;
        public ViewHolder(View view) {
            super(view);

            navitas_emp = (TextView)view.findViewById(R.id.navitas_emp);
        }
    }
}