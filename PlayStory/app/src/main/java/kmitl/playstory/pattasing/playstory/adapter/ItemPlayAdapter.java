package kmitl.playstory.pattasing.playstory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.controller.MyDiaryTable;

public class ItemPlayAdapter extends RecyclerView.Adapter<HolderPlay> {

    private List<MyDiaryTable> itemDayList;
    private Context context;

    public ItemPlayAdapter(Context context) {
        this.context = context;
    }

    public void setItemDayList(List<MyDiaryTable> itemDayList) {
        this.itemDayList = itemDayList;
    }

    @Override
    public HolderPlay onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_play_time,null,false);
        HolderPlay holderPlay = new HolderPlay(itemView);
        return holderPlay;
    }

    @Override
    public void onBindViewHolder(HolderPlay holder, int position) {
        ImageView image = holder.image;
        String imageUrl = itemDayList.get(position).getIcon();

        TextView textViewTime = holder.textTime;
        String textTime = itemDayList.get(position).getTime();

        TextView textViewLocation = holder.textLocation;
        String textLocation = itemDayList.get(position).getLocation();

        TextView textViewMessage = holder.textMessage;
        String textMessage = itemDayList.get(position).getMessage();

        Glide.with(context).load(imageUrl).into(image);
        textViewTime.setText("Time : " + textTime);
        textViewLocation.setText("Location : " + textLocation);
        textViewMessage.setText("Message : " + textMessage);
    }

    @Override
    public int getItemCount() {
        return itemDayList.size();
    }
}

class HolderPlay extends RecyclerView.ViewHolder{

    ImageView image;
    TextView textTime;
    TextView textMessage;
    TextView textLocation;

    public HolderPlay(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageViewItemPlay);
        textTime = (TextView)itemView.findViewById(R.id.textViewTimePlay);
        textLocation = (TextView) itemView.findViewById(R.id.textViewLocationPlay);
        textMessage = (TextView) itemView.findViewById(R.id.textViewMessagePlay);
    }
}
