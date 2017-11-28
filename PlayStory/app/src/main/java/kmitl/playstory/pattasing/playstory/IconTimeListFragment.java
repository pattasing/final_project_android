package kmitl.playstory.pattasing.playstory;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kmitl.playstory.pattasing.playstory.model.IconTimeList;
import kmitl.playstory.pattasing.playstory.model.ItemTime;
import kmitl.playstory.pattasing.playstory.model.SelectIconTime;

public class IconTimeListFragment extends DialogFragment{

    private List<String> imageIcon;
    private IconTimeList iconTimeList = new IconTimeList();

    RecyclerView recyclerView;
    IconTimeAdapter iconViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfragmrnt_icon_list, container);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);

        imageIcon = iconTimeList.getIconList();

        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));

        iconViewAdapter = new IconTimeAdapter(this.getActivity());
        iconViewAdapter.setIconList(imageIcon);
        recyclerView.setAdapter(iconViewAdapter);

        this.getDialog().setTitle("Select Icon");

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SelectIconTime selectIconTime = SelectIconTime.getSelectIconTimeInstance();
        String url = selectIconTime.getUrlIcon();
        ((AddItemDate)getActivity()).getIconTime(url);
    }
}
