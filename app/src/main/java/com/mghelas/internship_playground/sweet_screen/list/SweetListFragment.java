package com.mghelas.internship_playground.sweet_screen.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListPresenterImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListViewImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListWireframeImpl;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;

public class SweetListFragment extends Fragment implements SweetListView {

    private List<Sweet> sweetsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    SweetListNativeView sweetListNativeView;
    SweetListPresenter sweetListPresenter;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public List<Sweet> getSweetsList() {
        return sweetsList;
    }

    SweetAdapter sweetsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SweetListViewImpl view = new SweetListViewImpl();
        sweetListNativeView = view;
        sweetListPresenter = new SweetListPresenterImpl(view, new SweetListWireframeImpl(this));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sweet_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sweetListNativeView.initView(this);
        sweetListPresenter.onViewInitialised();
        recyclerView = view.findViewById(R.id.fragment_sweet_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        populateView();
    }


    @Override
    public void populateView() {
        sweetPresenter = new SweetListPresenterImpl(this);
        sweetPresenter.setAdapter(new SweetAdapter(sweetPresenter.getAllSweets(), new SweetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                Navigation.findNavController(getView()).navigate(R.id.action_sweetListFragment_to_sweetDetailedFragment, bundle);

            }
        }));
    }

    @Override
    public void add() {

    }
}
