package kmitl.playstory.pattasing.playstory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.controller.MainActivity;
import kmitl.playstory.pattasing.playstory.model.ItemTime;

public class ItemTimeAdapter extends RecyclerView.Adapter<HolderItem>{
    private List<ItemTime> itemTimeList;
    private Context context;

    public ItemTimeAdapter(Context context) {
        this.context = context;
        itemTimeList = new ArrayList<>();

    }

    public void setItemTimeList(List<ItemTime> itemTimeList){
        this.itemTimeList = itemTimeList;
    }

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_time, null, false);
        HolderItem holderItem = new HolderItem(itemView);
        return holderItem;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, int position) {
        ImageView image = holder.image;
        String imageUrl = itemTimeList.get(position).getIconUrl();

        TextView textViewTime = holder.textViewTime;
        String textTime = itemTimeList.get(position).getTime();

        TextView textViewMessage = holder.textViewMessage;
        String textMessage = itemTimeList.get(position).getMessage();

        Glide.with(context).load(imageUrl).into(image);
        textViewTime.setText(textTime);
        textViewMessage.setText(textMessage);

    }

    @Override
    public int getItemCount() {
        return itemTimeList.size();
    }

}

class HolderItem extends RecyclerView.ViewHolder{

    ImageView image;
    TextView textViewTime;
    TextView textViewMessage;

    public HolderItem(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageViewIconInList);
        textViewTime = (TextView) itemView.findViewById(R.id.textViewTimeInList);
        textViewMessage = (TextView) itemView.findViewById(R.id.textViewMessageInList);

        textViewTime.setTypeface(MainActivity.font);
        textViewMessage.setTypeface(MainActivity.font);
    }
}