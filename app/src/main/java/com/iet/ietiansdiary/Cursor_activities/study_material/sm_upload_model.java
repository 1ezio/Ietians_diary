package com.iet.ietiansdiary.Cursor_activities.study_material;

public class sm_upload_model {
    public String smname;
    public String smurl;

    public String getSmname() {
        return smname;
    }

    public String getSmurl() {
        return smurl;
    }

    public sm_upload_model(String smname, String smurl) {
        this.smname = smname;
        this.smurl = smurl;
    }

    public sm_upload_model() {
    }
}
