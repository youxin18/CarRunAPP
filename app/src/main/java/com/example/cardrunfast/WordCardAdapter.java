package com.example.cardrunfast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordCardAdapter extends RecyclerView.Adapter<WordCardAdapter.ViewHolder> {
    private List<Card> mcardList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_word_card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = mcardList.get(position);
        holder.text.setText(card.getName());
        holder.complain.setText(card.getNumber());


    }

    @Override
    public int getItemCount() {
        return mcardList.size();
    }
    public WordCardAdapter(List<Card> cardList){
        mcardList=cardList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private TextView complain;

        public ViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.item_word);
            complain = view.findViewById(R.id.item_translation);

        }

    }




}
