package com.example.cardrunfast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReadOtherAdapter extends RecyclerView.Adapter<ReadOtherAdapter.ViewHolder> {
    private List<Sentence>sentences;
   public ReadOtherAdapter(List<Sentence> mSentence){
       sentences=mSentence;
   }
   static class ViewHolder extends RecyclerView.ViewHolder{
       TextView sentence;
       TextView chinese;
       public ViewHolder(View view){
           super(view);
           sentence=view.findViewById(R.id.sentence);
           chinese=view.findViewById(R.id.chinese);

       }
   }


    @NonNull
    @Override
    public ReadOtherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.read_other_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReadOtherAdapter.ViewHolder holder, int position) {
                Sentence sentence=sentences.get(position);
                holder.sentence.setText(sentence.getSentence());
                holder.chinese.setText(sentence.getChinese());

    }

    @Override
    public int getItemCount() {
        return sentences.size();
    }
}
