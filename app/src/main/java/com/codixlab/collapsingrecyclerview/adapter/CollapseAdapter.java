package com.codixlab.collapsingrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.util.animation.Animations;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CollapseAdapter extends RecyclerView.Adapter<CollapseAdapter.ViewHolder> {

    Context context;
    List<Person> personList;

    public CollapseAdapter(Context context, List<Person> list) {

        this.context = context;
        this.personList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_expand, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

        holder.name.setText(personList.get(i).getName());

        Picasso.get().load(personList.get(i).getImage()).into(holder.imageView);

        holder.viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean show = toggleLayout(!personList.get(i).isExpanded(), v, holder.layoutExpand);
                personList.get(i).setExpanded(show);
            }
        });


//        if(personList.get(i).isExpanded()){
//
//            holder.layoutExpand.setVisibility(View.VISIBLE);
//        }else {
//            holder.layoutExpand.setVisibility(View.GONE);
//        }


    }

    private boolean toggleLayout(boolean b, View v, LinearLayout layoutExpand) {
        Animations.toggleArrow(v, b);
        if (b) {
            Animations.expand(layoutExpand);
        } else {
            Animations.collapse(layoutExpand);
        }

        return b;

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layoutExpand;
        ImageButton viewMore;
        CircleImageView imageView;

        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            layoutExpand = itemView.findViewById(R.id.layoutExpand);
            viewMore = itemView.findViewById(R.id.viewMoreBtn);
        }
    }
}
