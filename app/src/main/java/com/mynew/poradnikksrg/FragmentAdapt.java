package com.mynew.poradnikksrg;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mynew.poradnikksrg.ui.adr.AdrFragment;
import com.mynew.poradnikksrg.ui.kpp.KppFragment;

import org.jetbrains.annotations.NotNull;

public class FragmentAdapt extends FragmentStateAdapter {
    public FragmentAdapt(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new AdrFragment();

        }

        return new KppFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
