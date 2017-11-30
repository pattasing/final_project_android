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

public class IconChaAdapter extends RecyclerView.Adapter<ChaHolder>{

    private List<String> iconList;
    private Context context;

    int selectedPosition = -1;

    public IconChaAdapter(Context context) {
        this.context = context;
        iconList = new ArrayList<>();
    }

    public void setIconList(List<String> iconList){
        this.iconList = iconList;
    }

    @Override
    public ChaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_icon_time, null, false);
        ChaHolder holder = new ChaHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ChaHolder holder, final int position) {
        ImageView imageIcon = holder.imageCha;
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
                selectIconTime.setUrlIconCha(iconList.get(position));
                Toast.makeText(context, "Character Selected!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }
}

class ChaHolder extends RecyclerView.ViewHolder{
    public ImageView imageCha;

    public ChaHolder(View itemView) {
        super(itemView);
        imageCha = (ImageView) itemView.findViewById(R.id.imageIconView);
    }
}
