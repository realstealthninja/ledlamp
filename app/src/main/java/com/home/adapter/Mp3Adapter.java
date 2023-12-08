package com.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.home.bean.Mp3;
import com.ledlamp.R;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class Mp3Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Mp3> list;
    private OnSelectListener onSelectListener;
    private int index = -1;
    private HashSet<Mp3> selectSet = new HashSet<>();

    /* loaded from: classes.dex */
    public interface OnSelectListener {
        void onSelect(int i, Mp3 mp3, HashSet<Mp3> hashSet, boolean z, BaseAdapter baseAdapter);
    }

    public Mp3Adapter(Context context, ArrayList<Mp3> arrayList) {
        this.list = arrayList;
        this.context = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.list.get(i).getId();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            ViewHolder viewHolder = new ViewHolder();
            View inflate = View.inflate(this.context, R.layout.item_mp3, null);
            viewHolder.textViewTitle = (TextView) inflate.findViewById(R.id.textViewTitle);
            viewHolder.textViewAblum = (TextView) inflate.findViewById(R.id.textViewAblum);
            viewHolder.textViewSinger = (TextView) inflate.findViewById(R.id.textViewSinger);
            viewHolder.checkBox = (CheckBox) inflate.findViewById(R.id.checkBoxSelect);
            inflate.setTag(viewHolder);
            view = inflate;
        } else {
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
        }
        ViewHolder viewHolder3 = (ViewHolder) view.getTag();
        final Mp3 mp3 = this.list.get(i);
        viewHolder3.textViewTitle.setText(mp3.getTitle());
        viewHolder3.textViewAblum.setText(mp3.getAlbum());
        if ("<unknown>".equalsIgnoreCase(mp3.getArtist())) {
            viewHolder3.textViewSinger.setText(this.context.getResources().getString(R.string.un_known_artist));
        } else {
            viewHolder3.textViewSinger.setText(mp3.getArtist());
        }
        viewHolder3.checkBox.setOnCheckedChangeListener(null);
        if (this.selectSet.contains(mp3)) {
            viewHolder3.checkBox.setChecked(true);
        } else {
            viewHolder3.checkBox.setChecked(false);
        }
        viewHolder3.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.home.adapter.Mp3Adapter.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (Mp3Adapter.this.onSelectListener != null) {
                    Mp3Adapter.this.onSelectListener.onSelect(i, mp3, Mp3Adapter.this.selectSet, z, Mp3Adapter.this);
                }
            }
        });
        return view;
    }

    public void selectAll() {
        this.selectSet.addAll(this.list);
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public HashSet<Mp3> getSelectSet() {
        return this.selectSet;
    }

    public void setSelectSet(HashSet<Mp3> hashSet) {
        this.selectSet = hashSet;
    }

    public OnSelectListener getOnSelectListener() {
        return this.onSelectListener;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.onSelectListener = onSelectListener;
    }

    /* loaded from: classes.dex */
    class ViewHolder {
        CheckBox checkBox;
        TextView textViewAblum;
        TextView textViewSinger;
        TextView textViewTitle;

        ViewHolder() {
        }
    }
}
