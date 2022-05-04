package com.mynew.poradnikksrg.ui.adr;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdrViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AdrViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    boolean flagExpand = false;
    String subName = "";
    String subsOnzNum = "";
    String subProcNum = "";

}

// paste to adrFragment

// VieW Model
//        if (adrViewModel.flagExpand == true) {
//
//                // setting text views
//                onzText.setText(adrViewModel.subsOnzNum);
//                procedureText.setText(adrViewModel.subProcNum);
//                nameText.setText(adrViewModel.subName);
//                for (ProcedureClass p : procedures) {
//                if (p.getpNumber() != null && p.getpNumber().contains(adrViewModel.subProcNum)) {
//                procDescription.setText(p.getpDescription());
//                foreText.setText(p.getpForE());
//                effectText.setText(p.getpEffect());
//                principlesText.setText(p.getpRelease());
//                clothingText.setText(p.getpClothing());
//                evacuationText.setText(p.getpEvacuation());
//                fireText.setText(p.getpFire());
//                eorlText.setText(p.getpEorL());
//                firstAidText.setText(p.getpFirstAid());
//
//                break;
//                }
//                }
//
//                // expand layout
//                infoAppLayout.setVisibility(View.GONE);
//                specSubsLayout.setVisibility(View.VISIBLE);
//                expand(specSubsLayout);
//                subsDescLayout.setVisibility(View.VISIBLE);
//                expand(subsDescLayout);
//
//
//                }

