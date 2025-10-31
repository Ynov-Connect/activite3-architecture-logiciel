package com.jad.api;

public interface IApplication {
    void manageOrder(UserAction userAction);

    IDataManager getDataManager();
}

