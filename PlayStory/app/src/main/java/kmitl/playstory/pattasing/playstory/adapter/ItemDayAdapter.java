package kmitl.playstory.pattasing.playstory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.controller.MyDiaryTable;

public class ItemDayAdapter extends RecyclerView.Adapter<HolderDay>{
    private List<MyDiaryTable> itemDayList;
    private Context context;

    public ItemDayAdapter(Context context) {
        this.context = context;
    }

    public void setItemDayList(List<MyDiaryTable> itemDayList) {
        this.itemDayList = itemDayList;
    }

    @Override
    public HolderDay onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_day_diary,null,false);
        HolderDay holderDay = new HolderDay(itemView);
        return holderDay;
    }

    @Override
    public void onBindViewHolder(HolderDay holder, int position) {
        ImageView image = holder.image;
        String imageUrl = itemDayList.get(position).getCharacter();

        TextView textViewDay = holder.textDate;
        String textDay = itemDayList.get(position).getDate();

        Glide.with(context).load(imageUrl).into(image);
        textViewDay.setText(textDay);
    }

    @Override
    public int getItemCount() {
        return itemDayList.size();
    }
}

class HolderDay extends RecyclerView.ViewHolder{

    ImageView image;
    TextView textDate;

    public HolderDay(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageViewInListDay);
        textDate = (TextView) itemView.findViewById(R.id.textViewInListDay);
    }
}
