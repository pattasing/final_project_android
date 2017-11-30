package kmitl.playstory.pattasing.playstory.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kmitl.playstory.pattasing.playstory.AddStoryDate;
import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.adapter.IconChaAdapter;
import kmitl.playstory.pattasing.playstory.model.IconChaList;
import kmitl.playstory.pattasing.playstory.model.SelectIconTime;

public class IconChaFragment extends DialogFragment{

    private List<String> imageIcon;
    private IconChaList iconChaList = new IconChaList();

    RecyclerView recyclerView;
    IconChaAdapter iconChaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfragmrnt_icon_list, container);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);

        imageIcon = iconChaList.getIconChaList();

        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));

        iconChaAdapter = new IconChaAdapter(this.getActivity());
        iconChaAdapter.setIconList(imageIcon);
        recyclerView.setAdapter(iconChaAdapter);
        this.getDialog().setTitle("Select Character");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SelectIconTime selectIconTime = SelectIconTime.getSelectIconTimeInstance();
        String url = selectIconTime.getUrlIcon();
        ((AddStoryDate)getActivity()).getIconCha(url);
    }
}
