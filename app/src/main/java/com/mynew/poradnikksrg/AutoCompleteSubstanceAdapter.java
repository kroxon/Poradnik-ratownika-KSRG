package com.mynew.poradnikksrg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.mynew.poradnikksrg.R;

import java.util.ArrayList;
import java.util.List;


public class AutoCompleteSubstanceAdapter extends ArrayAdapter<Substances> {
    private final List<Substances> substanceListFull;

    public AutoCompleteSubstanceAdapter(Context context, List<Substances> substanceList) {
        super(context, 0, substanceList);
        substanceListFull = new ArrayList<>(substanceList);
    }


    @Override
    public Filter getFilter() {
        return substanceFilter;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.substance_autocomplete_row, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.text_view_name);
        TextView textViewONZ = convertView.findViewById(R.id.text_view_onz);

        Substances substances = getItem(position);

        if (substances != null) {
            textViewName.setText(substances.getSubstName());
            textViewONZ.setText(substances.getOnzNumber());
        }

        return convertView;
    }

    private final Filter substanceFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Substances> suggestions = new ArrayList<>();
            List<Substances> suggestions2 = new ArrayList<>();


            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(substanceListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Substances substances : substanceListFull) {
                    if (substances.getSubstName().toLowerCase().contains(filterPattern)) {
                        suggestions.add(substances);
                    }
                    if (substances.getOnzNumber().toLowerCase().contains(filterPattern)) {
                        suggestions.add(substances);
                    }

                }
            }

            // for prevent doubled suggestions
            if (suggestions.size() != 0) {
                suggestions2.add(suggestions.get(0));
                for (int i = 0; i < suggestions.size(); i++) {
                    int w = 0;
                    for (int j = 0; j < suggestions2.size(); j++) {
                        if (suggestions.get(i).getSubstName().equals(suggestions2.get(j).getSubstName())) {
                            w = 0;
                            break;
                        }
                        w = 1;
                    }
                    if (w == 1)
                        suggestions2.add(suggestions.get(i));
                    w = 0;
                }
            }

            results.values = suggestions2;
            results.count = suggestions2.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Substances) resultValue).getSubstName();
        }
    };
}