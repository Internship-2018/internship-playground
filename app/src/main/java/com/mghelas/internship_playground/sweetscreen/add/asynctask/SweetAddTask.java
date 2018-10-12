package com.mghelas.internship_playground.sweetscreen.add.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.entity.Sweet;

public class SweetAddTask extends AsyncTask<Sweet, Void, Long> {

    private SweetAddCallback addSweetCallback;

    public SweetAddTask(SweetAddCallback addSweetCallback) {
        this.addSweetCallback = addSweetCallback;
    }

    @Override
    protected Long doInBackground(Sweet... sweet) {
        Log.d("SweetAddTask", "doInBackground");
        return DbHelper.getInstance(App.getInstance().getApplicationContext()).add(sweet[0]);
    }

    @Override
    protected void onPostExecute(Long id) {
        super.onPostExecute(id);
        addSweetCallback.onSweetAdded();
    }


}
