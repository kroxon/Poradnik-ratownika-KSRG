package com.mynew.poradnikksrg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mynew.poradnikksrg.R;

public class KPPAdapter extends RecyclerView.Adapter<KPPAdapter.ViewHolder> {

    KPPData[] kppData;
    Context context;

    public KPPAdapter(KPPData[] kppData, FragmentActivity activity) {
        this.kppData = kppData;
        this.context = activity;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kpp_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewHolder holder, int position) {
        final KPPData kppDataList = kppData[position];
        holder.textViewKppName.setText(kppDataList.getKppName());
        holder.textViewKppNumber.setText(kppDataList.getKppNumber()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, kppDataList.getKppName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("name", kppDataList.getKppName());
                intent.putExtra("number", kppDataList.getKppNumber());
                intent.putExtra("image", kppDataList.getKppImage());
                context.startActivity(intent);
            }
        });

//        holder.kppSecondLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, SecondActivity.class);
//                intent.putExtra("name", kppDataList.getKppName());
//                intent.putExtra("number", kppDataList.getKppNumber());
//                intent.putExtra("image", kppDataList.getKppImage());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return kppData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView kppImage;
        TextView textViewKppName;
        TextView textViewKppNumber;
        ConstraintLayout kppSecondLayout;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            textViewKppName = itemView.findViewById(R.id.tViewKppName);
            textViewKppNumber = itemView.findViewById(R.id.tViewKppNumber);
            kppSecondLayout = itemView.findViewById(R.id.secondActivity);
        }
    }
}
