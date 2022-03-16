package com.example.cardrunfast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class hasStudiedFragment extends Fragment {
    private final List<Card> cardList;

    public hasStudiedFragment(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_has_studied_fragment,container,false);

        RecyclerView recyclerView=view.findViewById(R.id.recyclerView_has);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        WordCardAdapter adapter = new WordCardAdapter(cardList);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
