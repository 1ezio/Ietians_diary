package com.iet.ietiansdiary.log;

public class pdf_model {

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String ptitle;

    public pdf_model(String ptitle, String purl) {
        this.ptitle = ptitle;
        this.purl = purl;
    }

    public String purl;
}
