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
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class IconTimeListFragment extends DialogFragment{

    private List<String> imageIcon = new ArrayList<>();

    RecyclerView recyclerView;
    IconTimeAdapter iconViewAdapter;

    ImageView imageAddIconTime;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfragmrnt_icon_list, container);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);

        imageIcon.add("https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconTime%2FIconTime%2F1.png?alt=media&token=e0a463dd-44d2-474f-89b9-9342abf7c8bf");
        imageIcon.add("https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconTime%2FIconTime%2F2.png?alt=media&token=b16abc79-2002-4720-b1d6-d6d4f55459ec");
        imageIcon.add("https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconTime%2FIconTime%2F3.png?alt=media&token=ae1f7f5a-757e-4fc8-a72d-513b7cfed0a6");
        imageIcon.add("https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconTime%2FIconTime%2F4.png?alt=media&token=e7cc3656-0a55-49e6-9be2-422532a9d4fd");

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
        imageIcon.clear();
    }
}
