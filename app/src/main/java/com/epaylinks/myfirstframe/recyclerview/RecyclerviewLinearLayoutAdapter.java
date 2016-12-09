package com.epaylinks.myfirstframe.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epaylinks.myfirstframe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/12/8.
 */

public class RecyclerviewLinearLayoutAdapter extends RecyclerView.Adapter<RecyclerviewLinearLayoutAdapter.ViewHolder>{
    private List<String> strs=new ArrayList<String>();
    private recyclerClickListener l;

    public RecyclerviewLinearLayoutAdapter(List<String> strs){
        this.strs.addAll(strs);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_listview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewLinearLayoutAdapter.ViewHolder holder, final int position) {
        holder.tv_list_item.setText(strs.get(position));
        Random random=new Random();
        ViewGroup.LayoutParams lp= holder.tv_list_item.getLayoutParams();
        lp.height=random.nextInt(5)*100;
        lp.width=200;
        holder.itemView.setLayoutParams(lp);
        if(l!=null){
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     l.onClickListener(position);
                 }
             });
             holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        l.onLongClickListener(position);
                        return false;
                    }
                });
        }
    }


    @Override
    public int getItemCount() {
        return strs.size();
    }
    public void setOnClickListener(recyclerClickListener l){
        this.l=l;
    }
    public void addItem(String str,int postion){
        strs.add(postion,str);
        notifyItemInserted(postion);
    }

    public void removeItem(int postion){
        strs.remove(postion);
        notifyItemRemoved(postion);
    }

    public interface recyclerClickListener{
         void onClickListener(int position);
         void onLongClickListener(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_list_item;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_list_item = (TextView) itemView.findViewById(R.id.tv_list_item);
        }

    }
}
