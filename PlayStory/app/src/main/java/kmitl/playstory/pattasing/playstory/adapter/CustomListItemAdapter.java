package kmitl.playstory.pattasing.playstory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.controller.MyDiaryTable;

public class CustomListItemAdapter extends ArrayAdapter<MyDiaryTable>{

    private List<MyDiaryTable> myDiaryTableList;
    private Context context;
    private int resource;

    public CustomListItemAdapter(@NonNull Context context, int resource, @NonNull List<MyDiaryTable> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.myDiaryTableList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageIconAnimation);

        Glide.with(context).load(myDiaryTableList.get(position).getIcon()).into(imageView);

        return view;
    }
}
