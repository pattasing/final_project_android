package kmitl.playstory.pattasing.playstory.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.model.SelectIconTime;

public class IconTimeAdapter extends RecyclerView.Adapter<Holder>{

    private List<String> iconList;
    private Context context;

    int selectedPosition=-1;

    public IconTimeAdapter(Context context) {
        this.context = context;
        iconList = new ArrayList<>();
    }

    public void setIconList(List<String> iconList){
        this.iconList = iconList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_icon_time, null, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        ImageView imageIcon = holder.imageIcon;
        String imageUrl = iconList.get(position);
        Glide.with(context).load(imageUrl).into(imageIcon);

        if(selectedPosition==position)
            holder.itemView.setBackgroundColor(Color.parseColor("#7fC0D7E1"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#00ffffff"));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition=position;
                notifyDataSetChanged();
                SelectIconTime selectIconTime = SelectIconTime.getSelectIconTimeInstance();
                selectIconTime.setUrlIcon(iconList.get(position));
                Toast.makeText(context,"Icon Selected!",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }
}

class Holder extends RecyclerView.ViewHolder {

    public ImageView imageIcon;

    public Holder(View itemView) {
        super(itemView);
        imageIcon = (ImageView) itemView.findViewById(R.id.imageIconView);
    }
}
