package com.mynew.poradnikksrg.ui.kpp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mynew.poradnikksrg.R;

import com.mynew.poradnikksrg.KPPAdapter;
import com.mynew.poradnikksrg.KPPData;

public class KppFragment extends Fragment {

    private KppViewModel kppViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        kppViewModel =
                ViewModelProviders.of(this).get(KppViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kpp, container, false);
        kppViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        KPPData[] kppData = new KPPData[]{
                new KPPData("Sekwencja założeń taktycznych w ratownictwie " +
                        "medycznym", "1", R.drawable.procedura1),
                new KPPData("Sekwencja założeń taktycznych w ratownictwie medycznym\n" +
                        "w przypadku osoby podejrzanej o zakażenie lub zakażonej czynnikiem\n" +
                        "biologicznym", "1a", R.drawable.procedura1a),
                new KPPData("Sekwencja medycznych działań ratowniczych", "2", R.drawable.procedura2),
                new KPPData("Sekwencja medycznych działań ratowniczych\n" +
                        "podczas postępowania z osobą podejrzaną o zakażenie zakaźnym czynnikiem biologicznym " +
                        "lub z osobą z potwierdzonym zakażeniem zakaźnym czynnikiem biologicznym", "2a", R.drawable.procedura2a),
                new KPPData("Postępowanie w zatrzymaniu krążenia u dorosłych " +
                        "(RKO)", "3", R.drawable.procedura3),
                new KPPData("Postępowanie w zatrzymaniu krążenia u " +
                        "noworodków, niemowląt, dzieci (RKO)", "4", R.drawable.procedura4),
                new KPPData("Obrażenia i podejrzenie obrażeń głowy", "5", R.drawable.procedura5),
                new KPPData("Obrażenia i podejrzenie obrażeń kręgosłupa", "6", R.drawable.procedura6),
                new KPPData("Obrażenia i podejrzenie obrażeń klatki piersiowej", "7", R.drawable.procedura7),
                new KPPData("Obrażenia i podejrzenie obrażeń brzucha", "8", R.drawable.procedura8),
                new KPPData("Obrażenia i podejrzenie obrażeń miednicy", "9", R.drawable.procedura9),
                new KPPData("Obrażenia i podejrzenie obrażenia narządu ruchu", "10", R.drawable.procedura10),
                new KPPData("Rany", "11", R.drawable.procedura11),
                new KPPData("Amputacja urazowa", "12", R.drawable.procedura12),
                new KPPData("Wstrząs hipowolemiczny – postępowanie wstępne", "13", R.drawable.procedura13),
                new KPPData("Oparzenie termiczne", "14", R.drawable.procedura14),
                new KPPData("Oparzenie chemiczne", "15", R.drawable.procedura15),
                new KPPData("Zatrucie wziewne", "16", R.drawable.procedura16),
                new KPPData("Tonięcie", "17", R.drawable.procedura17),
                new KPPData("Wychłodzenie", "18", R.drawable.procedura18),
                new KPPData("Zaburzenia krążeniowo – oddechowe w stanach " +
                        "nieurazowych", "19", R.drawable.procedura19),
                new KPPData("Drgawki", "20", R.drawable.procedura20),
                new KPPData("Kobieta w widocznej ciąży w stanie zagrożenia " +
                        "życia/zdrowia", "21", R.drawable.procedura21)

        };

        KPPAdapter kppAdapter = new KPPAdapter(kppData, getActivity());
        recyclerView.setAdapter(kppAdapter);

        return root;
    }
}