package kmitl.playstory.pattasing.playstory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class IconTimeAdapter extends RecyclerView.Adapter<Holder>{

    private List<String> iconList;
    private Context context;

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
    public void onBindViewHolder(Holder holder, int position) {
        ImageView imageIcon = holder.imageIcon;
        String imageUrl = iconList.get(position);
        Glide.with(context).load(imageUrl).into(imageIcon);
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
