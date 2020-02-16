package com.iet.ietiansdiary.navigation_activities.developers.contributors;

public class clist_data {
    private String mName;
    private String mImgUrl;
    public clist_data(){

    }
    public clist_data(String name,String imgUrl){
        if (name.trim().equals("")){
            name="No Name";
        }
        mName=name;
        mImgUrl=imgUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName=name;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        mImgUrl=imgUrl;
    }
}
