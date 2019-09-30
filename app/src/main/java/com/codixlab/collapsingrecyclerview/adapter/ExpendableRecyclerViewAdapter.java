package com.codixlab.collapsingrecyclerview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.databinding.ItemExpandBinding;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.util.animation.Animations;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExpendableRecyclerViewAdapter extends RecyclerView.Adapter<ExpendableRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Person> personList;

    public ExpendableRecyclerViewAdapter(Context context, List<Person> list) {

        this.context = context;
        this.personList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_expand, null);
        ItemExpandBinding bi = DataBindingUtil.bind(view);
        return new ViewHolder(bi);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

        holder.bi.name.setText(personList.get(i).getName());

        Picasso.get().load(personList.get(i).getImage()).into(holder.bi.image);

        holder.bi.viewMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean show = toggleLayout(!personList.get(i).isExpanded(), v, holder.bi.layoutExpand);
                personList.get(i).setExpanded(show);
            }
        });

    }

    private boolean toggleLayout(boolean isExpanded, View v, LinearLayout layoutExpand) {
        Animations.toggleArrow(v, isExpanded);
        if (isExpanded) {
            Animations.expand(layoutExpand);
        } else {
            Animations.collapse(layoutExpand);
        }
        return isExpanded;

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemExpandBinding bi;

        public ViewHolder(@NonNull ItemExpandBinding itemView) {
            super(itemView.getRoot());

            bi = itemView;

        }
    }
}
