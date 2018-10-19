package com.mghelas.internship_playground.ui.sweetscreen.list.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.DeleteClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.list.ItemClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetAdapter;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListFragment;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListNativeView;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListView;
import com.mghelas.internship_playground.ui.sweetscreen.list.SwipeHandler;

import java.util.ArrayList;
import java.util.List;

public class SweetListViewImpl implements SweetListView, SweetListNativeView {

    private ItemClickHandler itemClickHandler;
    private DeleteClickHandler deleteClickHandler;
    private SwipeHandler swipeHandler;

    private TextView emptyText;
    private RecyclerView recyclerView;
    private ConstraintLayout listLayout;
    private RecyclerView.LayoutManager layoutManager;
    private SweetListFragment sweetListFragment;
    private Button deleteButton;
    private EditText confectionerName;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SweetAdapter sweetAdapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_list;
    }

    @Override
    public void initView(SweetListFragment sweetListFragment, SweetListPresenter sweetListPresenter) {
        this.sweetListFragment = sweetListFragment;
        recyclerView = sweetListFragment.getView().findViewById(R.id.fragment_sweet_list);
        listLayout = sweetListFragment.getView().findViewById(R.id.list_layout);
        emptyText = sweetListFragment.getView().findViewById(R.id.empty_view);
        deleteButton = sweetListFragment.getView().findViewById(R.id.delete_by_confectioner_name_btn);
        confectionerName = sweetListFragment.getView().findViewById(R.id.confectioner_name_delete);
        swipeRefreshLayout = sweetListFragment.getView().findViewById(R.id.swipe_refresh);
        sweetAdapter = new SweetAdapter(new ArrayList<Sweet>(), sweetListPresenter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onSwipe();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteClicked(confectionerName.getText().toString());
            }
        });
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(sweetListFragment.getView().getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sweetAdapter);
        bindData(new ArrayList<Sweet>());
    }

    private void onSwipe() {
        if (swipeHandler != null) {
            swipeHandler.onSwiped();
        }
    }

    private void onDeleteClicked(String name) {
        if (deleteClickHandler != null) {
            deleteClickHandler.onDeleteClicked(name);
        }
    }

    public void bindData(List<Sweet> sweets) {
        swipeRefreshLayout.setRefreshing(false);
        confectionerName.setText("");
        if (sweets.isEmpty()) {
            showEmpty();
        } else {
            sweetAdapter.updateData(sweets);
            listLayout.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String error) {
        swipeRefreshLayout.setRefreshing(false);
        Toast toast = Toast.makeText(sweetListFragment.getContext(),
                error,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    private void showEmpty() {
        listLayout.setVisibility(View.GONE);
        emptyText.setVisibility(View.VISIBLE);
    }


    @Override
    public void setOnItemClickHandler(ItemClickHandler itemClickHandler) {
        this.itemClickHandler = itemClickHandler;
    }

    @Override
    public void setOnDeleteClickHandler(DeleteClickHandler deleteClickHandler) {
        this.deleteClickHandler = deleteClickHandler;
    }

    @Override
    public void setOnSwipeHandler(SwipeHandler swipeHandler) {
        this.swipeHandler = swipeHandler;
    }
}
