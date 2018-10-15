package com.mghelas.internship_playground;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public class StartupModelImpl implements StartupModel {
    private SweetDao sweetDao;
    private SweetServiceCall sweetServiceCall;

    public StartupModelImpl(SweetDao sweetDao) {
        this.sweetDao = sweetDao;
    }

    @Override
    public void updateData() {
        sweetServiceCall.getSweets();
    }

    @Override
    public void syncDb(List<Sweet> sweets) {
        sweetDao.deleteAll();
        for (Sweet sweet : sweets) {
            sweetDao.save(sweet);
        }
    }

    @Override
    public void setSweetServiceCall(SweetServiceCall sweetServiceCall) {
        this.sweetServiceCall = sweetServiceCall;
    }

}
