package com.iet.ietiansdiary.navigation_activities.developers.clubs;

public class cmodel { public String mId, mTitle, mDesc;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public cmodel(String mId, String mTitle, String mDesc) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mDesc = mDesc;
    }

    public cmodel() {
    }

}
