package com.icaboalo.aplications.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.icaboalo.aplications.R;
import com.icaboalo.aplications.io.model.EntryApiModel;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by icaboalo on 12/05/16.
 */
public class EntryBaseAdapter extends BaseAdapter {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<EntryApiModel> entryList;
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    private LayoutInflater mInflater;

    public EntryBaseAdapter(Context context, ArrayList<EntryApiModel> entryList) {
        mInflater = LayoutInflater.from(context);
        this.entryList = entryList;
    }

    public void addItem(final EntryApiModel item) {
        entryList.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final EntryApiModel item) {
        entryList.add(item);
        sectionHeader.add(entryList.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return entryList.size();
    }

    @Override
    public String getItem(int position) {
        return entryList.get(position).getName().getLabel();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(android.R.layout.simple_list_item_1, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.text);
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(android.R.layout.simple_list_item_2, null);
                    holder.textView = (TextView) convertView.findViewById(android.R.id.text2);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(entryList.get(position).getName().getLabel());

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }

}
