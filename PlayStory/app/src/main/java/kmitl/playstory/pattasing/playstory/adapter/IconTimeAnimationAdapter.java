package kmitl.playstory.pattasing.playstory.adapter;

import android.content.Context;
import android.content.Intent;
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
import kmitl.playstory.pattasing.playstory.controller.AnimationActivity;
import kmitl.playstory.pattasing.playstory.controller.MyDiaryTable;
import kmitl.playstory.pattasing.playstory.model.SelectTimeToShow;

public class IconTimeAnimationAdapter extends RecyclerView.Adapter<HolderAnimation>{

    private List<MyDiaryTable> iconList;
    private Context context;

    public IconTimeAnimationAdapter(Context context) {
        this.context = context;
    }

    public void setIconList(List<MyDiaryTable> iconList){
        this.iconList = iconList;
    }

    @Override
    public HolderAnimation onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.icon_animation_page, null, false);
        HolderAnimation holderAnimation = new HolderAnimation(itemView);
        return holderAnimation;
    }

    @Override
    public void onBindViewHolder(final HolderAnimation holder, final int position) {
        final ImageView imageIcon = holder.image;
        final String imageUrl = iconList.get(position).getIcon();
        Glide.with(context).load(imageUrl).into(imageIcon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            int[] originalPos = new int[2];
            @Override
            public void onClick(View v) {
                imageIcon.getLocationInWindow(originalPos);

                SelectTimeToShow selectTimeToShow = SelectTimeToShow.getSelectTimeToShowInstance();
                selectTimeToShow.setPosY(originalPos[1]);
                selectTimeToShow.setIndexTime(position);

                notifyDataSetChanged();

                Toast.makeText(context, position + " " +originalPos[1] + "  Icon Selected!" + selectTimeToShow.getIndexTime()+" eiei" + selectTimeToShow.getPosY(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }
}

class HolderAnimation extends RecyclerView.ViewHolder {

    ImageView image;

    public HolderAnimation(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageIconAnimation);
    }
}
