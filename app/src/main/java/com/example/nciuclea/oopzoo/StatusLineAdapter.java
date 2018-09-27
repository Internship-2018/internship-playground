package com.example.nciuclea.oopzoo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class StatusLineAdapter extends RecyclerView.Adapter<StatusLineAdapter.StatusLineViewHolder> {

    private List<AnimalStatusLine> mDataSet;

    private OnItemTouchListener buttonTouchListener;
    public interface OnItemTouchListener {
        void onItemTouch(View view, int position, boolean type, String name);
    }

    public StatusLineAdapter(List<AnimalStatusLine> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public static class StatusLineViewHolder extends RecyclerView.ViewHolder {

        TextView statusLineName;
        RatingBar statusLineRating;
        TextView statusLineButton;
        public StatusLineViewHolder(@NonNull View itemView) {
            super(itemView);
            statusLineName = itemView.findViewById(R.id.statusline_text);
            statusLineRating = itemView.findViewById(R.id.statusline_ratingbar);
            statusLineButton = itemView.findViewById(R.id.statusline_button);
        }
    }
    @NonNull
    @Override
    public StatusLineAdapter.StatusLineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View statusLineView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.partial_statusline, viewGroup,false);
        StatusLineViewHolder statusLineViewHolder = new StatusLineViewHolder(statusLineView);
        viewGroup.requestDisallowInterceptTouchEvent(true);
        return statusLineViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final StatusLineAdapter.StatusLineViewHolder statusLineViewHolder, final int i) {
        statusLineViewHolder.statusLineName.setText(mDataSet.get(i).getStatusName());
        statusLineViewHolder.statusLineRating.setRating(mDataSet.get(i).getStatusRating());
        statusLineViewHolder.statusLineButton.setText(mDataSet.get(i).getStatusButtonName());
        statusLineViewHolder.statusLineButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String name = statusLineViewHolder.statusLineName.getText().toString();
                if(buttonTouchListener != null){
                    String DEBUG_TAG = "TapAction";
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            buttonTouchListener.onItemTouch(v, i, true, name);
                            return true;
                            //sadly, it never happens...
                        case MotionEvent.ACTION_UP:
                            buttonTouchListener.onItemTouch(v, i, false, name);
                            return true;
                        /*case (MotionEvent.ACTION_DOWN) :
                            Log.d(DEBUG_TAG,"Action was DOWN");
                            statusLineViewHolder.statusLineButton.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        case (MotionEvent.ACTION_MOVE) :
                            Log.d(DEBUG_TAG,"Action was MOVE");
                            return true;
                        case (MotionEvent.ACTION_POINTER_UP) :
                            Log.d(DEBUG_TAG,"Action was POINTER_UP");
                            return true;
                        case (MotionEvent.ACTION_CANCEL) :
                            Log.d(DEBUG_TAG,"Action was CANCEL");
                            return true;
                        default:
                            Log.d(DEBUG_TAG, String.valueOf(event.getAction())); */

                    }
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setOnItemTouch(OnItemTouchListener listener) {
        this.buttonTouchListener = listener;
    }
}
