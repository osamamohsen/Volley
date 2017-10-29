package com.example.osama.volley.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.osama.volley.Models.Contact;
import com.example.osama.volley.R;

import java.util.ArrayList;

/**
 * Created by osama on 10/29/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{


    Context context;
    ArrayList<Contact> arrayList = new ArrayList<>();
    public ContactAdapter(Context context,ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_item,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, final int position) {
        holder.txt_card_name.setText(this.arrayList.get(position).getName());
        holder.txt_card_email.setText(this.arrayList.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = arrayList.get(position).getId();
                Toast.makeText(context, "id:"+message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        public TextView txt_card_name,txt_card_email;

        public ContactViewHolder(View itemView) {
            super(itemView);
            txt_card_name = itemView.findViewById(R.id.txt_crd_name);
            txt_card_email = itemView.findViewById(R.id.txt_crd_email);
        }
    }
}
